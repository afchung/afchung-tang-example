package com.afchung.tang.example.sock;

import com.afchung.tang.example.ArticleOfClothing;
import com.afchung.tang.example.materials.Material;
import org.apache.reef.tang.annotations.DefaultImplementation;

/**
 * Created by anchung on 10/27/2015.
 */
@DefaultImplementation(CottonSocks.class)
public interface Socks extends ArticleOfClothing {
  Material getMaterial();
}
