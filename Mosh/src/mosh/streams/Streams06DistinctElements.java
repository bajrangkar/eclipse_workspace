package mosh.streams;

import java.util.List;

public class Streams06DistinctElements {
	public static void main(String[] args) {
		List<Movie> movies = List.of (
			new Movie("a", 10),	
			new Movie("a", 10),
			new Movie("b", 30),
			new Movie("c", 20)	
		);

		movies.stream()
				.map(Movie::getLikes)
				.distinct()
				.forEach(System.out::println);

		System.out.println("*********************");

	}
}
