#!/bin/sh

SERVER_URL="192.168.1.10"

ping $SERVER_URL

echo "scp du jar"
ls build/libs/ares-0.0.1-SNAPSHOT.jar
scp build/libs/ares-0.0.1-SNAPSHOT.jar ares@${SERVER_URL}:ares.jar
sleep 10