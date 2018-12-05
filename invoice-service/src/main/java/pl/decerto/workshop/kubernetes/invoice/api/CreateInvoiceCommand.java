package pl.decerto.workshop.kubernetes.invoice.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
class CreateInvoiceCommand {

	private String customerId;
	private Double sum;

	@JsonCreator
	public CreateInvoiceCommand(@JsonProperty("customerId") String customerId, @JsonProperty("sum") Double sum) {
		this.customerId = customerId;
		this.sum = sum;
	}
}
