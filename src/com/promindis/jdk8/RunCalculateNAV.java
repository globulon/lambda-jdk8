package com.promindis.jdk8;

import java.math.BigDecimal;
import java.util.function.Function;

public final class RunCalculateNAV implements PriceFinders {

  private RunCalculateNAV() {
    super();
  }

  private static CalculateNAV calculate(final Function<String, BigDecimal> getter) {
    return new CalculateNAV(getter);
  }

  public static void main(final String[] args) {
    System.out.println(String.format("100 shares of Google worth: $%.2f",
      calculate(yahooFinance).computeStockWorth("GOOG", 100)));
  }
}