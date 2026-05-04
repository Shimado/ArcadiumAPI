package com.github.Shimado.arcadiumapi.interfaces.items;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface GeneralItem {

    @NotNull
    List<Integer> getSlots();

    @Nullable
    Object getMaterial();

    @Nullable
    String getTitle();

    @NotNull
    List<String> getLore();

    int getCustomModelData();

    @Nullable
    ItemStack getItem();

}
