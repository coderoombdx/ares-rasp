#!/bin/sh

SERVER_URL="192.168.1.8"

ls build/libs/ares-0.0.1-SNAPSHOT.jar
scp build/libs/ares-0.0.1-SNAPSHOT.jar ares@192.168.1.8:ares.jar