package com.github.Shimado.arcadiumapi.api;

import com.github.Shimado.arcadiumapi.interfaces.ISession;
import com.github.Shimado.arcadiumapi.interfaces.PlacedGameTable;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * Manages player inventory sessions and their related state.
 * <p>
 * Provides methods for creating, retrieving, updating, and removing
 * player sessions, as well as handling inventory navigation
 * and session-related operations.
 */
public interface InvSession {

    /**
     * Gets all active player sessions.
     *
     * @return a map containing players and their associated sessions
     */
    @NotNull
    Map<Player, ISession> getSessions();


    /**
     * Gets the active session for the specified player.
     *
     * @param player the target player
     * @return the player's session, or {@code null} if no session exists
     */
    @Nullable
    ISession getSession(@NotNull Player player);


    /**
     * Removes the active session for the specified player.
     *
     * @param player the player whose session should be removed
     */
    void removeSession(@NotNull Player player);


    /**
     * Gets the player's current session,
     * or creates a new session if none exists.
     *
     * @param player the target player
     * @return the existing or newly created session
     */
    @NotNull
    ISession getOrCreateNewSession(@NotNull Player player);


    /**
     * Gets the player's current session if available.
     * <p>
     * If no session exists, the player's inventory is closed.
     *
     * @param player the target player
     * @return the player's session, or {@code null} if no session exists
     */
    @Nullable
    ISession getSessionOrCloseInventory(@NotNull Player player);


    /**
     * Removes a specific table from any session it is associated with.
     *
     * @param placedGameTable the placed game table to remove from all sessions
     */
    void removeTableFromSession(@Nullable PlacedGameTable placedGameTable);


    /**
     * Returns the player to the previous inventory page,
     * if such a page exists in the session history.
     *
     * @param player the player to return
     */
    void returnToPreviousPage(@NotNull Player player);


    /**
     * Reloads all active sessions and their states.
     */
    void reload();
}

