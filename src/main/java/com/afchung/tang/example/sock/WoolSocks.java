package com.afchung.tang.example.sock;

import com.afchung.tang.example.materials.Material;
import com.afchung.tang.example.materials.Wool;

import javax.inject.Inject;

/**
 * Created by anchung on 10/27/2015.
 */
public final class WoolSocks implements Socks {

  private Material material = new Wool();

  @Inject
  private WoolSocks() {
  }

  public Material getMaterial() {
    return material;
  }

  public String getName() {
    return "Wool socks";
  }

  public String getColor() {
    return "Gray";
  }
}
