package com.promindis.jdk8;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public final class AssetUtil extends Assets implements Runnable {
  private static final List<Asset> assets = Arrays.asList(
    new Asset(Asset.AssetType.BOND, new BigDecimal(1000)),
    new Asset(Asset.AssetType.BOND, new BigDecimal(2000)),
    new Asset(Asset.AssetType.STOCK, new BigDecimal(3000)),
    new Asset(Asset.AssetType.STOCK, new BigDecimal(4000))
  );

  @Override
  public void run() {
    System.out.println("Total of all assets: " + totalAssetValues(assets));
    System.out.println("Total of all bonds: " + totalBondValue(assets));
    System.out.println("Total of all stocks: " + totalStockValue(assets));

  }

  public static void main(final String[] args) {
    new AssetUtil().run();
  }
}
