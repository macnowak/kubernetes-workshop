package pl.decerto.workshop.kubernetes.videorental.domain;

import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import pl.decerto.workshop.kubernetes.videorental.infrastructure.InvoiceService;

@Singleton
@Slf4j
public class MovieRentalFacade {

	private MovieRepository repository;
	private InvoiceService invoiceService;

	@Inject
	public MovieRentalFacade(MovieRepository repository, InvoiceService invoiceService) {
		this.repository = repository;
		this.invoiceService = invoiceService;
	}

	public void rent(String customerId, String movieName) {

		Movie movie = repository.getMovie(movieName)
			.orElseThrow(() -> new NoSuchMovieException("Movie " + movieName + " not found"));

		invoiceService.createInvoice(customerId, movie.getPrice());

		log.info("Movie {} rented by {} ", movieName, customerId);

	}
}
