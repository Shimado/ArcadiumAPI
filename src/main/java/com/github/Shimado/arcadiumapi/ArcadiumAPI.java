package com.github.Shimado.arcadiumapi;

import com.github.Shimado.arcadiumapi.api.*;
import org.jetbrains.annotations.Nullable;

public class ArcadiumAPI {

    private static GameRegister gameRegister;
    private static DataStorage dataStorage;
    private static EconomyUtil economyUtil;
    private static VictoryUtil victoryUtil;
    private static GameUtil gameUtil;
    private static InvSession invSession;


    @Nullable
    public static GameRegister getGameRegister(){
        return gameRegister;
    }

    public static GameRegister setGameRegister(@Nullable GameRegister c){
        gameRegister = c;
        return c;
    }


    @Nullable
    public static DataStorage getDataStorage(){
        return dataStorage;
    }

    public static DataStorage setDataStorage(@Nullable DataStorage d){
        dataStorage = d;
        return d;
    }


    @Nullable
    public static EconomyUtil getEconomyUtil(){
        return economyUtil;
    }

    public static EconomyUtil setEconomyUtil(@Nullable EconomyUtil e){
        economyUtil = e;
        return e;
    }


    @Nullable
    public static VictoryUtil getVictoryUtil(){
        return victoryUtil;
    }

    public static VictoryUtil setVictoryUtil(@Nullable VictoryUtil v){
        victoryUtil = v;
        return v;
    }


    @Nullable
    public static GameUtil getGameUtil(){
        return gameUtil;
    }

    public static GameUtil setGameUtil(@Nullable GameUtil c){
        gameUtil = c;
        return c;
    }


    @Nullable
    public static InvSession getInvSession(){
        return invSession;
    }

    public static InvSession setInvSession(@Nullable InvSession i){
        invSession = i;
        return i;
    }

}
