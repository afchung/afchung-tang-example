package com.afchung.tang.example.top.jacket;

import com.afchung.tang.example.top.jacket.parameters.Color;
import com.afchung.tang.example.top.jacket.parameters.Length;
import com.afchung.tang.example.top.jacket.parameters.Thickness;
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
            .bindNamedParameter(Color.class, COLOR)
            .bindNamedParameter(Thickness.class, THICKNESS)
            .bindNamedParameter(Length.class, LENGTH)
            .build();

    private JacketConfiguration() {
    }
}
