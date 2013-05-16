package com.promindis.jdk8;

import java.util.function.Function;

public final class Functions {

  private Functions() {
    super();
  }

  public static <T> Function<T, T> identity() { return t -> t; }

}
