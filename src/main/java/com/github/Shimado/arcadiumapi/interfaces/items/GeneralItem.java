package com.github.Shimado.arcadiumapi.interfaces.items;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Represents a general item.
 * Provides common item properties such as slots in the GUI, material, title, lore, and custom model data.
 */
public interface GeneralItem {

    /**
     * Gets the list of slot positions where this item can be placed in the GUI.
     *
     * @return a non-null list of slot indices
     */
    @NotNull
    List<Integer> getSlots();


    /**
     * Gets the material of this item.
     * The returned object type depends on the implementation (e.g., Material, String, Head String, ItemStack).
     *
     * @return the item material, or {@code null} if not set
     */
    @Nullable
    Object getMaterial();


    /**
     * Gets the display title of this item.
     *
     * @return the item title, or {@code null} if not set
     */
    @Nullable
    String getTitle();


    /**
     * Gets the lore (description lines) of this item.
     *
     * @return a non-null list of lore strings
     */
    @NotNull
    List<String> getLore();


    /**
     * Gets the custom model data value for this item.
     * Used for resource pack model overrides.
     *
     * @return the custom model data integer
     */
    int getCustomModelData();


    /**
     * Gets the actual ItemStack representation of this item.
     * May be generated dynamically based on other properties.
     *
     * @return the ItemStack, or {@code null} if not available or not generated yet
     */
    @Nullable
    ItemStack getItem();

}
