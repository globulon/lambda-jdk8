package com.promindis.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Iteration implements StringChecks  {

  public static void main(final String[] args) {
    final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
    final List<String> comrades = Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");
//    final Stream<String> editors = stream("Brian", "Jackie", "John", "Mike");

    friends.stream().map(String::toUpperCase)
      .filter(makeCheckStartWith.apply("N")).forEach(System.out::println);

    final Optional<String> found =
      comrades.stream().filter(makeCheckStartWith.apply("N")).findFirst();

    found.ifPresent(System.out::println);

    System.out.println("Total number of characters in all names: " +
      friends.stream()
        .mapToInt(String::length)
        .sum());

    final Optional<String> foundName = friends.stream()
      .reduce((name1, name2) -> name1.length() >= name2.length() ? name1 : name2);

    foundName.ifPresent(System.out::println);

    System.out.println(String.join(", ", friends));

    System.out.println(
      friends.stream().map(String::toUpperCase).collect(Collectors.toStringJoiner(", ")));
  }

  static void trace(final Object o) {
    System.out.println(o);
  }

  @SafeVarargs
  static <T> Stream<T> stream(final T... t) {
    return Arrays.asList(t).stream();
  }

}
