#!/bin/sh

BASE_URL="BASE_URL=http://localhost:8090"

echo "1. Etats Enigmes"

read -r respons
case "$respons" in
	1)
	  echo -n "code enigme : "
	  read -r code
    hurl --variable "$BASE_URL" test/enigmes/resout_enigmes.hurl
		;;
esac
