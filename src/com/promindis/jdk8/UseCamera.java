package com.promindis.jdk8;

import java.awt.*;
import java.util.function.Consumer;
import static com.promindis.jdk8.Camera.*;

public final class UseCamera {
  private UseCamera() {
    super();
  }

  private static Consumer<Camera> printCaptured(final String filterInfo) {
    return camera -> {
      System.out.println(String.format("with %s: %s", filterInfo,
        camera.capture(new Color(200, 100, 200))));
    };
  }

  public static void main(final String[] args) {
    printCaptured("no filter").accept(makeCamera());
    printCaptured("darker filter").accept(makeCamera(Color::darker));
    printCaptured("darker and brighter filter").accept(makeCamera(Color::darker, Color::brighter));
  }
}
