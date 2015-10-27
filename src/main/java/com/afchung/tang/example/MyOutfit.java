package com.afchung.tang.example;

import com.afchung.tang.example.top.Top;
import com.afchung.tang.example.top.parameters.TopLayers;
import org.apache.reef.tang.annotations.Parameter;

import javax.inject.Inject;
import java.util.Set;

/**
 * Created by anchung on 10/26/2015.
 */
public final class MyOutfit {
    private final String SYS_SEPARATOR = "line.separator";
    private final Set<Top> topLayers;
    private final Wearer wearer;

    @Inject
    private MyOutfit(@Parameter(TopLayers.class) final Set<Top> topLayers,
                     final Wearer wearer) {
        this.topLayers = topLayers;
        this.wearer = wearer;
    }

    @Override
    public String toString(){
        final StringBuilder sb = new StringBuilder();
        sb.append("Wearer name is: " + wearer.getName());

        int i = 1;
        for (final Top top : topLayers) {
            sb.append(System.getProperty(SYS_SEPARATOR));
            sb.append("#" + (i++) + " top layer is: " + top.getName());
        }

        return sb.toString();
    }
}
