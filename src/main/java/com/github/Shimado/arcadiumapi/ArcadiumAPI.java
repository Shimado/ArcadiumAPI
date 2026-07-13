package com.github.Shimado.arcadiumapi;

import com.github.Shimado.arcadiumapi.api.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ArcadiumAPI {

    private static GameRegister gameRegister;
    private static DataStorage dataStorage;
    private static EconomyUtil economyUtil;
    private static NotificationsHandler notificationsHandler;
    private static VictoryUtil victoryUtil;
    private static GameUtil gameUtil;
    private static InvSession invSession;


    @NotNull
    public static GameRegister getGameRegister(){
        return gameRegister;
    }

    public static GameRegister setGameRegister(@NotNull GameRegister c){
        gameRegister = c;
        return c;
    }


    @NotNull
    public static DataStorage getDataStorage(){
        return dataStorage;
    }

    public static DataStorage setDataStorage(@NotNull DataStorage d){
        dataStorage = d;
        return d;
    }


    @NotNull
    public static EconomyUtil getEconomyUtil(){
        return economyUtil;
    }

    public static EconomyUtil setEconomyUtil(@NotNull EconomyUtil e){
        economyUtil = e;
        return e;
    }


    @NotNull
    public static NotificationsHandler getNotificationsHandler(){
        return notificationsHandler;
    }

    public static NotificationsHandler setNotificationsHandler(@NotNull NotificationsHandler e){
        notificationsHandler = e;
        return e;
    }


    @NotNull
    public static VictoryUtil getVictoryUtil(){
        return victoryUtil;
    }

    public static VictoryUtil setVictoryUtil(@NotNull VictoryUtil v){
        victoryUtil = v;
        return v;
    }


    @NotNull
    public static GameUtil getGameUtil(){
        return gameUtil;
    }

    public static GameUtil setGameUtil(@NotNull GameUtil c){
        gameUtil = c;
        return c;
    }


    @NotNull
    public static InvSession getInvSession(){
        return invSession;
    }

    public static InvSession setInvSession(@NotNull InvSession i){
        invSession = i;
        return i;
    }

}
