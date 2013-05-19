package com.promindis.jdk8;

import java.util.function.Supplier;

public interface LazyEvaluation {

  public class Evaluation {
    public static boolean evaluate(final int value) {
      System.out.println("evaluating ..." + value);
      simulateTimeConsumingOp(2000);
      return value > 100;
    }

    private static void simulateTimeConsumingOp(final int delay) {
      try {
        Thread.sleep(delay);
      } catch (final InterruptedException e) {
        e.printStackTrace();
      }
    }

    public static void eagerEvaluator(
      final boolean input1, final boolean input2) {
      System.out.println("eagerEvaluator called...");
      System.out.println("accept?: " + (input1 && input2));
    }
  }

  default void lazyEvaluator(
    final Supplier<Boolean> input1, final Supplier<Boolean> input2) {
    System.out.println("lazyEvaluator called...");
    System.out.println("accept?: " + (input1.get() && input2.get()));
  }

}
