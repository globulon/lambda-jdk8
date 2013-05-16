package com.promindis.jdk8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.Function;

public interface PriceFinders {

  final Function<String, BigDecimal> yahooFinance =
    ticker -> {
      try {
        try (final BufferedReader reader = fromURL(url(ticker))) {
          final String data = reader.lines().substream(1).findFirst().get();
          final String[] dataItems = data.split(",");
          return new BigDecimal(dataItems[dataItems.length - 1]);
        }
      } catch (Exception ex) {
        throw new RuntimeException(ex);
      }
    };

  static URL url(String ticker) throws MalformedURLException {
    return new URL("http://ichart.finance.yahoo.com/table.csv?s=" + ticker);
  }

  static BufferedReader fromURL(URL url) throws IOException {
    return new BufferedReader(new InputStreamReader(url.openStream()));
  }
}