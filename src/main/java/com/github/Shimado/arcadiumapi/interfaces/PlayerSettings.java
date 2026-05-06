package com.github.Shimado.arcadiumapi.interfaces;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.UUID;

/**
 * Player settings that are needed to simplify the gameplay.
 * So that the player does not have to constantly select music, but turns on the one he chose earlier,
 * so that the bet in the monetary format is saved, etc.
 * **/

public interface PlayerSettings {

    /**
     * Gets the player's UUID.
     *
     * @return UUID of the player
     */

    @NotNull
    UUID getPlayerUUID();



    @NotNull
    Map<String, Double> getDefaultMoneyBets();

    double getDefaultMoneyBet(@NotNull String gameName);

    PlayerSettings setDefaultMoneyBet(@NotNull String gameName, double defaultMoneyBet);


    /**
     * Gets the background song settings for the main GUI.
     *
     * @return main GUI background song settings, or {@code null} if not set
     */

    @Nullable
    BackgroundSongSettings getMainGUISong();


    /**
     * Sets the background song for the main GUI.
     *
     * @param musicID     ID of the music in the Arcadium plugin config
     * @param musicActive whether the music is active. If so, music will play when the GUI is opened.
     * @return this PlayerSettings instance for chaining
     */

    PlayerSettings setMainGUISong(@NotNull String musicID, boolean musicActive);


    /**
     * Gets the background song settings for the main GUI (for one game).
     *
     * @return main GUI background song settings, or {@code null} if not set
     */

    @Nullable
    BackgroundSongSettings getMainGUIForOneGameSong();


    /**
     * Sets the background song for the main GUI (for one game).
     *
     * @param musicID     ID of the music in the Arcadium plugin config
     * @param musicActive whether the music is active. If so, music will play when the GUI is opened.
     * @return this PlayerSettings instance for chaining
     */

    PlayerSettings setMainGUIForOneGameSong(@NotNull String musicID, boolean musicActive);


    /**
     * Gets background song settings for all game GUIs.
     *
     * @return map of game names to background song settings
     */

    @NotNull
    Map<String, BackgroundSongSettings> getGamesGUISongs();


    /**
     * Gets the background song settings for a specific game.
     *
     * @param gameName name of the game
     * @return background song settings, or {@code null} if not found
     */

    @Nullable
    BackgroundSongSettings getGameGUISong(@NotNull String gameName);


    /**
     * Sets the background song for a specific game GUI.
     *
     * @param gameName    name of the game
     * @param musicID     ID of the music in the Arcadium plugin config, which is specified in the "Music GUI songs:"
     * @param musicActive whether the music is active. If so, music will play when the GUI is opened
     * @return this PlayerSettings instance for chaining
     */

    PlayerSettings setGameGUISong(@NotNull String gameName, @NotNull String musicID, boolean musicActive);

}
