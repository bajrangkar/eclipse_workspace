package mosh.streams;

import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.stream.Collectors;

public class Streams11PartitioningBy {
    public static void main(String[] args) {
        List<MovieGenre> movies = List.of (
            new MovieGenre("a", 10, Genre.ACTION),
            new MovieGenre("b", 30, Genre.THRILLER),
            new MovieGenre("c", 20, Genre.ACTION)
        );

        movies.stream()
                .collect(Collectors.partitioningBy(m -> m.getLikes() > 20))
                .entrySet()
                .forEach(m-> System.out.println(m));

        System.out.println("*********************");

        movies.stream()
            .collect(
                Collectors.partitioningBy(
                    m -> m.getLikes() > 20,
                    Collectors.mapping(
                        MovieGenre::getTitle,
                        Collectors.joining(","))
                )
            )
            .entrySet()
            .forEach(System.out::println);

        System.out.println("*********************");
    }
}
