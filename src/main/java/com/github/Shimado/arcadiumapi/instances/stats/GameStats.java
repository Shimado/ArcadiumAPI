package com.github.Shimado.arcadiumapi.instances.stats;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents statistics for a specific game mode.
 * Also displays statistics for each player in this game mode.
 * Tracks the number of games played, victories, defeats and etc
 */

public class GameStats extends ArcadiumStats {

    private String gameName;

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
     * @param timePlayed  number of timePlayed
     */

    public GameStats(@NotNull String gameName, int gamesPlayed, int victories, int defeats, int timePlayed) {
        super(gamesPlayed, victories, defeats, timePlayed);
        this.gameName = gameName;
    }


    /**
     * Gets the name of the game mode.
     *
     * @return the name of the game mode
     */

    @Nullable
    public String getGameName() {
        return gameName;
    }

}
