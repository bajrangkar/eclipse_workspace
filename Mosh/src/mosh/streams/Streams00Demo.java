package mosh.streams;

import java.util.List;

public class Streams00Demo {
	public static void main(String[] args) {
		Streams00Demo.show();
	}
	
	public static void show() {
		List<Movie> movies = List.of (
			new Movie("a", 10),	
			new Movie("b", 20),	
			new Movie("c", 30)	
		);
		
		// Imperative Programming - How something should be done
		int count = 0;
		for(var movie: movies) 
			if(movie.getLikes() > 10) 
				count++;
		System.out.println(count);
			
		var count2 = movies.stream().filter(m -> m.getLikes() > 10).count();
		System.out.println(count2);
	}
}
