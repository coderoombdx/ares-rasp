GET {{BASE_URL}}/api/jeu
HTTP/1.1 200

[Asserts]
jsonpath "$.dernierMessage" equals ""

