package com.github.Shimado.arcadiumapi.instances.stats;

import org.jetbrains.annotations.NotNull;

/**
 * Represents statistics associated with a specific game mode.
 * <p>
 * Stores overall game-related statistics such as games played,
 * victories, defeats, draws, playtime, score, and rating data.
 * <p>
 * This class may also be used for displaying player statistics
 * within a particular game mode.
 */
public class GameStats extends ArcadiumStats {

    private final String gameID;
    private final String gameName;

    /**
     * Creates a fully initialized game statistics object.
     *
     * @param gameID       the unique ID of the game mode
     * @param gameName     the display name of the game mode
     * @param gamesPlayed  total number of games played
     * @param victories    total number of victories
     * @param defeats      total number of defeats
     * @param draws        total number of draws
     * @param timePlayed   total playtime
     * @param score        total or highest score value
     * @param rating       rating value
     */
    public GameStats(@NotNull String gameID, @NotNull String gameName, int gamesPlayed, int victories, int defeats, int draws, long timePlayed, long score, long rating) {
        super(gamesPlayed, victories, defeats, draws, timePlayed, score, rating);
        this.gameID = gameID;
        this.gameName = gameName;
    }

    /**
     * Creates a game statistics object without score and rating data.
     *
     * @param gameID       the unique ID of the game mode
     * @param gameName     the display name of the game mode
     * @param gamesPlayed  total number of games played
     * @param victories    total number of victories
     * @param defeats      total number of defeats
     * @param draws        total number of draws
     * @param timePlayed   total playtime
     */
    public GameStats(@NotNull String gameID, @NotNull String gameName, int gamesPlayed, int victories, int defeats, int draws, long timePlayed) {
        super(gamesPlayed, victories, defeats, draws, timePlayed, 0, 0);
        this.gameID = gameID;
        this.gameName = gameName;
    }

    /**
     * Creates an empty game statistics object.
     *
     * @param gameID    the unique ID of the game mode
     * @param gameName  the display name of the game mode
     */
    public GameStats(@NotNull String gameID, @NotNull String gameName) {
        super();
        this.gameID = gameID;
        this.gameName = gameName;
    }


    /**
     * Gets the unique ID of the game mode.
     *
     * @return the game mode ID
     */
    @NotNull
    public String getGameID() {
        return gameID;
    }


    /**
     * Gets the display name of the game mode.
     *
     * @return the game mode name
     */
    @NotNull
    public String getGameName() {
        return gameName;
    }

}
