package pl.decerto.workshop.kubernetes.invoice.domain;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class InvoiceQueryFacade {

	private InvoiceRepository invoiceRepository;

	@Inject
	public InvoiceQueryFacade(InvoiceRepository invoiceRepository) {
		this.invoiceRepository = invoiceRepository;
	}

	public Optional<InvoiceDto> getInvoice(String id) {
		return invoiceRepository.getById(id).map(InvoiceDto::of);
	}

	public List<InvoiceDto> getInvoices() {
		return invoiceRepository.getAll().stream().map(InvoiceDto::of).collect(Collectors.toList());
	}

}
