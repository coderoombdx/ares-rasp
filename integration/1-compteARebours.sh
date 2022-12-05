#!/bin/sh

BASE_URL="BASE_URL=http://localhost:8090"

echo "1. Reset Jeu"
echo "2. Augmente le temps"
echo "3. change le temps restant"

read -r respons
case "$respons" in
	1)
    hurl --variable "$BASE_URL" --location test/compteARebours/reset.hurl
		;;
	2)
    hurl --variable "$BASE_URL" --location test/compteARebours/augmenteTemps.hurl
		;;
	3)
	  echo -n "temps : "
	  read -r temps
    hurl --variable "$BASE_URL" --variable "TEMPS=${temps}" --location test/compteARebours/changeTemps.hurl
		;;
esac
