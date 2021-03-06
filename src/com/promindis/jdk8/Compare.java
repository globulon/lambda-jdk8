package com.promindis.jdk8;

import java.util.Arrays;
import java.util.Comparators;
import java.util.List;

import static java.util.stream.Collectors.toList;

public final class Compare extends People implements Messages, Runnable {

  public static void main(final String[] args) {
    new Compare().run();
  }

  @Override
  public void run() {
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

    printPeople(
      "Sorted in ascending order of age:",
      people.stream().sorted(compareAsc).collect(toList()));

    printPeople(
      "Sorted in descending order of age:",
      people.stream().sorted(compareDesc).collect(toList()));

    printPeople(
      "Sorted in descending order of name:",
      people.stream().sorted(compareAscName).collect(toList()));

    printPeople(
      "Sorted in descending order of name:",
      people.stream().sorted(compareDescName).collect(toList()));

    people.stream().min(compareAsc).ifPresent(Messages.traceMessage("Younger"));
    people.stream().max(compareAsc).ifPresent(Messages.traceMessage("Eldest"));

    printPeople(
      "Sorted in ascending order of name:",
      people.stream().sorted(Comparators.comparing(byName)));

    printPeople(
      "Sorted in ascending order of name then by age:",
      people.stream().sorted(Comparators.comparing(byAge).thenComparing(byName)));
  }
}
