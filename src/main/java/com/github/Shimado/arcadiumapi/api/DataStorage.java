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
 * Provides access to persistent and runtime data used in the game system.
 * This interface defines methods to retrieve bet items, player-related data and game statistics.
 */

public interface DataStorage {

    /**
     * Gets the base bet item used in the plugin.
     * Needed if the token type is "ITEMS"
     * If the item is not {@code null}, then players will be able to bet only with this item.
     *
     * @return the bet {@link ItemStack} or {@code null}
     */

    @Nullable
    ItemStack getBetItem();


    /**
     * Gets the settings of a specific player.
     *
     * @param playerUUID the unique identifier of the player
     * @return the {@link PlayerSettings} of the player, or {@code null} if not found
     */

    @Nullable
    PlayerSettings getPlayerSettings(@Nullable UUID playerUUID);


    /**
     * Gets the player's internal in-plugin balance.
     * Use {@link EconomyUtil} to get the balance.
     *
     * @param playerUUID the unique identifier of the player
     * @return the balance as a double
     */

    double getBalance(@Nullable UUID playerUUID);


    /**
     * Gets all registered player statistics.
     *
     * @return a map of player UUIDs to {@link PlayerStats}
     */

    @NotNull
    Map<UUID, PlayerStats> getPlayerStats();


    /**
     * Gets statistics of a specific player.
     *
     * @param playerUUID the unique identifier of the player
     * @return the {@link PlayerStats} of the player, or {@code null} if not found
     */

    @Nullable
    PlayerStats getPlayerStats(@Nullable UUID playerUUID);


    /**
     * Gets overall statistics for all game modes.
     * Where is the map key, this is the name of the game mode.
     *
     * @return a map of game names to {@link GameStats}
     */

    @NotNull
    Map<String, GameStats> getGameStats();


    /**
     * Gets statistics for a specific game mode.
     *
     * @param gameName the name of the game
     * @return the {@link GameStats}, or {@code null} if not found
     */

    @Nullable
    GameStats getGameStats(@Nullable String gameName);


    /**
     * Gets a queue of all player logs that contain data on the game played and its results:
     * Prizes, victory/defeat, player UUID/name, game mode and etc
     *
     * @return a queue of all player logs.
     */

    @NotNull
    Queue<GameLog> getGameLogs();


    /**
     * Gets a queue of the player logs that contain data on the game played and its results:
     * Prizes, victory/defeat, player UUID/name, game mode and etc
     *
     * @param playerUUID the unique identifier of the player
     * @return a queue of all logs for a given player, or empty queue
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
