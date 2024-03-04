package mosh.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class Streams01Create {
	public static void main(String[] args) {
		Collection<Integer> x;
		//x.stream();
		
		int[] numbers = { 1, 2, 3};
		Arrays.stream(numbers).forEach(System.out::println);
		
		Stream.of(1,2,3,4).forEach(System.out::println);
		
		var stream = Stream.generate(() -> Math.random()); // lazy evaluation
		stream.limit(3).forEach(n -> System.out.println(n));
		
		
		Stream.iterate(1, n -> n+1).limit(10).forEach(n -> System.out.println(n));
	}
}
