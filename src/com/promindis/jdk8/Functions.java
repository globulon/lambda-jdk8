package com.promindis.jdk8;

import java.util.function.Function;

public class Functions {

  static  <T> Function<T, T> identity() { return t -> t; }

  @FunctionalInterface
  public interface UseInstance<T, X extends Throwable> {
    void accept(T instance) throws X;
  }

  @FunctionalInterface
  public interface Invoke<U, R, X extends Throwable> {
    R apply(final U u) throws X;
  }
}
