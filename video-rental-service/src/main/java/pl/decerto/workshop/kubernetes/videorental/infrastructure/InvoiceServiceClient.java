package pl.decerto.workshop.kubernetes.videorental.infrastructure;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Single;

@Client("invoice")
interface InvoiceServiceClient {

	@Post(value = "/invoice", processes = MediaType.APPLICATION_JSON)
	Single<String> create(String customerId, Double sum);

}
