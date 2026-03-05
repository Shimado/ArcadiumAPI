package com.github.Shimado.arcadiumapi.interfaces;

import org.jetbrains.annotations.NotNull;

/**
 * Represents background song status (active state and music ID).
 */

public interface BackgroundSongSettings {

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

    /**
     * Gets the music identifier.
     * ID of the music in the Arcadium plugin config, which is specified in the "Music GUI songs:"
     *
     * @return music ID
     */

    @NotNull
    String getMusicID();

    /**
     * Converts the format to musicID/musicActive: song/1 or song/0
     *
     * @return formatted text
     * **/

    String toString();

}
