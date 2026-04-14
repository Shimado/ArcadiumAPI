package com.github.Shimado.arcadiumapi.api;

import com.github.Shimado.arcadiumapi.instances.ArcadiumGame;
import com.github.Shimado.arcadiumapi.instances.GameBet;
import com.github.Shimado.arcadiumapi.interfaces.PlacedGameTable;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

/**
 * API for handling game results in the plugin system.
 * Provides methods for processing victories, and defeats of players in a specific game mode.
 * Handles prize payouts, statistics, http requests and everything else.
 */

public interface VictoryUtil {

    /**
     * Processes the player's win by multiplying his bet by the multiplier.
     * Does not clear chip information after implementation.
     *
     * @param player          the winning player
     * @param bet             the bet placed by the player
     * @param gameMode        the game mode where the win occurred
     * @param multiplier      the payout multiplier applied to the bet
     * @param tableLocation   the location of the table where the game was played
     * @param tableOwnerUUID  the UUID of the table owner
     */

    void victory(@NotNull Player player, @NotNull GameBet bet, @NotNull ArcadiumGame gameMode, double multiplier, @Nullable Location tableLocation, @Nullable UUID tableOwnerUUID);

    /**
     * Processes the player's win by multiplying his bet by the multiplier.
     * Does not clear chip information after implementation.
     *
     * @param player          the winning player
     * @param bet             the bet placed by the player
     * @param gameMode        the game mode where the win occurred
     * @param multiplier      the payout multiplier applied to the bet
     * @param gameTable       the placed game table instance. Stores the location of the table where the game was played and the UUID of the table owner
     */

    void victory(@NotNull Player player, @NotNull GameBet bet, @NotNull ArcadiumGame gameMode, double multiplier, @Nullable PlacedGameTable gameTable);

    /**
     * Handles a player win when a player wins other players' bets.
     * Does not clear chip information after implementation.
     *
     * @param player          the winning player
     * @param bet             the main bet placed by the player
     * @param prizeBets       the list of another player bets
     * @param gameMode        the game mode where the win occurred
     * @param tableLocation   the location of the table where the game was played
     */

    void victory(@NotNull Player player, @NotNull GameBet bet, @NotNull List<GameBet> prizeBets, @NotNull ArcadiumGame gameMode, @Nullable Location tableLocation);

    /**
     * Handles a player win when a player wins other players' bets.
     * Does not clear chip information after implementation.
     *
     * @param player          the winning player
     * @param bet             the main bet placed by the player
     * @param prizeBets       the list of another player bets
     * @param gameMode        the game mode where the win occurred
     * @param gameTable       the placed game table instance. Stores the location of the table where the game was played and the UUID of the table owner
     */

    void victory(@NotNull Player player, @NotNull GameBet bet, @NotNull List<GameBet> prizeBets, @NotNull ArcadiumGame gameMode, @Nullable PlacedGameTable gameTable);


    /**
     * Handles a player's loss.
     * Does not clear chip information after implementation.
     *
     * @param player          the player who lost
     * @param bet             the bet placed by the player
     * @param gameMode        the game mode where the loss occurred
     * @param tableLocation   the location of the table where the game was played
     * @param tableOwnerUUID  the UUID of the table owner
     */

    void defeat(@NotNull Player player, @NotNull GameBet bet, @NotNull ArcadiumGame gameMode, @Nullable Location tableLocation, @Nullable UUID tableOwnerUUID);

    /**
     * Handles a player's loss.
     * Does not clear chip information after implementation.
     *
     * @param player          the player who lost
     * @param bet             the bet placed by the player
     * @param gameMode        the game mode where the loss occurred
     * @param gameTable       the placed game table instance. Stores the location of the table where the game was played and the UUID of the table owner
     */

    void defeat(@NotNull Player player, @NotNull GameBet bet, @NotNull ArcadiumGame gameMode, @Nullable PlacedGameTable gameTable);


    /**
     * Handles a player's draw.
     * Does not clear chip information after implementation.
     *
     * @param player          the player who lost
     * @param bet             the bet placed by the player
     * @param gameMode        the game mode where the loss occurred
     */

    void draw(@NotNull Player player, @NotNull GameBet bet, @NotNull ArcadiumGame gameMode);

}
