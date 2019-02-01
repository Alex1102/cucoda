
Cusomer         => Cu
Core            => Co
Data            => Da



######


http://localhost:8080/cucoda-rest/monitoring/ping
curl -u alex:alex http://localhost:8080/cucoda-v1.0-SNAPSHOT/monitoring/ping


standalone.xml
<user alias="alex" realm="ApplicationRealm" name="alex"/>




*** GET ***
curl -u alex:alex http://localhost:8080/cucoda-v1.0-SNAPSHOT/customers/1



*** POST ***
<!--
curl -u alex:alex -i -X POST http://localhost:8080/cucoda-v1.0-SNAPSHOT/customers -H 'Content-type: application/json' -d '{"firstName":"Bobo", "lastName":"Bobrowski", "email":"bob@gmx.com"}'
-->

curl -u alex:alex -i -X POST 'http://localhost:8080/cucoda-v1.0-SNAPSHOT/customers?marketId=mycompany' -H 'Content-type: application/json'



*** PUT ***

<!--
curl -u alex:alex -i -X PUT http://localhost:8080/cucoda-v1.0-SNAPSHOT/customers/1 -H "Content-type: application/json" -d '{"customerNumber":"1", "firstName":"Bobo", "lastName":"Bobrowski", "email":"bob@gmx.com"}'
-->

curl -u alex:alex -i -X PUT 'http://localhost:8080/cucoda-v1.0-SNAPSHOT/customers?customerNumber=1&marketId=mycompany' -H 'Content-type: application/json'



*** DELETE ***
curl -u alex:alex -i -X DELETE http://localhost:8080/cucoda-v1.0-SNAPSHOT/customers/1 -H 'Content-type: application/json'