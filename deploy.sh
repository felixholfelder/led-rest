#!/bin/bash

ssh root@$HOSTIP "cd /opt/led-rest && docker-compose pull && docker-compose up -d && exit"