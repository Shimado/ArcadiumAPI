package com.github.Shimado.arcadiumapi.interfaces;

import com.github.Shimado.arcadiumapi.enums.TableAnimationType;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Represents animation settings used for a game table.
 * <p>
 * Defines the animation type, dropped items,
 * drop chance, and item spawn amount used during
 * table animation effects.
 */
public interface TableAnimation {

    /**
     * Gets the animation type used for the table.
     *
     * @return the configured table animation type
     */
    @NotNull
    TableAnimationType getTableAnimationType();


    /**
     * Gets the list of items that may be spawned
     * or dropped during the animation.
     *
     * @return a non-null list of item stacks
     */
    @NotNull
    List<ItemStack> getItemsToDrop();


    /**
     * Gets the chance for an item to spawn or drop
     * during an animation cycle.
     * <p>
     * The value is typically between:
     * <ul>
     *     <li>{@code 0.0} - item never spawns</li>
     *     <li>{@code 100.0} - item always spawns</li>
     * </ul>
     *
     * @return the item drop chance percentage
     */
    double getDropSpawnChance();


    /**
     * Gets the maximum number of items that may be spawned
     * or dropped during a single animation cycle.
     *
     * @return the item amount per cycle
     */
    int getItemsAmount();

}

