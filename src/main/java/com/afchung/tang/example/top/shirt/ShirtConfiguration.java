package com.afchung.tang.example.top.shirt;

import com.afchung.tang.example.materials.Material;
import com.afchung.tang.example.top.shirt.parameters.ShirtLength;
import com.afchung.tang.example.top.shirt.parameters.ShirtColor;
import org.apache.reef.tang.formats.*;

/**
 * Created by anchung on 10/26/2015.
 */
public final class ShirtConfiguration extends ConfigurationModuleBuilder {
  public static final RequiredParameter<String> COLOR = new RequiredParameter<String>();
  public static final OptionalImpl<Material> MATERIAL = new OptionalImpl<Material>();
  public static final OptionalParameter<Integer> LENGTH = new OptionalParameter<Integer>();

  public static final ConfigurationModule CONF = new ShirtConfiguration()
      .bindNamedParameter(ShirtColor.class, COLOR)
      .bindNamedParameter(ShirtLength.class, LENGTH)
      .bindImplementation(Material.class, MATERIAL)
      .build();

  private ShirtConfiguration() {
  }
}
