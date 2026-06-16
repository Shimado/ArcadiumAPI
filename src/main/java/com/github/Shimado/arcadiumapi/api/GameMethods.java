package com.github.Shimado.arcadiumapi.api;

import com.github.Shimado.arcadiumapi.interfaces.ISession;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

/**
 * Defines the core methods that every game mode must implement.
 * <p>
 * These methods are used to automate common game interactions such as
 * opening the game from the main GUI, handling inventory interactions,
 * returning to previous menus, and reloading game state.
 */
public interface GameMethods {

    /**
     * Returns the current number of players online in this game mode.
     *
     * @return the number of active players
     */
    int getGameOnline();


    /**
     * Opens the game GUI for the specified player.
     * <p>
     * Performs access checks and initializes standard GUI elements
     * such as music controls, notifications, statistics, bet controls,
     * and background items.
     *
     * @param player      the player opening the game GUI
     * @param session     the inventory session containing game-related data
     * @param withoutBet  whether the game can be started without placing a bet
     */
    void openGame(@NotNull Player player, @NotNull ISession session, boolean withoutBet);


    /**
     * Handles logic executed when the game GUI is closed.
     * <p>
     * This may include refunding bets if the game has not started yet
     * and clearing player-related session data.
     *
     * @param player     the player who closed the GUI
     * @param session    the inventory session containing game-related data
     * @param fullClose  whether the GUI is being fully closed instead of returning to a previous menu
     *
     * @return {@code true} if the game was fully closed, otherwise {@code false}
     */
    boolean closeGUI(@NotNull Player player, @NotNull ISession session, boolean fullClose);


    /**
     * Handles player interaction within the game GUI.
     * <p>
     * Processes inventory clicks and validates whether the player
     * has access to the game mode.
     *
     * @param e        the inventory click event
     * @param player   the player who clicked in the GUI
     * @param session  the inventory session containing game-related data
     * @param slot     the clicked inventory slot
     */
    void clickGUI(@NotNull InventoryClickEvent e, @NotNull Player player, @NotNull ISession session, int slot);


    /**
     * Handles interaction with the close button in the GUI.
     * <p>
     * Performs permission checks and processes returning
     * to the previous menu or closing the inventory.
     *
     * @param e        the inventory click event
     * @param player   the player who clicked the button
     * @param session  the inventory session containing game-related data
     * @param slot     the clicked inventory slot
     */
    void clickCloseButton(@NotNull InventoryClickEvent e, @NotNull Player player, @NotNull ISession session, int slot);


    /**
     * Handles interaction with the restart game button.
     * <p>
     * Performs permission checks and restarts the current game session.
     *
     * @param e        the inventory click event
     * @param player   the player who clicked the button
     * @param session  the inventory session containing game-related data
     * @param slot     the clicked inventory slot
     */
    void clickRestartButton(@NotNull InventoryClickEvent e, @NotNull Player player, @NotNull ISession session, int slot);


    /**
     * Reloads the game mode configuration or internal state.
     * <p>
     * By default, implementations may leave this method empty
     * if no reload handling is required.
     */
    void reload();

}
