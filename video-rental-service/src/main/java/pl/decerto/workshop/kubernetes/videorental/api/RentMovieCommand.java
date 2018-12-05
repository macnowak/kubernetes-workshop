package pl.decerto.workshop.kubernetes.videorental.api;

import lombok.Data;

@Data
class RentMovieCommand {

	private String customerId;
	private String movieName;

}
