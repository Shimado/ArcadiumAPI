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
 * Provides methods for handling game results and reward processing.
 * <p>
 * Responsible for processing victories, defeats, and draws,
 * including payouts, statistics updates, rating changes,
 * HTTP requests, and other post-game actions.
 */
public interface VictoryUtil {

    /**
     * Processes a player victory with a payout multiplier applied to the bet.
     * <p>
     * Rewards the player, updates statistics and ratings,
     * and handles table-related payout logic.
     * Chip information is not automatically cleared after execution.
     *
     * @param player          the winning player
     * @param bet             the player's bet
     * @param game            the game mode where the victory occurred
     * @param multiplier      the payout multiplier applied to the bet
     * @param timePlayed      total session playtime in seconds
     * @param reachedScore    the score reached by the player
     * @param addedRating     the rating points awarded to the player
     * @param tableLocation   the location of the game table
     * @param tableOwnerUUID  the UUID of the table owner
     */
    void victory(@NotNull Player player, @Nullable GameBet bet, @NotNull ArcadiumGame game, double multiplier, long timePlayed, long reachedScore, int addedRating, @Nullable Location tableLocation, @Nullable UUID tableOwnerUUID);


    /**
     * Processes a player victory using a placed game table instance.
     * <p>
     * Chip information is not automatically cleared after execution.
     *
     * @param player         the winning player
     * @param bet            the player's bet
     * @param game           the game mode where the victory occurred
     * @param multiplier     the payout multiplier applied to the bet
     * @param timePlayed     total session playtime in seconds
     * @param reachedScore   the score reached by the player
     * @param addedRating    the rating points awarded to the player
     * @param gameTable      the placed game table instance
     */
    void victory(@NotNull Player player, @Nullable GameBet bet, @NotNull ArcadiumGame game, double multiplier, long timePlayed, long reachedScore, int addedRating, @Nullable PlacedGameTable gameTable);


    /**
     * Processes a victory where the player wins bets from other players.
     * <p>
     * Chip information is not automatically cleared after execution.
     *
     * @param player          the winning player
     * @param bet             the player's primary bet
     * @param allBets         the list of all played bets. The winner receives them as a prize
     * @param game            the game mode where the victory occurred
     * @param timePlayed      total session playtime in seconds
     * @param reachedScore    the score reached by the player
     * @param addedRating     the rating points awarded to the player
     * @param tableLocation   the location of the game table
     */
    void victory(@NotNull Player player, @Nullable GameBet bet, @NotNull List<@Nullable GameBet> allBets, @NotNull ArcadiumGame game, long timePlayed, long reachedScore, int addedRating, @Nullable Location tableLocation);


    /**
     * Processes a victory where the player wins bets from other players
     * using a placed game table instance.
     * <p>
     * Chip information is not automatically cleared after execution.
     *
     * @param player         the winning player
     * @param bet            the player's primary bet
     * @param allBets        the list of all played bets. The winner receives them as a prize
     * @param game           the game mode where the victory occurred
     * @param timePlayed     total session playtime in seconds
     * @param reachedScore   the score reached by the player
     * @param addedRating    the rating points awarded to the player
     * @param gameTable      the placed game table instance
     */
    void victory(@NotNull Player player, @Nullable GameBet bet, @NotNull List<@Nullable GameBet> allBets, @NotNull ArcadiumGame game, long timePlayed, long reachedScore, int addedRating, @Nullable PlacedGameTable gameTable);


    /**
     * Processes a player defeat.
     * <p>
     * Updates statistics, ratings, and other related systems.
     * Chip information is not automatically cleared after execution.
     *
     * @param player         the losing player
     * @param bet            the player's bet
     * @param allBets        the list of all played bets.
     * @param game           the game mode where the defeat occurred
     * @param timePlayed     total session playtime in seconds
     * @param reachedScore   the score reached by the player
     * @param addedRating    the rating points awarded to the player
     */
    void defeat(@NotNull Player player, @Nullable GameBet bet, @NotNull List<@Nullable GameBet> allBets, @NotNull ArcadiumGame game, long timePlayed, long reachedScore, int addedRating);

    void defeat(@NotNull Player player, @Nullable GameBet bet, @NotNull ArcadiumGame game, long timePlayed, long reachedScore, int addedRating);


    /**
     * Processes a game draw.
     * <p>
     * Chip information is not automatically cleared after execution.
     *
     * @param player       the player involved in the draw
     * @param bet          the player's bet
     * @param allBets      the list of all played bets.
     * @param game         the game mode where the draw occurred
     * @param timePlayed   total session playtime in seconds
     */
    void draw(@NotNull Player player, @Nullable GameBet bet, @NotNull List<@Nullable GameBet> allBets, @NotNull ArcadiumGame game, long timePlayed);

    void draw(@NotNull Player player, @Nullable GameBet bet, @NotNull ArcadiumGame game, long timePlayed);
}
