package com.promindis.jdk8;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.lang.System.out;

public interface People {

  static void printPeople(final String message, final Stream<Person> s) {
    out.println(message);
    s.forEach(out::println);
  }

  static void printPeople(final String message, final List<? super Person> s) {
    out.println(message);
    s.forEach(out::println);
  }

  final Comparator<Person> compareAsc = Person::ageDifference;

  final Comparator<Person> compareDesc = compareAsc.reverseOrder();

  final Comparator<Person> compareAscName = Person::compareName;

  final Comparator<Person> compareDescName = compareAscName.reverseOrder();

  final Function<Person, String>  byName = Person::name;

  final Function<Person, Integer>  byAge = Person::age;

}
