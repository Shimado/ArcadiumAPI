package com.github.Shimado.arcadiumapi.instances.stats;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Stores global and per-game statistics for a player.
 * <p>
 * Tracks overall player performance such as games played,
 * victories, defeats, draws, playtime, score, and rating,
 * as well as detailed statistics for individual game modes.
 */
public class PlayerStats extends ArcadiumStats {

    private final UUID playerUUID;
    private Map<String, GameStats> gameStats = new HashMap<>();

    /**
     * Creates a fully initialized player statistics object.
     *
     * @param playerUUID  the UUID of the player
     * @param gamesPlayed total number of games played
     * @param victories   total number of victories
     * @param defeats     total number of defeats
     * @param draws       total number of draws
     * @param timePlayed  total playtime
     * @param score       score value
     * @param rating      rating value
     * @param gameStats   per-game statistics map
     */
    public PlayerStats(@NotNull UUID playerUUID, int gamesPlayed, int victories, int defeats, int draws, long timePlayed, long score, long rating, @NotNull Map<String, GameStats> gameStats){
        super(gamesPlayed, victories, defeats, draws, timePlayed, score, rating);
        this.playerUUID = playerUUID;
        setGameStats(gameStats);
    }

    /**
     * Creates a player statistics object without per-game statistics.
     *
     * @param playerUUID  the UUID of the player
     * @param gamesPlayed total number of games played
     * @param victories   total number of victories
     * @param defeats     total number of defeats
     * @param draws       total number of draws
     * @param timePlayed  total playtime
     * @param score       score value
     * @param rating      rating value
     */
    public PlayerStats(@NotNull UUID playerUUID, int gamesPlayed, int victories, int defeats, int draws, long timePlayed, long score, long rating){
        super(gamesPlayed, victories, defeats, draws, timePlayed, score, rating);
        this.playerUUID = playerUUID;
    }

    /**
     * Creates a player statistics object without score and rating data.
     *
     * @param playerUUID  the UUID of the player
     * @param gamesPlayed total number of games played
     * @param victories   total number of victories
     * @param defeats     total number of defeats
     * @param draws       total number of draws
     * @param timePlayed  total playtime
     */
    public PlayerStats(@NotNull UUID playerUUID, int gamesPlayed, int victories, int defeats, int draws, long timePlayed){
        super(gamesPlayed, victories, defeats, draws, timePlayed, 0, 0);
        this.playerUUID = playerUUID;
    }

    /**
     * Creates an empty player statistics object.
     *
     * @param playerUUID the UUID of the player
     */
    public PlayerStats(@NotNull UUID playerUUID){
        super();
        this.playerUUID = playerUUID;
    }


    /**
     * Gets the unique identifier of the player.
     *
     * @return the player's UUID
     */
    @NotNull
    public UUID getPlayerUUID() {
        return playerUUID;
    }


    /**
     * Gets statistics for a specific game mode.
     *
     * @param gameName the game mode name
     * @return the statistics for the specified game, or {@code null} if no statistics exist
     */
    @Nullable
    public GameStats getGameStats(@NotNull String gameName) {
        return gameStats.get(gameName);
    }


    /**
     * Gets statistics for all game modes.
     *
     * @return a map containing per-game statistics
     */
    @NotNull
    public Map<String, GameStats> getGameStats() {
        return gameStats;
    }


    /**
     * Sets or replaces statistics for a specific game mode.
     *
     * @param gameName   the game mode name
     * @param gameStats  the statistics object to store
     */
    public void setGameStats(@NotNull String gameName, @NotNull GameStats gameStats) {
        if(gameName == null || gameName.isEmpty() || gameStats == null) return;
        this.gameStats.put(gameName, gameStats);
    }


    /**
     * Replaces the entire per-game statistics map.
     *
     * @param gameStats the new statistics map
     */
    public void setGameStats(@NotNull Map<String, GameStats> gameStats) {
        if(gameStats == null) return;
        this.gameStats = gameStats;
    }

}
