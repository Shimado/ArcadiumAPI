package com.github.Shimado.arcadiumapi.interfaces;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a configurable game table item definition.
 * <p>
 * Stores metadata and visual configuration for a game table item,
 * including its identifier, materials, model data,
 * linked game mode, and optional animation settings.
 * <p>
 * This interface describes the item definition itself,
 * not a placed table instance in the world.
 */
public interface GameTableItem {

    /**
     * Gets the unique identifier of this table item.
     *
     * @return the table item ID
     */
    @NotNull
    String getID();


    /**
     * Gets the block material used for the table.
     *
     * @return the table block material
     */
    @NotNull
    Material getBlockMaterial();


    /**
     * Gets the item representation of this table.
     *
     * @return the table item stack
     */
    @NotNull
    ItemStack getTableItem();


    /**
     * Gets the custom model data assigned to this table item.
     *
     * @return the custom model data value
     */
    int getCustomModelData();


    /**
     * Gets the game mode associated with this table item.
     * <p>
     * May return {@code "ALL"} if the table item
     * supports multiple game modes.
     *
     * @return the associated game mode name
     */
    @NotNull
    String getGameName();


    /**
     * Gets the item to decorate the gaming table
     *
     * @return the item to decorate the gaming table, or {@code null} if there are no decorations at all
     * **/
    @Nullable
    ItemStack getDecorationItem();



    /**
     * Gets the animation configuration assigned to this table.
     *
     * @return the table animation configuration, or {@code null} if no animation is configured
     */
    @Nullable
    TableAnimation getTableAnimation();

}

