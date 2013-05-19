package com.promindis.jdk8;

import java.util.concurrent.locks.Lock;
import java.util.function.Function;

public interface Locker {

  default <A, B> Function<Function<A, B>, Function<A, B>> runLocked(final Lock lock) {
    return f -> a -> {
      lock.lock();
      try {
        return f.apply(a);
      } finally {
        lock.unlock();
      }
    };
  }

  default <A, B> Function<A, B> runLocked(final Lock lock, final Function<A, B> f) {
    return this.<A, B>runLocked(lock).apply(f);
  }
}
