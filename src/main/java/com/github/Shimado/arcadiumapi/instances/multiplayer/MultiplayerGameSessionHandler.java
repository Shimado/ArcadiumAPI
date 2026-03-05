package com.github.Shimado.arcadiumapi.instances.multiplayer;

import com.github.Shimado.arcadiumapi.ArcadiumAPI;
import com.github.Shimado.arcadiumapi.api.GameUtil;
import com.github.Shimado.arcadiumapi.instances.ArcadiumGame;
import com.github.Shimado.arcadiumapi.interfaces.CycleRunnable;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * A handler that manages multiple multiplayer game session hubs and their associated player sessions.
 * This class serves as a high-level manager for coordinating multiple game instances, handling player
 * join operations, session allocation, and bulk operations across all active game sessions.
 */

public abstract class MultiplayerGameSessionHandler<S extends MultiplayerGameSession, H extends MultiplayerGameSessionsHub<S>> {

    private GameUtil gameUtil = ArcadiumAPI.getGameUtil();

    private int maxPlayers = 0;
    private Map<UUID, H> sessions = new HashMap<>();

    /**
     * Constructs a new multiplayer game session handler with no maximum player limit.
     * Sessions created by this handler will not enforce player limits.
     */

    public MultiplayerGameSessionHandler() {}

    /**
     * Constructs a new multiplayer game session handler with the specified maximum player limit.
     * Once the limit is reached, new players will not be able to connect.
     *
     * @param maxPlayers the maximum number of players allowed per session hub
     */

    public MultiplayerGameSessionHandler(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }


    protected abstract H createHub(@NotNull UUID sessionUUID);

    /**
     * Gets the maximum number of players allowed per session hub.
     * Once the limit is reached, new players will not be able to connect.
     *
     * @return the maximum players per session, or 0 if no limit is set
     */

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public MultiplayerGameSessionHandler setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        return this;
    }

    /**
     * Gets all session hubs managed by this handler.
     *
     * @return a map of session UUIDs to their respective session hubs
     */

    @NotNull
    public Map<UUID, H> getSessions() {
        return sessions;
    }

    /**
     * Joins a player to an appropriate game session, creating a new session if necessary.
     * This method implements a matchmaking system that:
     * <ol>
     *   <li>First searches for existing open sessions that have available slots</li>
     *   <li>If no suitable session is found, creates a new session with a random UUID</li>
     *   <li>Adds the player's game session to the selected hub</li>
     * </ol>
     *
     * <p>The method respects the maximum player limit set for this handler when searching
     * for available sessions.</p>
     *
     * @param player the player to join to a game session
     * @param gameSession the game session instance for the player
     * @return the session hub that the player was joined to
     */

    @NotNull
    public H joinPlayerToGame(@NotNull Player player, @NotNull S gameSession) {
        H result = null;

        for (H session : sessions.values()) {
            if (session.isOpened() && session.getPlayerAmountWithActiveBetsAndSlots() < maxPlayers) {
                result = session;
                break;
            }
        }

        if (result == null) {
            UUID sessionUUID = UUID.randomUUID();
            result = sessions.computeIfAbsent(sessionUUID, k -> createHub(sessionUUID));
        }

        result.addPlayerSession(player, gameSession);
        return result;
    }

    /**
     * Gets the session hub that contains the specified player.
     *
     * @param player the player to search for
     * @return the session hub containing the player, or null if the player is not in any session
     */

    @Nullable
    public H getMultiplayerGameSessionHub(@NotNull Player player) {
        for (H session : sessions.values()) {
            if (session.getPlayerSessions().containsKey(player)) {
                return session;
            }
        }
        return null;
    }

    /**
     * Gets the specific game session for a player.
     *
     * @param player the player whose game session to retrieve
     * @return the player's game session, or null if the player is not in any session
     */

    @Nullable
    public S getGameSession(@NotNull Player player) {
        for (H session : sessions.values()) {
            S gameSession = session.getPlayerSessions().get(player);
            if (gameSession != null) {
                return gameSession;
            }
        }
        return null;
    }

    /**
     * Removes a specific session hub from the handler.
     *
     * @param sessionUUID the UUID of the session hub to remove
     */

    public void removeSession(@NotNull UUID sessionUUID) {
        sessions.remove(sessionUUID);
    }

    /**
     * Reloads all session hubs and performs cleanup operations.
     * This method:
     * <ol>
     *   <li>Cancels all cycle tasks in all sessions</li>
     *   <li>Reloads the game GUI for all players in all sessions</li>
     *   <li>Clears all player sessions from each hub</li>
     *   <li>Marks all sessions as closed</li>
     *   <li>Clears all sessions from the handler</li>
     * </ol>
     *
     * <p>This is typically used during game mode reload</p>
     *
     * @param arcadiumGame the game mode instance to use for reloading GUIs
     */

    public void reload(@NotNull ArcadiumGame arcadiumGame, @NotNull CycleRunnable cancelCycleRunnable) {
        for (H session : sessions.values()) {
            cancelCycleRunnable.run(session.getCycleID());
            gameUtil.reloadSingleplayerGameGUI(session.getPlayerSessions(), arcadiumGame);
            session.setPlayerSessions(new HashMap<>());
            session.setOpened(false);
        }
        sessions.clear();
        arcadiumGame.setGameOnline(0);
    }
}
