package com.afchung.tang.example.top.jacket;

import com.afchung.tang.example.top.jacket.parameters.JacketColor;
import com.afchung.tang.example.top.jacket.parameters.JacketLength;
import com.afchung.tang.example.top.jacket.parameters.JacketThickness;
import org.apache.reef.tang.formats.ConfigurationModule;
import org.apache.reef.tang.formats.ConfigurationModuleBuilder;
import org.apache.reef.tang.formats.OptionalParameter;
import org.apache.reef.tang.formats.RequiredParameter;

/**
 * Created by anchung on 10/26/2015.
 */
public final class JacketConfiguration extends ConfigurationModuleBuilder {
  public static final RequiredParameter<String> COLOR = new RequiredParameter<String>();
  public static final OptionalParameter<Integer> THICKNESS = new OptionalParameter<Integer>();
  public static final OptionalParameter<Integer> LENGTH = new OptionalParameter<Integer>();

  public static final ConfigurationModule CONF = new JacketConfiguration()
      .bindNamedParameter(JacketColor.class, COLOR)
      .bindNamedParameter(JacketThickness.class, THICKNESS)
      .bindNamedParameter(JacketLength.class, LENGTH)
      .build();

  private JacketConfiguration() {
  }
}
