package com.afchung.tang.example.top.jacket;

import com.afchung.tang.example.top.Top;
import org.apache.reef.tang.annotations.DefaultImplementation;

/**
 * Created by anchung on 10/26/2015.
 */
@DefaultImplementation(DownJacket.class)
public interface Jacket extends Top {
    int getThickness();
}
