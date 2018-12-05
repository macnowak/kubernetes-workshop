Invoice service

###Description

Simple dummy invoice service. 

* Micronaut (http://micronaut.io/) 
* InMemory DB



###API

Create invoice :

	~ $ curl -XPOST http://localhost:8080/invoice -H "Content-Type: application/json"  -d '{"customerId":"123123","sum":"123.00"}'

Get invoice 

	~ $ curl http://localhost:8080/invoice/fde84352-1a1a-46ba-91af-298f7f51d910

Get all invoices
	
	~ $ curl http://localhost:8080/invoice


###Run 

Run with gradle task : 

	gradle run 
	
or 

	java -jar invoice-service-0.1.0-all.jar


###Release

Use gradle release task :

1. Build version

		gradle clean build 

2. Release it 

		gradle release 

3. Build it 

		gradle clean build 

3. Create docker image

		gradle docker

4. Push image 

		docker push macnowak/invoice-app


