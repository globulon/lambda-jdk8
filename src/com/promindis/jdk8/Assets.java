package com.promindis.jdk8;

import java.math.BigDecimal;
import static java.math.BigDecimal.ZERO;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import static com.promindis.jdk8.Asset.AssetType.*;

public abstract class Assets {
  private Predicate<Asset> all = asset -> true;

  private Predicate<Asset> isBond = asset -> asset.type() == BOND;

  private Predicate<Asset> isStock = asset -> asset.type() == STOCK;

  protected BigDecimal totalAssetValues(final List<Asset> assets) {
    return totalValue(all).apply(assets);
  }

  protected BigDecimal totalStockValue(final List<Asset> assets) {
    return totalValue(isStock).apply(assets);
  }

  protected BigDecimal totalBondValue(final List<Asset> assets) {
    return totalValue(isBond).apply(assets);
  }

  protected Function<List<Asset>, BigDecimal> totalValue(final Predicate<Asset> p) {
    return assets ->
      assets.stream().filter(p)
        .map(Asset::value).reduce(BigDecimal::add).orElse(ZERO);
  }
}
