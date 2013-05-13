package com.promindis.jdk8;

import java.util.function.Function;
import java.util.function.Predicate;

public interface StringChecks {

  final static Function<String, Predicate<String>> makeCheckStartWith =
    exp ->  name -> name.startsWith(exp);

}
