package com.promindis.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Tickers implements PriceFinders, Stocks, Timers, Runnable {
  public static final List<String> symbols = Arrays.asList(
    "AMD", "HPQ", "IBM", "TXN", "VMW", "XRX", "AAPL", "ADBE",
    "AMZN", "CRAY", "CSCO", "DELL", "GOOG", "INTC", "INTU",
    "MSFT", "ORCL", "TIBX", "VRSN", "YHOO");

  private Function<Stream<String>, StockInfo> findHighPrice(final long max) {
    return tickets -> tickets
      .map(this::getPrice)
      .filter(this.isPriceLessThan(max))//this added for symmetry
      .reduce(this::pickHighest)
      .get();
  }

  private StockInfo getPrice(final String ticker) {
    return new StockInfo(ticker, yahooFinance.apply(ticker));
  }

  @Override
  public void run() {
//    final StringJoiner r = symbols.stream()
//      .filter(ticker -> yahooFinance.apply(ticker).longValue() > 100)
//      .sorted()
//      .collect(Collectors.toStringJoiner(","));
//
//    System.out.println(String.format("Stocks priced over $100 are %s", r));

    final StockInfo r1 = timed(() -> findHighPrice(500).apply(symbols.stream()));
    System.out.println(String.format("High priced under $500 is %s ", r1));

    final StockInfo r2 = timed(() -> findHighPrice(500).apply(symbols.parallelStream()));
    System.out.println(String.format("High priced under $500 is %s ", r2));
  }

  public static void main(final String[] args) {
    new Tickers().run();
  }
}