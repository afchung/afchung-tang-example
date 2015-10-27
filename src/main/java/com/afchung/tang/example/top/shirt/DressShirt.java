package com.afchung.tang.example.top.shirt;

import com.afchung.tang.example.materials.Material;
import com.afchung.tang.example.materials.Shiny;
import com.afchung.tang.example.top.shirt.parameters.ShirtColor;
import com.afchung.tang.example.top.shirt.parameters.ShirtLength;
import org.apache.reef.tang.annotations.Parameter;

import javax.inject.Inject;

/**
 * Created by anchung on 10/26/2015.
 */
public final class DressShirt implements Shirt {
  private final String color;
  private final int length;
  private final Material material = new Shiny();

  @Inject
  private DressShirt(@Parameter(ShirtColor.class) String color,
                     @Parameter(ShirtLength.class) int length) {
    this.color = color;
    this.length = length;
  }

  public String getName() {
    return "Dress shirt";
  }

  public String getColor() {
    return this.color;
  }

  public int getTopLength() {
    return this.length;
  }

  public Material getMaterial() {
    return material;
  }
}
