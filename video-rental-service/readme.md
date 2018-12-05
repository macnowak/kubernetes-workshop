###Video rental service

###Description

Simple dummy video rental service, that communicates with invoice service when renting movie 

* Micronaut (http://micronaut.io/) 
* InMemory DB


###API

Rent movie :

	~ $ curl -XPOST http://localhost:8080/rent/movie -H "Content-Type: application/json"  -d '{"customerId":"123123","movieName":"matrix"}'

Get invoice 

	~ $ curl http://localhost:8080/invoice/fde84352-1a1a-46ba-91af-298f7f51d910

Get all invoices
	
	~ $ curl http://localhost:8080/invoice


###Run 

Run with gradle task : 

	gradle run 
	
or 

	java -jar video-rental-service-0.1.0-all.jar


###Release

Use gradle release task :

1. Build version

		gradle clean build 

2. Release it 

		gradle release 

3. Create docker image

		gradle docker

4. Push image 

		docker push macnowak/video-rental-app


