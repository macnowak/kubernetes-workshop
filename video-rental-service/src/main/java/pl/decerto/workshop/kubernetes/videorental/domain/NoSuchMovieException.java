package pl.decerto.workshop.kubernetes.videorental.domain;

class NoSuchMovieException extends RuntimeException {

	NoSuchMovieException(String message) {
		super(message);
	}
}
