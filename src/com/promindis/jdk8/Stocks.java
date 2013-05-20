package com.promindis.jdk8;

import java.math.BigDecimal;
import java.util.function.Predicate;

public interface Stocks {
  final class StockInfo {
    final String ticker;
    final BigDecimal price;

    public StockInfo(String ticker, BigDecimal price) {
      this.ticker = ticker;
      this.price = price;
    }

    @Override
    public String toString() {
      return String.format("ticker: %s price: %g", ticker, price);
    }
  }

  default Predicate<StockInfo> isPriceLessThan(final long value) {
    return stockInfo -> stockInfo.price.longValue() < value;
  }

  default StockInfo pickHighest(final StockInfo si1, final StockInfo si2) {
    return (si1.price.compareTo(si2.price) < 0) ? si2 : si1;
  }
}
