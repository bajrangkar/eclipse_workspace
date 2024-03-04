package mosh.streams;

import java.util.Comparator;
import java.util.List;

public class Streams05Sorting {
	public static void main(String[] args) {
		List<Movie> movies = List.of (
			new Movie("a", 10),	
			new Movie("b", 30),	
			new Movie("c", 20)	
		);
		
		movies.stream()
			.sorted((a, b) -> a.getTitle().compareTo(b.getTitle()))
			.forEach(m -> System.out.println(m.getTitle()));

		movies.stream()
			.sorted(Comparator.comparing(Movie::getTitle))
			.forEach(m -> System.out.println(m.getTitle()));
		
	}
}
