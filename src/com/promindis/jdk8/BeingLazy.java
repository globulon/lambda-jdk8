package com.promindis.jdk8;

import java.util.Arrays;
import java.util.List;

import static com.promindis.jdk8.LazyEvaluation.Evaluation.*;

public final class BeingLazy implements Delay, LazyEvaluation, LazyStreams {

  private void eagerDelayed() {
    final Holder holder = new Holder();
    holder.getHeavy();
    holder.getHeavy();

    eagerEvaluator(evaluate(1), evaluate(1));

    lazyEvaluator(() -> evaluate(1), () -> evaluate(1));
  }

  private void lazyStreams() {
    List<String> names = Arrays.asList("Brad", "Kate", "Kim", "Jack", "Joe",
      "Mike", "Susan", "George", "Robert", "Julia", "Parker", "Benson");

    System.out.println(firstNameWith3Letters(names));
  }

  private String firstNameWith3Letters(final List<String> names) {
    return names.stream()
        .filter(lengthIs(3))
        .map(this::toUpper)
        .findFirst()
        .get();
  }

  public static void main(final String[] args) {
//    new BeingLazy().eagerDelayed();
    new BeingLazy().lazyStreams();

  }
}
