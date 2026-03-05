package com.github.Shimado.arcadiumapi.interfaces;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a configurable game table item definition.
 * Stores metadata such as ID, model data, linked game type,
 * table appearance (blocks and items), and optional animations.
 * Stores information about an item, not about the placed table.
 */

public interface GameTableItem {

    /**
     * Gets the unique identifier of this table item.
     *
     * @return the ID of the table
     */

    @NotNull
    String getID();

    /**
     * Gets the {@link Material} representing the table block material.
     *
     * @return the table block material
     */

    @NotNull
    Material getBlockMaterial();

    /**
     * Gets the {@link ItemStack} representing the table item.
     *
     * @return the table item
     */

    @NotNull
    ItemStack getTableItem();

    /**
     * Gets the custom model data value used for the item.
     *
     * @return the custom model data
     */

    int getCustomModelData();

    /**
     * Gets the game mode name associated with this table item.
     * Or "ALL".
     *
     * @return the game mode name or "ALL"
     */

    @NotNull
    String getGame();

    /**
     * Gets the Y-axis offset of the table decoration armor stands.
     *
     * @return the vertical offset
     */

    double getYOffset();

    /**
     * Gets the animation configuration for the game table.
     *
     * @return the table animation, or {@code null} if not set
     */

    @Nullable
    TableAnimation getTableAnimation();

}

