package pl.decerto.workshop.kubernetes.videorental.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.inject.Singleton;

@Singleton
class InMemoryMovieRepository implements MovieRepository {

	private final Map<String, Movie> db = new HashMap<>();

	@Override
	public Optional<Movie> getMovie(String name) {
		return Optional.ofNullable(db.get(name));
	}

	@Override
	public List<Movie> getAll() {
		return new ArrayList<>(db.values());
	}

	@PostConstruct
	void init() {
		db.put("matrix", new Movie("matrix", 10.0));
		db.put("godzilla", new Movie("godzilla", 11.0));
		db.put("titanic", new Movie("titanic", 12.0));
	}
}