package mosh.streams;

import java.util.List;

public class Streams07PeekElements {
	public static void main(String[] args) {
		List<Movie> movies = List.of (
			new Movie("a", 10),
			new Movie("b", 30),
			new Movie("c", 20)	
		);

		movies.stream()
				.filter(m -> m.getLikes() > 10)
				.peek(m -> System.out.println("Filtered : " + m.getTitle()))
				.map(Movie::getTitle)
				.peek(t -> System.out.println("mapped : " + t))
				.forEach(System.out::println);

		System.out.println("*********************");

	}
}
