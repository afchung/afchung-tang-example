package com.afchung.tang.example.top.shirt;

import com.afchung.tang.example.top.shirt.parameters.Length;
import com.afchung.tang.example.top.shirt.parameters.Color;
import com.afchung.tang.example.top.shirt.parameters.SleeveLength;
import org.apache.reef.tang.formats.ConfigurationModule;
import org.apache.reef.tang.formats.ConfigurationModuleBuilder;
import org.apache.reef.tang.formats.OptionalParameter;
import org.apache.reef.tang.formats.RequiredParameter;

/**
 * Created by anchung on 10/26/2015.
 */
public final class ShirtConfiguration extends ConfigurationModuleBuilder {
    public static final RequiredParameter<String> COLOR = new RequiredParameter<String>();
    public static final OptionalParameter<Integer> SLEEVE_LENGTH = new OptionalParameter<Integer>();
    public static final OptionalParameter<Integer> LENGTH = new OptionalParameter<Integer>();

    public static final ConfigurationModule CONF = new ShirtConfiguration()
            .bindNamedParameter(Color.class, COLOR)
            .bindNamedParameter(Length.class, LENGTH)
            .bindNamedParameter(SleeveLength.class, SLEEVE_LENGTH)
            .build();

    private ShirtConfiguration() {
    }
}
