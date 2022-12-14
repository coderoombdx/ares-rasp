GET http://localhost:8089/api/admin/configurations/
HTTP/1.1 200

PUT https://simuloffres-rec1-ccmd.staging.orange.fr/api/admin/configurations//app.version
{ "value":"tata" }
HTTP/1.1 200

GET https://simuloffres-rec1-ccmd.staging.orange.fr/api/admin/configurations//app.version
HTTP/1.1 200

DELETE https://simuloffres-rec1-ccmd.staging.orange.fr/api/admin/configurations//app.version
HTTP/1.1 200

GET https://simuloffres-rec1-ccmd.staging.orange.fr/api/admin/configurations//app.version
HTTP/1.1 200

