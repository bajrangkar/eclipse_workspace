package mosh.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Streams12PrimitiveType {
    public static void main(String[] args) {
        IntStream.range(0, 5)
            .forEach(System.out::println);
        System.out.println("*********************");

        IntStream.rangeClosed(0, 5)
            .forEach(System.out::println);
        System.out.println("*********************");
    }
}
