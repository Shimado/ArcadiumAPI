package com.github.Shimado.arcadiumapi.instances.stats;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents statistics for a specific game mode.
 * Also displays statistics for each player in this game mode.
 * Tracks the number of games played, victories, defeats and etc
 */

public class GameStats extends ArcadiumStats {

    private final String gameName;
    private long score = 0;
    private long rating = 0;

    /**
     * Creates a new statistics object for a specific game.
     *
     * @param gameName name of the game mode
     */

    public GameStats(@NotNull String gameName) {
        super();
        this.gameName = gameName;
    }

    /**
     * Creates a new statistics object with full values.
     *
     * @param gameName    name of the game mode
     * @param gamesPlayed number of games played
     * @param victories   number of victories
     * @param defeats     number of defeats
     * @param draws       number of draws
     * @param timePlayed  number of timePlayed
     * @param score       game score
     * @param rating      player rating
     */

    public GameStats(@NotNull String gameName, int gamesPlayed, int victories, int defeats, int draws, int timePlayed, long score, long rating) {
        super(gamesPlayed, victories, defeats, draws, timePlayed);
        this.gameName = gameName;
        this.score = score;
        this.rating = rating;
    }


    public GameStats(@NotNull String gameName, int gamesPlayed, int victories, int defeats, int draws, int timePlayed) {
        super(gamesPlayed, victories, defeats, draws, timePlayed);
        this.gameName = gameName;
    }


    /**
     * Gets the name of the game mode.
     *
     * @return the name of the game mode
     */

    @NotNull
    public String getGameName() {
        return gameName;
    }



    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public void addScore(int score) {
        this.score += score;
    }


    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public void addRating(int rating) {
        this.rating += rating;
    }


}
