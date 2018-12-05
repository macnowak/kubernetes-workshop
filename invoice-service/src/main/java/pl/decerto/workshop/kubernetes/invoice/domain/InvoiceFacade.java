package pl.decerto.workshop.kubernetes.invoice.domain;

import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
public class InvoiceFacade {

	private InvoiceRepository invoiceRepository;

	@Inject
	public InvoiceFacade(InvoiceRepository invoiceRepository) {
		this.invoiceRepository = invoiceRepository;
	}

	public String create(String customerId, Double amount) {
		Invoice invoice = new Invoice(customerId, amount);
		invoiceRepository.save(invoice);

		log.info("Created invoice {} for customer : {} with sum : {} ", invoice.getId(), invoice.getCustomerId(), invoice.getSum());

		return invoice.getId();
	}
}
