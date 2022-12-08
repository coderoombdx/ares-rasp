#!/bin/sh

BASE_URL="BASE_URL=http://localhost:8090"

echo "1. reset alarme"

read -r respons
case "$respons" in
	1)
    hurl --variable "$BASE_URL" test/alarme/reset.hurl
		;;
esac
