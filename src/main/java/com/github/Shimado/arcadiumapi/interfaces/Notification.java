package com.github.Shimado.arcadiumapi.interfaces;

import com.github.Shimado.arcadiumapi.instances.GameBet;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public interface Notification {

    @NotNull
    UUID getUUID();

    @NotNull
    Player getSender();

    @NotNull
    Player getRecipient();

    @NotNull
    String getGameName();

    @NotNull
    ItemStack getItem();

    @Nullable
    GameBet getSenderBet();

}
