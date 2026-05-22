package com.github.Shimado.arcadiumapi.interfaces;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Represents a log entry for a completed game session.
 * Contains all relevant information about the game outcome, player statistics,
 * score changes, and betting results.
 */
public interface GameLog {

    /**
     * Gets the timestamp when the game was completed.
     *
     * @return a non-null LocalDateTime representing the game completion time
     */
    @NotNull
    LocalDateTime getDateTime();


    /**
     * Gets the unique identifier of the player who participated in the game.
     *
     * @return a non-null UUID of the player
     */
    @NotNull
    UUID getPlayerUUID();


    /**
     * Gets the display name of the player who participated in the game.
     *
     * @return a non-null string containing the player's name
     */
    @NotNull
    String getPlayerName();


    /**
     * Gets the unique identifiers of the rivals who participated in the game.
     *
     * @return a non-null list of the rival uuids
     */
    @NotNull
    List<UUID> getRivalUUIDs();


    /**
     * Gets the display names of the rivals who participated in the game.
     *
     * @return a non-null list containing the rival names
     */
    @NotNull
    List<String> getRivalNames();


    /**
     * Gets the ID of the game that was played.
     *
     * @return a non-null string containing the game ID
     */
    @NotNull
    String getGameID();


    /**
     * Gets the name of the game that was played.
     *
     * @return a non-null string containing the game name
     */
    @NotNull
    String getGameName();


    /**
     * Indicates whether the player achieved victory in the game.
     *
     * @return true if the player won, false otherwise
     */
    boolean isVictory();


    /**
     * Indicates whether the player suffered a defeat in the game.
     *
     * @return true if the player lost, false otherwise
     */
    boolean isDefeat();


    /**
     * Indicates whether the game ended in a draw/tie.
     *
     * @return true if the game was a draw, false otherwise
     */
    boolean isDraw();


    /**
     * Gets the total duration of the game session.
     *
     * @return the time played in seconds
     */
    long getTimePlayed();


    /**
     * Gets the player's score before the game started.
     *
     * @return the old score value
     */
    long getOldScore();


    /**
     * Gets the player's score after the game ended.
     *
     * @return the new score value
     */
    long getNewScore();


    /**
     * Gets the player's rating before the game started.
     *
     * @return the old rating value
     */
    long getOldRating();


    /**
     * Gets the player's rating after the game ended.
     *
     * @return the new rating value
     */
    long getNewRating();


    /**
     * Gets the amount that was bet on the game as a string.
     * For BetType.MONEY -> 123.5
     * For BetType.ITEMS -> STONE/16
     *
     * @return a non-null string representation of the bet amount
     */
    @NotNull
    String getBetAsString();


    /**
     * Gets the prize amount won from the game as a string.
     * For BetType.MONEY -> 123.5
     * For BetType.ITEMS -> STONE/16
     *
     * @return a non-null string representation of the prize amount
     */
    @NotNull
    String getPrizeAsString();

}
