package com.promindis.jdk8;

import java.util.function.Consumer;
import java.util.stream.Stream;

import static java.lang.System.out;

public interface Messages {

  default <T> Consumer<Stream<? super T>> trace(final String title) {
    return ts ->  {
      out.println(title);
      ts.forEach(out::println);
    } ;
  }

  static <T> Consumer<T> traceMessage(final String prefix) {
    return t ->  System.out.println(String.format("%s: %s", prefix, t));
  }
}
