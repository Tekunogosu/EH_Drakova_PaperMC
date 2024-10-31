package com.eldritchhollows.Drakova.utils;

import com.eldritchhollows.Drakova.DrakovaPlugin;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.metadata.MetadataValue;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BlockUtils {

    /**
     * This is used as a key for crafting stations to get/set their metadata
     */
    public static final String PlayerCraft = "player_craft";

    public static boolean IsLike(Material source, List<Material> materials) {
        return materials.contains(source);
    }

    /**
     * Helper method to easily remove metadata from a block
     *
     * @param block
     * @param key
     * @param metadataClass
     * @param plugin
     * @return <b>true</b> if successful<br/><b>false</b> otherwise
     */
    public static boolean RemoveBlockMetadata(@NotNull Block block, String key, Class<?> metadataClass, DrakovaPlugin plugin) {
        if (block.hasMetadata(key)) {
            List<MetadataValue> values = block.getMetadata(key);
            for (MetadataValue data : values) {
                if (data.getOwningPlugin() == plugin && metadataClass.isInstance(data.value())) {
                    block.removeMetadata(key, plugin);
                    return true;
                }
            }
        }
        return false;
    }
}
