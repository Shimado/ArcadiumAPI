package com.github.Shimado.arcadiumapi.api;

import com.github.Shimado.arcadiumapi.interfaces.ISession;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

/**
 * Defines common methods that any game mode must implement.
 * Needed to automate opening the game mode through the main GUI, returning to the main menu, etc.
 */

public interface GameMethods {

    /**
     * Opens the game GUI for a given player.
     * Checks permissions to see if the player can access this mode.
     * Sets the music, statistics, bet change, and background items buttons.
     *
     * @param player the player who is opening the game
     * @param inv    the inventory (GUI) that will be shown to the player.
     *               It will already contain a title and some common items
     */

    void openGame(@NotNull Player player, @NotNull Inventory inv);


    /**
     * Handles logic when the game GUI is closed.
     * Here you can specify the return of the bet if the session has not started.
     * And the deletion of the player's data from the session.
     *
     * @param player   the player who closed the game inventory
     * @param session  the inventory session with some data
     */

    void closeGUI(@NotNull Player player, @NotNull ISession session);


    /**
     * Handles logic when the player interacts with the game GUI (clicking items, etc.).
     * Checks permissions to see if the player can access this mode.
     *
     * @param e       the inventory click event
     * @param player  the player who clicked
     * @param session the inventory session that stores some data {@link ISession}
     * @param slot    the clicked slot in the GUI
     */

    void clickGUI(@NotNull InventoryClickEvent e, @NotNull Player player, @NotNull ISession session, int slot);


    /**
     * Reloads the game mode, refreshing configuration or resetting state if needed.
     * Initially it comes empty in implementation.
     */

    void reload();

}
