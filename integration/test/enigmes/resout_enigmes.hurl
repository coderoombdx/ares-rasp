GET {{BASE_URL}}/api/jeu
HTTP/1.1 200

POST {{BASE_URL}}/api/enigmes/inter_general
{ "code":"resolu" }
HTTP/1.1 200

GET {{BASE_URL}}/api/jeu
HTTP/1.1 200
