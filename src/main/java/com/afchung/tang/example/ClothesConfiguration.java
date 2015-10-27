package com.afchung.tang.example;

import com.afchung.tang.example.top.Top;
import com.afchung.tang.example.top.parameters.TopLayers;
import org.apache.reef.tang.formats.ConfigurationModule;
import org.apache.reef.tang.formats.ConfigurationModuleBuilder;
import org.apache.reef.tang.formats.RequiredImpl;

/**
 * Created by anchung on 10/26/2015.
 */
public final class ClothesConfiguration extends ConfigurationModuleBuilder {
    public static final RequiredImpl<Top> TOP_LAYER = new RequiredImpl<Top>();

    public static final ConfigurationModule CONF = new ClothesConfiguration()
            .bindSetEntry(TopLayers.class, TOP_LAYER)
            .build();

    private ClothesConfiguration() {
    }
}
