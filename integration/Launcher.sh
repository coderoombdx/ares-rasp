#!/bin/sh

BASE_URL="BASE_URL=http://localhost:8090"

while true; do
  clear
  echo "0. Afficher etat du jeu"
  echo "1. Gestion du temps"

  read -r respons
  case "$respons" in
	  0)
      ./0-etatJeu.sh
		  ;;
	  1)
      ./1-compteARebours.sh
		  ;;
  esac
  echo -n "Entrer"
  read -r
done