package pl.decerto.workshop.kubernetes.invoice.api;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.validation.Valid;
import pl.decerto.workshop.kubernetes.invoice.domain.InvoiceDto;
import pl.decerto.workshop.kubernetes.invoice.domain.InvoiceFacade;
import pl.decerto.workshop.kubernetes.invoice.domain.InvoiceQueryFacade;

@Controller("/invoice")
class InvoiceEndpoint {

	private final InvoiceFacade invoiceFacade;

	private final InvoiceQueryFacade queryFacade;

	@Inject
	InvoiceEndpoint(InvoiceFacade invoiceFacade, InvoiceQueryFacade queryFacade) {
		this.invoiceFacade = invoiceFacade;
		this.queryFacade = queryFacade;
	}

	@Post(processes = MediaType.APPLICATION_JSON)
	HttpResponse<Map<String, String>> createInvoice(@Body @Valid CreateInvoiceCommand cmd) {
		return HttpResponse.created(Collections.singletonMap("id", invoiceFacade.create(cmd.getCustomerId(), cmd.getSum())));
	}

	@Get(value = "/{id}", processes = MediaType.APPLICATION_JSON)
	HttpResponse<InvoiceDto> getInvoice(String id) {
		return queryFacade.getInvoice(id)
			.map(HttpResponse::ok)
			.orElse(HttpResponse.notFound());
	}

	@Get(processes = MediaType.APPLICATION_JSON)
	HttpResponse<List<InvoiceDto>> getAll() {
		return HttpResponse.ok(queryFacade.getInvoices());
	}
}