package com.github.Shimado.arcadiumapi.interfaces;

import com.github.Shimado.arcadiumapi.enums.GamePage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents background song status (active state and music ID).
 */
public interface BackgroundSongSettings {

    /**
     * Gets the game page type.
     *
     * @return the game page name
     * **/
    @Nullable
    GamePage getGamePage();


    /**
     * Gets the music identifier.
     * ID of the music in the Arcadium plugin config
     *
     * @return music ID
     */
    @NotNull
    String getMusicID();


    /**
     * Checks if music is active. If so, music will play when the GUI is opened.
     *
     * @return {@code true} if music is active, {@code false} otherwise
     */
    boolean isMusicActive();


    /**
     * Sets whether the music is active. If so, music will play when the GUI is opened.
     *
     * @param musicActive true if active, false otherwise
     */
    void setMusicActive(boolean musicActive);

}
