package com.promindis.jdk8;

import java.util.function.Consumer;

public interface Messages {

  static <T> Consumer<T> traceMessage(final String prefix) {
    return t ->  System.out.println(String.format("%s: %s", prefix, t));
  }

}
