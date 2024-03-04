package mosh.streams;

import java.util.List;

public class Streams04Slicing {
	public static void main(String[] args) {
		List<Movie> movies = List.of (
			new Movie("a", 10),	
			new Movie("b", 30),	
			new Movie("c", 20)	
		);
		
		movies.stream()
		.limit(2)
		.forEach(m -> System.out.println(m.getTitle()));
		
		System.out.println("*********************");
		
		movies.stream()
		.skip(2)
		.forEach(m -> System.out.println(m.getTitle()));
		
		System.out.println("*********************");
		
		movies.stream()
		.takeWhile(m -> m.getLikes() < 30)
		.forEach(m -> System.out.println(m.getTitle()));
		
		System.out.println("*********************");
		
		movies.stream()
		.dropWhile(m -> m.getLikes() < 30)
		.forEach(m -> System.out.println(m.getTitle()));

		System.out.println("*********************");

	}
}
