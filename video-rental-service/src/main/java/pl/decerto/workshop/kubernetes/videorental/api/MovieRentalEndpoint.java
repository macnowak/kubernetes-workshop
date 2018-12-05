package pl.decerto.workshop.kubernetes.videorental.api;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import javax.inject.Inject;
import javax.validation.Valid;
import pl.decerto.workshop.kubernetes.videorental.domain.MovieRentalFacade;

@Controller("/rental/movie")
class MovieRentalEndpoint {

	private final MovieRentalFacade movieRentalFacade;

	@Inject
	MovieRentalEndpoint(MovieRentalFacade movieRentalFacade) {
		this.movieRentalFacade = movieRentalFacade;
	}

	@Post(processes = MediaType.APPLICATION_JSON)
	HttpResponse<String> rentMovie(@Body @Valid RentMovieCommand cmd) {
		movieRentalFacade.rent(cmd.getCustomerId(), cmd.getMovieName());
		return HttpResponse.created("");
	}


}