package com.github.Shimado.arcadiumapi.interfaces;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public interface GameLog {

    @NotNull
    LocalDateTime getDateTime();


    @NotNull
    UUID getPlayerUUID();


    @NotNull
    String getPlayerName();


    @NotNull
    String getGameName();


    @NotNull
    String getBetAsString();


    boolean isVictory();


    boolean isDefeat();


    boolean isDraw();


    int getTimePlayed();


    long getScore();


    long getRating();

}
