package com.promindis.jdk8;

import java.math.BigDecimal;
import java.util.function.Function;

public final class CalculateNAV {
  private final Function<String, BigDecimal> priceFinder;

  public CalculateNAV(final Function<String, BigDecimal> priceFinder) {
    this.priceFinder = priceFinder;
  }

  public BigDecimal computeStockWorth(final String ticker, final int shares) {
    return priceFinder.apply(ticker).multiply(new BigDecimal(shares)) ;
  }
}
