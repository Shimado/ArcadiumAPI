package com.github.Shimado.arcadiumapi.interfaces;

import com.github.Shimado.boomboxapi.instances.BoomboxSong;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Represents a selectable background music entry
 * used in the game GUI.
 * <p>
 * Stores information about the song, GUI placement,
 * and icons displayed for active and inactive states.
 */
public interface BackgroundSong {

    /**
     * Gets the GUI page where this background song is displayed.
     *
     * @return the page index
     */
    int getPage();


    /**
     * Gets the GUI slots occupied by this background song entry.
     *
     * @return a non-null list of slot indexes
     */
    @NotNull
    List<Integer> getSlots();


    /**
     * Gets the linked {@link BoomboxSong} instance.
     *
     * @return the associated song
     */
    @NotNull
    BoomboxSong getBoomboxSong();


    /**
     * Gets the icon displayed when the song is inactive
     * or not currently selected.
     *
     * @return the inactive icon, or {@code null} if not defined
     */
    @Nullable
    ItemStack getIconInactive();


    /**
     * Gets the icon displayed when the song is active
     * or currently selected.
     *
     * @return the active icon, or {@code null} if not defined
     */
    @Nullable
    ItemStack getIconActive();

}
