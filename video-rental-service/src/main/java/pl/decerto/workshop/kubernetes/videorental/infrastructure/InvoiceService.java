package pl.decerto.workshop.kubernetes.videorental.infrastructure;

import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
public class InvoiceService {

	private final InvoiceServiceClient serviceClient;

	@Inject
	public InvoiceService(InvoiceServiceClient serviceClient) {
		this.serviceClient = serviceClient;
	}

	public void createInvoice(String customerId, Double sum) {
		serviceClient.create(customerId, sum)
			.toObservable()
			.subscribe(response -> log.info("Invoice {} created", response),
				t -> log.error("Error while creating invoice", t));
	}

}
