package mosh.streams;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Streams10GroupingBy {
    public static void main(String[] args) {
        List<MovieGenre> movies = List.of (
            new MovieGenre("a", 10, Genre.ACTION),
            new MovieGenre("b", 30, Genre.THRILLER),
            new MovieGenre("c", 20, Genre.ACTION)
        );


        movies.stream()
                .collect(Collectors.groupingBy(MovieGenre::getGenre))
                .entrySet()
                .forEach(m-> System.out.println(m));
        System.out.println("* List ********************");

        movies.stream()
                .collect(Collectors.groupingBy(MovieGenre::getGenre, Collectors.toSet()))
                .entrySet()
                .forEach(m-> System.out.println(m));
        System.out.println("* Set ********************");

        movies.stream()
                .collect(Collectors.groupingBy(MovieGenre::getGenre, Collectors.counting()))
                .entrySet()
                .forEach(m-> System.out.println(m));
        System.out.println("* Counting ********************");

        movies.stream()
                .collect(
                    Collectors.groupingBy(
                        MovieGenre::getGenre,
                        Collectors.mapping(MovieGenre::getTitle, Collectors.joining(","))
                ))
                .entrySet()
                .forEach(m-> System.out.println(m));

        System.out.println("* Mapping ********************");
    }
}
