package pl.decerto.workshop.kubernetes.invoice.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.inject.Singleton;

@Singleton
class InMemoryInvoiceRepository implements InvoiceRepository {

	private final Map<String, Invoice> db = new HashMap<>();

	@Override
	public void save(Invoice invoice) {
		db.put(invoice.getId(), invoice);
	}

	@Override
	public Optional<Invoice> getById(String id) {
		return Optional.ofNullable(db.get(id));
	}

	@Override
	public List<Invoice> getAll() {
		return new ArrayList<>(db.values());
	}
}