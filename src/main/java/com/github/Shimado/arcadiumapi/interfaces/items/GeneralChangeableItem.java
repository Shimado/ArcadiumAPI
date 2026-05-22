package com.github.Shimado.arcadiumapi.interfaces.items;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

/**
 * Represents an item that can change or have multiple variations across same slots.
 * Provides mapping between slot positions and their corresponding GeneralItem instances.
 */
public interface GeneralChangeableItem {

    /**
     * Gets the list of slot positions where this changeable item can be displayed in the GUI.
     *
     * @return a non-null list of slot indices
     */
    @NotNull
    List<Integer> getSlots();


    /**
     * Gets a mapping of some integer values, for example, page numbers to their respective GeneralItem instances.
     * Each entry represents a specific item variation assigned to a specific number.
     *
     * @return a non-null map with GeneralItem objects
     */
    @NotNull
    Map<Integer, GeneralItem> getItems();

}
