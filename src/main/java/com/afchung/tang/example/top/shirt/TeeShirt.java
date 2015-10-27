package com.afchung.tang.example.top.shirt;

import com.afchung.tang.example.materials.Material;
import com.afchung.tang.example.top.shirt.parameters.ShirtColor;
import com.afchung.tang.example.top.shirt.parameters.ShirtLength;
import org.apache.reef.tang.annotations.Parameter;

import javax.inject.Inject;

/**
 * Created by anchung on 10/26/2015.
 */
public final class TeeShirt implements Shirt {
  private final String color;
  private final int length;
  private final Material material;

  @Inject
  private TeeShirt(final Material material,
                   @Parameter(ShirtColor.class) final String color,
                   @Parameter(ShirtLength.class) final int length) {
    this.color = color;
    this.length = length;
    this.material = material;
  }

  public String getName() {
    return "T-shirt";
  }

  public String getColor() {
    return color;
  }

  public int getTopLength() {
    return length;
  }

  public Material getMaterial() {
    return material;
  }
}
