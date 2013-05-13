package com.promindis.jdk8;

import java.util.Arrays;
import java.util.List;
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
  }

}
