package com.afchung.tang.example.sock;

import com.afchung.tang.example.materials.Cotton;
import com.afchung.tang.example.materials.Material;

import javax.inject.Inject;

/**
 * Created by anchung on 10/27/2015.
 */
public final class CottonSocks implements Socks {
  private final Material material = new Cotton();

  @Inject
  private CottonSocks() {
  }

  public Material getMaterial() {
    return material;
  }

  public String getName() {
    return "Cotton Socks";
  }

  public String getColor() {
    return "White";
  }
}
