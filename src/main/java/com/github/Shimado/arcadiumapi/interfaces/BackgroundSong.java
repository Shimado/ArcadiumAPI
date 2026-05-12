package com.github.Shimado.arcadiumapi.interfaces;

import com.github.Shimado.boomboxapi.instances.BoomboxSong;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface BackgroundSong {

    int getPage();

    @NotNull
    List<Integer> getSlots();

    @NotNull
    BoomboxSong getBoomboxSong();

    @Nullable
    ItemStack getIconInactive();

    @Nullable
    ItemStack getIconActive();

}
