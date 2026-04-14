package com.github.Shimado.arcadiumapi.interfaces;

import com.github.Shimado.arcadiumapi.enums.TableAnimationType;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Represents the animation configuration for a table.
 * Defines how items are spawned/dropped, the animation type,
 * and other related parameters.
 */

public interface TableAnimation {

    /**
     * Gets the type of table animation.
     *
     * @return the animation type
     */

    @NotNull
    TableAnimationType getTableAnimationType();


    /**
     * Gets the list of items that can be dropped during the animation.
     *
     * @return a non-null list of item stacks (may be empty)
     */

    @NotNull
    List<ItemStack> getItemsToDrop();


    /**
     * Gets the chance that an item will spawn/drop during the animation.
     * Value is typically between {@code 0.0} (never) and {@code 100.0}
     *
     * @return the drop spawn chance
     */

    double getDropSpawnChance();


    /**
     * Gets the amount of items that can be dropped per animation cycle.
     *
     * @return the number of items
     */

    int getItemsAmount();

}

