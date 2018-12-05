package pl.decerto.workshop.kubernetes.videorental.domain;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Singleton
@Slf4j
public class MovieQueryFacade {

	private MovieRepository repository;

	@Inject
	public MovieQueryFacade(MovieRepository repository) {
		this.repository = repository;
	}

	public List<Movie> getMovies() {
		return repository.getAll();
	}
}
