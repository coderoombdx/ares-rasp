#!/bin/sh

BASE_URL="BASE_URL=http://localhost:8090"

while true; do
  clear
  echo "0. Afficher etat du jeu"
  echo "1. Gestion du temps"
  echo "2. Gestion des messages d'aide"
  echo "3. Gestion des alarmes"

  echo -n ">"
  read -r respons
  case "$respons" in
	  0)
      ./0-etatJeu.sh
		  ;;
	  1)
      ./1-compteARebours.sh
		  ;;
	  2)
      ./2-messageAide.sh
		  ;;
	  3)
      ./3-alarmes.sh
		  ;;
  esac
  echo -n ">"
  read -r
done