package pl.decerto.workshop.kubernetes.invoice.domain;

import java.util.List;
import java.util.Optional;

interface InvoiceRepository {

	void save(Invoice invoice);

	Optional<Invoice> getById(String id);

	List<Invoice> getAll();
}
