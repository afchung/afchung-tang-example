package com.afchung.tang.example.materials;

import org.apache.reef.tang.annotations.DefaultImplementation;

/**
 * Created by anchung on 10/27/2015.
 */
@DefaultImplementation(Cotton.class)
public interface Material {

  String getName();

  int getWarmness();
}
