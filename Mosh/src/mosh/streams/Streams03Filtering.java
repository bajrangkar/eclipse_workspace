package mosh.streams;

import java.util.List;
import java.util.function.Predicate;

public class Streams03Filtering {
	public static void main(String[] args) {
		List<Movie> movies = List.of (
			new Movie("a", 10),	
			new Movie("b", 20),	
			new Movie("c", 30)	
		);
		
		Predicate<Movie> isPopular = m -> m.getLikes() > 10;
		
		movies.stream()
		.filter(isPopular) //.filter(m -> m.getLikes() > 10)
		.forEach(m -> System.out.println(m.getTitle()));
		
	}
}
