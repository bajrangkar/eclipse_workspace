package mosh.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// map()
// flatMap()
public class Streams02Mapping {
	public static void main(String[] args) {
		List<Movie> movies = List.of (
			new Movie("a", 10),	
			new Movie("b", 20),	
			new Movie("c", 30)	
		);
		
		movies.stream()
		.map(movie -> movie.getTitle())
		.forEach(name -> System.out.println(name));
		
		movies.stream()
		.mapToInt(movie -> movie.getLikes())
		.forEach(name -> System.out.println(name));
	
		var stream = Stream.of(List.of(1,2,3), List.of(4,5,6), 7, 8, 9);
		stream.forEach(list -> System.out.print(list+" "));
		System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
		
		var stream_of_lists = Stream.of(List.of(1,2,3), List.of(4,5,6));
		stream_of_lists
		.flatMap(s -> s.stream())
		.forEach(n -> System.out.print(n+" "));
		System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
		
		var stream2 = Stream.of(List.of(1,2,3), List.of(4,5,6), 7, 8, 9);
		stream2
		.flatMap(s -> s instanceof List ? ((List<?>)s).stream() : Stream.of(s))
		.forEach(n->System.out.print(n+" "));
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		
		var stream3 = Stream.of(List.of(1,2,3), List.of(4,5,6), 7, 8, 9);
		List<Object> listOb = stream3
		.flatMap(s -> s instanceof List ? ((List<?>)s).stream() : Stream.of(s))
		.collect(Collectors.toList());
		System.out.println(listOb);
		
		List<Object> check = new ArrayList<>();
		check.add("a");
		check.add("b");
		check.add("c");
		ArrayList<String> middleList = new ArrayList<>();
		middleList.add("d");
		middleList.add("e");
		middleList.add("f");
		middleList.add("g");
		check.add(middleList);
		check.add("h");
		check.add("i");
		check.add("j");
		System.out.println(check);

		List<Object> list = check.stream()
		        .flatMap(s -> s instanceof List ?
		                ((List<?>) s).stream() : Stream.of(s))
		        .collect(Collectors.toList());

		System.out.println(list);
		
	}
}
