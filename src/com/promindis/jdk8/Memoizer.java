package com.promindis.jdk8;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public interface Memoizer {

  default <T, R>  Function<T, R> memoize(
    final Function<T, R> func
  ) {
    final Map<T,R> map = new HashMap<T,R>();
    return t -> {
      if (!map.containsKey(t)) {
        map.put(t, func.apply(t));
      }
      return map.get(t);
    };
  }

}
