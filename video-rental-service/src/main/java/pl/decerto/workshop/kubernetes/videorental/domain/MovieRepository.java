package pl.decerto.workshop.kubernetes.videorental.domain;

import java.util.List;
import java.util.Optional;

interface MovieRepository {

	Optional<Movie> getMovie(String name);

	List<Movie> getAll();
}
