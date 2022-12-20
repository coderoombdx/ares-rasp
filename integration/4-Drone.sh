#!/bin/sh

BASE_URL="BASE_URL=http://localhost:8090"

echo "1. Lance le drone"
echo "2. Relance le drone"

read -r respons
case "$respons" in
	1)
    hurl --variable "$BASE_URL" --variable "MESSAGE=${message}" test/drone/lanceVol.hurl
		;;
	2)
    hurl --variable "$BASE_URL" --variable "MESSAGE=${message}" test/drone/relanceVol.hurl
		;;
esac
