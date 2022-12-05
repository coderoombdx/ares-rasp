GET {{BASE_URL}}/api/jeu
HTTP/1.1 200

POST {{BASE_URL}}/api/compteARebours
{ "delta":{{TEMPS}} }
HTTP/1.1 200

GET {{BASE_URL}}/api/jeu
HTTP/1.1 200
