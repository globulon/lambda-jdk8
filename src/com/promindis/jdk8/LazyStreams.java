package com.promindis.jdk8;

import java.util.function.Predicate;

public interface LazyStreams {

  default Predicate<String> lengthIs(final int value) {
    return s -> {
      System.out.println("getting length for " + s);
      return s.length() == value;
    };
  }

  default int length(final String name) {
    System.out.println("getting length for " + name);
    return name.length();
  }

  default String toUpper(final String name ) {
    System.out.println("converting to uppercase: " + name);
    return name.toUpperCase();
  }

}
