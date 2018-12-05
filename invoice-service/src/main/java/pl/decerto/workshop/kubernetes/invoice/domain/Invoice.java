package pl.decerto.workshop.kubernetes.invoice.domain;

import java.util.UUID;
import lombok.Data;

@Data
class Invoice {

	private String id;
	private String customerId;
	private Double sum;

	Invoice(String customerId, Double sum) {
		this.id = UUID.randomUUID().toString();
		this.customerId = customerId;
		this.sum = sum;
	}
}
