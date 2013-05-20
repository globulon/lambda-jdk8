package com.promindis.jdk8;

import java.util.Arrays;
import static java.util.Arrays.*;
import java.util.List;
import java.util.function.Function;

public final class RodCutterBasic implements Memoizer {
  private final List<Integer> prices;

  public RodCutterBasic(final List<Integer> prices) {
    this.prices = prices;
  }

  public int maxProfit(final int length) {
    int profit = (length <= prices.size()) ? prices.get(length - 1) : 0;
    for (int i = 1; i < length ; i++) {
      final int currentProfit = maxProfit(i) + maxProfit(length - i);
      if (currentProfit > profit) profit = currentProfit;
    }
    return profit;
  }

  private int maxProfit(final Function<Integer, Integer> f, final int length) {
    int profit = (length <= prices.size()) ? prices.get(length - 1) : 0;
    for (int i = 1; i < length ; i++) {
      final int currentProfit = f.apply(i) + f.apply(length - i);
      if (currentProfit > profit) profit = currentProfit;
    }
    return profit;
  }



  public static void main(final String[] args) {
    final List<Integer> priceValues = asList(2, 1, 1, 2, 2, 2, 1, 8, 9, 15);
    final RodCutterBasic rodCutter = new RodCutterBasic(priceValues);
    System.out.println(rodCutter.maxProfit(5));
    System.out.println(rodCutter.maxProfit(22));

  }
}
