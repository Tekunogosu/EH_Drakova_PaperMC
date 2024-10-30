package com.eldritchhollows.Drakova.utils;

import org.bukkit.Material;

import java.util.List;

public class BlockUtils {

    public static boolean IsLike(Material source, List<Material> materials) {
        return materials.contains(source);
    }
}
