package com.promindis.jdk8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static java.lang.System.out;
import static java.util.stream.Collectors.toList;

public final class Compare {

  private static void printPeople(final String message, final Stream<Person> s) {
    out.println(message);
    s.forEach(out::println);
  }

  private static void printPeople(final String message, final List<? super Person> s) {
    out.println(message);
    s.forEach(out::println);
  }

  private static <T> Consumer<T> traceMessage(final String prefix) {
    return t ->  System.out.println(String.format("%s: %s", prefix, t));
  }

  public static void main(final String[] args) {
    final List<Person> people = Arrays.asList(
      new Person("John", 20),
      new Person("Sara", 21),
      new Person("Jane", 21),
      new Person("Greg", 35));

    printPeople(
      "Sorted in ascending order of age:",
      people.stream().sorted(Person::ageDifference));

    printPeople(
      "Sorted in ascending order of age:",
      people.stream().sorted(Person::ageDifference).collect(toList()));

    final Comparator<Person> compareAsc = Person::ageDifference;
    final Comparator<Person> compareDesc = compareAsc.reverseOrder();

    printPeople(
      "Sorted in ascending order of age:",
      people.stream().sorted(compareAsc).collect(toList()));

    printPeople(
      "Sorted in descending order of age:",
      people.stream().sorted(compareDesc).collect(toList()));

    final Comparator<Person> compareAscName = Person::compareName;
    final Comparator<Person> compareDescName = compareAscName.reverseOrder();

    printPeople(
      "Sorted in descending order of name:",
      people.stream().sorted(compareAscName).collect(toList()));

    printPeople(
      "Sorted in descending order of name:",
      people.stream().sorted(compareDescName).collect(toList()));

    people.stream().min(compareAsc).ifPresent(traceMessage("Younger"));

  }
}
