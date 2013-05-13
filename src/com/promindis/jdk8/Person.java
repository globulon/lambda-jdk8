package com.promindis.jdk8;

public final class Person {
  private final String name;
  private final int age;

  public Person(final String name, final int age) {
    this.name = name;
    this.age = age;
  }

  public int compareName(final Person other) {
    return name.compareTo(other.name);
  }

  public String name() {
    return name;
  }

  public int age() {
    return age;
  }


  public int ageDifference(final Person other) { return age - other.age; }

  @Override
  public String toString() {
    return String.format("%s - %d", name, age);
  }
}
