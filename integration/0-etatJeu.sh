#!/bin/sh

BASE_URL="BASE_URL=http://localhost:8090"

hurl --variable "$BASE_URL" --location test/jeu/etat.hurl
