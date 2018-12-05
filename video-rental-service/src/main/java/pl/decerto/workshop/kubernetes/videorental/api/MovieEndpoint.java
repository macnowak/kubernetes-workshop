package pl.decerto.workshop.kubernetes.videorental.api;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import java.util.List;
import javax.inject.Inject;
import pl.decerto.workshop.kubernetes.videorental.domain.Movie;
import pl.decerto.workshop.kubernetes.videorental.domain.MovieQueryFacade;

@Controller("/movie")
class MovieEndpoint {

	private final MovieQueryFacade queryFacade;

	@Inject
	MovieEndpoint(MovieQueryFacade queryFacade) {
		this.queryFacade = queryFacade;
	}

	@Get(processes = MediaType.APPLICATION_JSON)
	HttpResponse<List<Movie>> getAll() {
		return HttpResponse.ok(queryFacade.getMovies());
	}

}