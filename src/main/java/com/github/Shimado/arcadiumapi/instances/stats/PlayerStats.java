package com.github.Shimado.arcadiumapi.instances.stats;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Stores all player statistics: number of games, losses and etc
 */

public class PlayerStats extends ArcadiumStats {

    private UUID playerUUID;
    private Map<String, GameStats> gameStats = new HashMap<>();


    /**
     * Creates a new PlayerStats instance with only a UUID.
     * If you want to create a "clean" user with zero statistics.
     *
     * @param playerUUID unique identifier of the player
     */

    public PlayerStats(@NotNull UUID playerUUID){
        super();
        this.playerUUID = playerUUID;
    }

    /**
     * Creates a new PlayerStats instance with full statistics.
     *
     * @param playerUUID  unique identifier of the player
     * @param gamesPlayed number of games played
     * @param victories   number of victories
     * @param defeats     number of defeats
     * @param timePlayed  number of timePlayed
     */

    public PlayerStats(@NotNull UUID playerUUID, int gamesPlayed, int victories, int defeats, long timePlayed){
        super(gamesPlayed, victories, defeats, timePlayed);
        this.playerUUID = playerUUID;
    }


    /**
     * Gets the unique identifier of the player.
     *
     * @return the unique identifier of the player
     */

    @NotNull
    public UUID getPlayerUUID() {
        return playerUUID;
    }


    /**
     * Gets statistics for a specific game mode.
     *
     * @param gameName game mode name
     * @return game statistics or {@code null} if not found
     */

    @Nullable
    public GameStats getGameStats(@NotNull String gameName) {
        return gameStats.get(gameName);
    }

    /**
     * Gets statistics for all game modes.
     *
     * @return map of game statistics
     */

    @NotNull
    public Map<String, GameStats> getGameStats() {
        return gameStats;
    }

    /**
     * Sets or updates statistics for a specific game mode.
     *
     * @param gameName    game mode name
     * @param gameStats   game mode statistics
     */

    public void setGameStats(@NotNull String gameName, @NotNull GameStats gameStats) {
        if(gameName == null || gameName.isEmpty() || gameStats == null) return;
        this.gameStats.put(gameName, gameStats);
    }

    /**
     * Sets the statistics map for all games.
     *
     * @param gameStats map of game statistics
     */

    public void setGameStats(@NotNull Map<String, GameStats> gameStats) {
        if(gameStats == null) return;
        this.gameStats = gameStats;
    }

}
