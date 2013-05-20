package com.promindis.jdk8;

import java.util.function.Function;
import java.util.function.Supplier;

public interface Timers {
  default <A, B> Function<A, B> timed(final Function<A, B> f) {
    return a -> {
      final long start = System.currentTimeMillis();
      try {
        return f.apply(a);
      } finally {
        System.out.println(String.format("(time: %s)", System.currentTimeMillis() - start));
      }
    };
  }

  default <B> B timed(final Supplier<B> f) {
    final long start = System.currentTimeMillis();
    try {
      return f.get();
    } finally {
      System.out.println(String.format("(time: %s)", System.currentTimeMillis() - start));
    }
  }
}
