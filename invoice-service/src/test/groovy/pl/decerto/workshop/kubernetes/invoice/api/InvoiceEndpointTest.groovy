package pl.decerto.workshop.kubernetes.invoice.api

import groovy.json.JsonSlurper
import io.micronaut.context.ApplicationContext
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.runtime.server.EmbeddedServer
import io.reactivex.Flowable
import pl.decerto.workshop.kubernetes.invoice.domain.InvoiceDto
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise

@Stepwise
class InvoiceEndpointTest extends Specification {

	@Shared
	@AutoCleanup
	EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer)

	@Shared
	@AutoCleanup
	HttpClient client = embeddedServer.applicationContext.createBean(HttpClient, embeddedServer.getURL())

	@Shared
	String id

	def "should create invoice"() {
		when:

		HttpResponse response = Flowable.fromPublisher(
				client.exchange(HttpRequest.POST('/invoice/', new CreateInvoiceCommand("123", 10.9)), Map))
				.blockingFirst()

		then:
		noExceptionThrown()
		response.status == HttpStatus.CREATED
		saveInvoiceId(response.getBody().get()["id"])

	}

	Object saveInvoiceId(Object invoiceId) {
		this.id = invoiceId
	}

	def "should get invoice by id"() {
		when:
		HttpResponse response = Flowable.fromPublisher(
				client.exchange(HttpRequest.GET("/invoice/$id"), Map))
				.blockingFirst()

		then:
		noExceptionThrown()
		response.status == HttpStatus.OK
		response.getBody().get().id == id
	}

	def "should return 404 passing wrong invoice id"() {
		when:
		Flowable.fromPublisher(
				client.exchange(HttpRequest.GET("/invoice/RANDOM_ID"), InvoiceDto))
				.blockingFirst()

		then:
		def e = thrown(HttpClientResponseException)
		e.response.status == HttpStatus.NOT_FOUND
	}

//	def "should get list of invoices"() {
//		when:
//		HttpResponse response = Flowable.fromPublisher(
//				client.exchange(HttpRequest.GET("/invoice"), List))
//				.blockingFirst()
//
//		then:
//		noExceptionThrown()
//		response.status == HttpStatus.OK
//		response.getBody().get().size() == 1
//	}
}
