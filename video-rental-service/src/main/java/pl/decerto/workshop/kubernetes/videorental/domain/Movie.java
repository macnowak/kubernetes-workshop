package pl.decerto.workshop.kubernetes.videorental.domain;

import lombok.Value;

@Value
public class Movie {

	private String name;
	private Double price;

}
