package com.github.Shimado.arcadiumapi.api;

import com.github.Shimado.arcadiumapi.instances.stats.GameStats;
import com.github.Shimado.arcadiumapi.instances.stats.PlayerStats;
import com.github.Shimado.arcadiumapi.interfaces.GameLog;
import com.github.Shimado.arcadiumapi.interfaces.PlayerSettings;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.UUID;

/**
 * Provides access to persistent and runtime game data.
 * <p>
 * Includes methods for retrieving player settings, balances,
 * statistics, logs, bet items, and sorted leaderboard data.
 */
public interface DataStorage {

    /**
     * Gets the base item used for item-based betting.
     * <p>
     * Used when the token type is set to {@code ITEMS}.
     * If the returned item is not {@code null},
     * players will only be able to place bets using this item type.
     *
     * @return the configured bet item, or {@code null} if item-based betting is disabled
     */
    @Nullable
    ItemStack getBetItem();


    /**
     * Gets the settings associated with the specified player.
     *
     * @param playerUUID the UUID of the player
     * @return the player's settings, or {@code null} if no settings exist
     */
    @Nullable
    PlayerSettings getPlayerSettings(@Nullable UUID playerUUID);


    /**
     * Gets the player's internal plugin balance.
     * <p>
     * For economy-provider balances, use {@link EconomyUtil}.
     *
     * @param playerUUID the UUID of the player
     * @return the player's internal balance
     */
    double getBalance(@Nullable UUID playerUUID);


    /**
     * Gets statistics for all registered players.
     *
     * @return a map of player UUIDs to player statistics
     */
    @NotNull
    Map<UUID, PlayerStats> getPlayerStats();


    /**
     * Gets statistics for the specified player.
     *
     * @param playerUUID the UUID of the player
     * @return the player's statistics, or {@code null} if no statistics exist
     */
    @Nullable
    PlayerStats getPlayerStats(@Nullable UUID playerUUID);


    /**
     * Gets global statistics for all registered game modes.
     *
     * @return a map of game names to game statistics
     */
    @NotNull
    Map<String, GameStats> getGameStats();


    /**
     * Gets statistics for the specified game mode.
     *
     * @param gameName the game mode name
     * @return the game statistics, or {@code null} if no statistics exist
     */
    @Nullable
    GameStats getGameStats(@Nullable String gameName);


    /**
     * Gets all recorded game logs.
     * <p>
     * Logs may include information such as prizes,
     * victories, defeats, player data, and game mode details.
     *
     * @return a queue containing all recorded game logs
     */
    @NotNull
    Queue<GameLog> getGameLogs();


    /**
     * Gets all recorded game logs for the specified player.
     * <p>
     * Logs may include information such as prizes,
     * victories, defeats, player data, and game mode details.
     *
     * @param playerUUID the UUID of the player
     * @return a queue containing the player's game logs, or an empty queue if no logs exist
     */
    @NotNull
    Queue<GameLog> getPlayerGameLogs(@Nullable UUID playerUUID);


    /**
     * Gets a complete list of objects sorted by the required criteria.
     * @return the set of sorted objects
     * **/

    @NotNull
    Set<PlayerStats> getSortedStatsGamesPlayed();

    @NotNull
    Set<PlayerStats> getSortedStatsVictories();

    @NotNull
    Set<PlayerStats> getSortedStatsDefeats();

    @NotNull
    Set<PlayerStats> getSortedStatsDraws();

    @NotNull
    Set<PlayerStats> getSortedStatsTimePlayed();


    /**
     * Gets a complete list of objects sorted by the required criteria.
     * @return the set of sorted objects
     * **/

    @NotNull
    Set<PlayerStats> getSortedStatsGamesPlayed(@NotNull String gameName);

    @NotNull
    Set<PlayerStats> getSortedStatsVictories(@NotNull String gameName);

    @NotNull
    Set<PlayerStats> getSortedStatsDefeats(@NotNull String gameName);

    @NotNull
    Set<PlayerStats> getSortedStatsDraws(@NotNull String gameName);

    @NotNull
    Set<PlayerStats> getSortedStatsTimePlayed(@NotNull String gameName);

    @NotNull
    Set<PlayerStats> getSortedStatsScore(@NotNull String gameName);

    @NotNull
    Set<PlayerStats> getSortedStatsRating(@NotNull String gameName);


    /**
     * Gets a complete list of objects sorted by the required criteria.
     * @return the set of sorted objects
     * **/

    @NotNull
    Set<GameStats> getSortedGameStatsGamesPlayed();

    @NotNull
    Set<GameStats> getSortedGameStatsVictories();

    @NotNull
    Set<GameStats> getSortedGameStatsDefeats();

    @NotNull
    Set<GameStats> getSortedGameStatsDraws();

    @NotNull
    Set<GameStats> getSortedGameStatsTimePlayed();

}
