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


    boolean isVictory();


    boolean isDefeat();


    boolean isDraw();


    long getTimePlayed();


    long getOldScore();


    long getNewScore();


    long getOldRating();


    long getNewRating();


    @NotNull
    String getBetAsString();


    @NotNull
    String getPrizeAsString();

}
