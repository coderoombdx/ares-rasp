#!/bin/sh

BASE_URL="BASE_URL=http://localhost:8090"

echo "1. positionne un message"
echo "2. reset message"

read -r respons
case "$respons" in
	1)
	  echo -n "message : "
    read -r message

    hurl --variable "$BASE_URL" --location --variable "MESSAGE=${message}" test/messageAide/changeMessage.hurl
		;;
	2)
    hurl --variable "$BASE_URL" --location test/messageAide/resetMessage.hurl
		;;
esac
