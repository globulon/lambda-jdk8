package com.promindis.jdk8;

import java.util.stream.Stream;

public interface TCO {
  @FunctionalInterface
  interface TailCall<R> {
    TailCall<R> apply();

    default boolean isDone() {return false;}

    default R result() {throw new RuntimeException("Not implemented");}

    default R invoke() {
      return Stream
        .iterate(this, TailCall::<R>apply)
        .filter(TailCall::isDone)
        .findFirst().get().result();
    }
  }

  final class Done<T> implements TailCall<T> {
    private final T t;

    public Done(T t) {
      this.t = t;
    }

    @Override
    public TailCall<T> apply() {
      throw new RuntimeException("new Implementation");
    }

    @Override
    public boolean isDone() { return true; }

    @Override
    public T result() { return t; }
  }

  default <T> TailCall<T> done(final T t) {
    return new Done<T>(t);
  }

  default <T> TailCall<T> call(final TailCall<T> next) {
    return next;
  }
}
