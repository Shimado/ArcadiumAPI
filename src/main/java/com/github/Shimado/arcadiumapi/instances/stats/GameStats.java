package com.github.Shimado.arcadiumapi.instances.stats;

import org.jetbrains.annotations.NotNull;

/**
 * Represents statistics for a specific game mode.
 * Also displays statistics for each player in this game mode.
 * Tracks the number of games played, victories, defeats and etc
 */

public class GameStats extends ArcadiumStats {

    private final String gameName;

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

    public GameStats(@NotNull String gameName, int gamesPlayed, int victories, int defeats, int draws, long timePlayed, long score, long rating) {
        super(gamesPlayed, victories, defeats, draws, timePlayed, score, rating);
        this.gameName = gameName;
    }

    public GameStats(@NotNull String gameName, int gamesPlayed, int victories, int defeats, int draws, long timePlayed) {
        super(gamesPlayed, victories, defeats, draws, timePlayed, 0, 0);
        this.gameName = gameName;
    }

    public GameStats(@NotNull String gameName) {
        super();
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

}
