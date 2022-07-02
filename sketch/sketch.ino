#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>
#include <ESP8266WiFiMulti.h>
#include <ESP8266WebServer.h>
#include <ArduinoJson.h>
#include <WS2812FX.h>

#define STRIP_PIN 2             // PIN D4 on ESP-8266
#define STRIP_LED_NUMBER 57

ESP8266WiFiMulti wifiMulti;
ESP8266WebServer server(80);
DynamicJsonDocument doc(512);
StaticJsonDocument<200> staticDoc;
WS2812FX strip = WS2812FX(STRIP_LED_NUMBER, STRIP_PIN, NEO_GRB + NEO_KHZ800);
HTTPClient sender;
WiFiClientSecure wifiClient;

String allowOrigin = "Access-Control-Allow-Origin";
String httpHeaders = "Access-Control-Allow-Headers, Access-Control-Allow-Headers, Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers, Authorization";
String allowMethods = "Access-Control-Allow-Methods";

String allowAll = "*";
String headerPrefix = "Access-Control-Allow-Headers";
 
void setup() {
  strip.init();
  strip.setBrightness(255);

  wifiMulti.addAP("", "");
  wifiMulti.addAP("", "");

  Serial.begin(9600);
  while (wifiMulti.run() != WL_CONNECTED) {
    delay(1000);
  }

  server.on("/api/color", HTTP_POST, []() {
    server.sendHeader(allowOrigin, allowAll);
    server.sendHeader(headerPrefix, httpHeaders);
    server.sendHeader(allowMethods, allowAll);
    handleColor();
  });

  server.on("/api/color", HTTP_OPTIONS, []() {
    server.sendHeader(allowOrigin, allowAll);
    server.sendHeader(headerPrefix, httpHeaders);
    server.sendHeader(allowMethods, allowAll);
    server.send(200, "text/plain", "Color changed");
  });

  server.on("/api/mode", HTTP_POST, []() {
    server.sendHeader(allowOrigin, allowAll);
    server.sendHeader(headerPrefix, httpHeaders);
    server.sendHeader(allowMethods, allowAll);
    handleMode();
  });

  server.on("/api/mode", HTTP_OPTIONS, []() {
    server.sendHeader(allowOrigin, allowAll);
    server.sendHeader(headerPrefix, httpHeaders);
    server.sendHeader(allowMethods, allowAll);
    server.send(200, "text/plain", "Color changed");
  });

  server.begin();
  sendStatus();
  strip.setColor(0, 255, 0);
  strip.start();
}

void loop() {
  server.handleClient();   //Handling of incoming requests
  strip.service();
}

void stopStrip() {
  strip.stop();
  strip.strip_off();
  strip.setMode(NO_OPTIONS);
}

void turnStripOff() {
  stopStrip();
  server.send(200, "text/plain", "LED turned off");
}

void handleColor() {
  if (server.hasArg("plain")== false){ // Check if body received
    server.send(400, "text/plain", "No Color in Body");
    return;
  }
  String value = server.arg("plain");
  setNewColor(value);
  
  server.send(200, "text/plain", "Led Color changed");
}

void handleMode() {
  if (server.hasArg("plain")== false){
    server.send(400, "text/plain", "No Mode in Body");
    return;
  }
  String value = server.arg("plain");
  setNewMode(value);

  server.send(200, "text/plain", "Led Color changed");
}

void setNewColor(String value) {
  stopStrip();
  DeserializationError error = deserializeJson(doc, value);
  uint8_t redColor = doc["red"];
  uint8_t greenColor = doc["green"];
  uint8_t blueColor = doc["blue"];
  strip.setColor(redColor, greenColor, blueColor);
  strip.start();

}

void setNewMode(String value) {
  stopStrip();
  DeserializationError error = deserializeJson(doc, value);
  uint8_t currentMode = doc["mode"];
  uint8_t redColor = doc["red"];
  uint8_t greenColor = doc["green"];
  uint8_t blueColor = doc["blue"];
  strip.setMode(currentMode);
  if(redColor != 0 || greenColor != 0 || blueColor != 0) {
    strip.setColor(redColor, greenColor, blueColor);
  }
  strip.start();
}

void sendStatus() {
  wifiClient.setInsecure();
  wifiClient.connect("https://led-rest.holfelder.cloud", 443);
  if (sender.begin(wifiClient, "https://led-rest.holfelder.cloud/api/modules/address")) {
    sender.addHeader("Content-Type", "application/json");

    const size_t CAPACITY = JSON_OBJECT_SIZE(10);
    StaticJsonDocument<CAPACITY> doc;

    String jsonOutput;
    String ip = WiFi.localIP().toString();
    String mac = WiFi.macAddress();

    JsonObject object = doc.to<JsonObject>();
    object["address"] = ip;
    object["mac"] = mac;
    serializeJson(doc, jsonOutput);

    int httpCode = sender.PATCH(jsonOutput);

    if (httpCode > 0) {
      if (httpCode == HTTP_CODE_OK) {
        String payload = sender.getString();
        Serial.println(payload);
      }
    } else {
      String payload = sender.getString();
      Serial.println(payload);
      Serial.printf("HTTP-Error: ", sender.errorToString(httpCode).c_str());
    }
    sender.end();
  } else {
    Serial.printf("HTTP-Verbindung konnte nicht hergestellt werden!");
  }
}
