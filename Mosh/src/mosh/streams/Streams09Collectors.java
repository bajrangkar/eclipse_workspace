package mosh.streams;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Streams09Collectors {
    public static void main(String[] args) {
        List<Movie> movies = List.of (
                new Movie("a", 10),
                new Movie("b", 30),
                new Movie("c", 20)
        );


        movies.stream()
                .filter(m -> m.getLikes() > 10)
                .collect(Collectors.toList())
                .forEach(m-> System.out.println(m));

        System.out.println("*********************");

        movies.stream()
                .filter(m -> m.getLikes() > 10)
                .collect(Collectors.toSet())
                .forEach(m-> System.out.println(m));

        System.out.println("*********************");

        movies.stream()
                .filter(m -> m.getLikes() > 10)
                .collect(Collectors.toMap(Movie::getTitle, Movie::getLikes))
                .entrySet()
                .forEach(m-> System.out.println(m));

        System.out.println("*********************");

        movies.stream()
                .filter(m -> m.getLikes() > 10)
                .collect(Collectors.toMap(Movie::getTitle, Function.identity()))
                .entrySet()
                .forEach(m-> System.out.println(m));

        System.out.println("*********************");

        var result = movies.stream()
                .filter(m -> m.getLikes() > 10)
                .collect(Collectors.summingInt(Movie::getLikes));

        System.out.println("*********************" + result);

        var summary = movies.stream()
                .filter(m -> m.getLikes() > 10)
                .collect(Collectors.summarizingInt(Movie::getLikes));

        System.out.println("*********************" + summary);

        var joining = movies.stream()
                .filter(m -> m.getLikes() > 10)
                .map(Movie::getTitle)
                .collect(Collectors.joining(","));

        System.out.println("*********************" + joining);

    }
}
