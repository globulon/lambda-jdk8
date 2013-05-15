package com.promindis.jdk8;

import java.math.BigDecimal;
import static java.math.BigDecimal.ZERO;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public abstract class Assets {
  protected BigDecimal totalAssetValues(final List<Asset> assets) {
    return assets.stream()
      .map(Asset::value).reduce(BigDecimal::add).orElse(ZERO);
  }

  private boolean isStock(final Asset asset) {
    return Asset.AssetType.BOND == asset.type();
  }

  private boolean isBond(final Asset asset) {
    return Asset.AssetType.STOCK == asset.type();
  }

  protected BigDecimal totalStockValue(final List<Asset> assets) {
    return totalValue(this::isStock).apply(assets);
  }

  protected BigDecimal totalBondValue(final List<Asset> assets) {
    return totalValue(this::isBond).apply(assets);
  }

  protected Function<List<Asset>, BigDecimal> totalValue(final Predicate<Asset> p) {
    return assets ->
      assets.stream().filter(p)
        .map(Asset::value).reduce(BigDecimal::add).orElse(ZERO);
  }
}
