DELETE {{BASE_URL}}/api/alarme
HTTP/1.1 200

GET {{BASE_URL}}/api/jeu
HTTP/1.1 200

[Asserts]
jsonpath "$.derniereAlarme" equals 0

