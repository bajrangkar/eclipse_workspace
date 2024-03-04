package mosh.streams;

import java.util.List;

public class Streams08Reducers {
    public static void main(String[] args) {
        List<Movie> movies = List.of (
                new Movie("a", 10),
                new Movie("b", 30),
                new Movie("c", 20)
        );

        var value = movies.stream()
                .map(m -> m.getLikes())
                .reduce((a, b) -> a+b)
                .get();

        System.out.println("*********************" + value);

        var value1 = movies.stream()
                .map(m -> m.getLikes())
                .reduce(0, Integer::sum);

        System.out.println("*********************" + value1);

    }
}
