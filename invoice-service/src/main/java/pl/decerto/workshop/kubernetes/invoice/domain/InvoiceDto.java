package pl.decerto.workshop.kubernetes.invoice.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class InvoiceDto {

	private String id;
	private String customerId;
	private Double sum;

	private InvoiceDto(String id, String customerId, Double sum) {
		this.id = id;
		this.customerId = customerId;
		this.sum = sum;
	}

	static InvoiceDto of(Invoice invoice) {
		return new InvoiceDto(invoice.getId(), invoice.getCustomerId(), invoice.getSum());
	}
}
