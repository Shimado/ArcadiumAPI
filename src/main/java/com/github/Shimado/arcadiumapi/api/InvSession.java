package com.github.Shimado.arcadiumapi.api;

import com.github.Shimado.arcadiumapi.interfaces.ISession;
import com.github.Shimado.arcadiumapi.interfaces.PlacedGameTable;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * Represents a manager for player inventory sessions.
 * Provides methods to create, retrieve, update, and remove sessions
 * associated with players, as well as handle session-related actions.
 */

public interface InvSession {

    /**
     * Gets the map of all active player sessions.
     *
     * @return a map of players to their active sessions
     */

    @NotNull
    Map<Player, ISession> getSessions();


    /**
     * Gets the current session for the specified player.
     *
     * @param player the player
     * @return the player's session, or {@code null} if none exists
     */

    @Nullable
    ISession getSession(@NotNull Player player);


    /**
     * Removes the current session for the specified player.
     *
     * @param player the player whose session should be removed
     */

    void removeSession(@NotNull Player player);


    /**
     * Gets the existing session for the specified player,
     * or creates a new one if none exists.
     *
     * @param player the player
     * @return the existing or newly created session
     */

    @NotNull
    ISession getOrCreateNewSession(@NotNull Player player);


    /**
     * Gets the player's session if available,
     * or closes their inventory if no session exists.
     *
     * @param player the player
     * @return the player's session, or {@code null} if none exists
     */

    @Nullable
    ISession getSessionOrCloseInventory(@NotNull Player player);


    /**
     * Removes a specific table from any session it is associated with.
     *
     * @param placedGameTable the placed game table to remove from session
     */

    void removeTableFromSession(@Nullable PlacedGameTable placedGameTable);


    /**
     * Returns the player to their previous inventory page,
     * if available in the session history.
     *
     * @param player the player to return
     */

    void returnToPreviousPage(@NotNull Player player);


    /**
     * Reloads all active sessions and their states.
     */

    void reload();
}

