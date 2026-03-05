package com.github.Shimado.arcadiumapi.interfaces;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

@FunctionalInterface
public interface ItemRunnable {

    void run(@Nullable ItemStack item);

}
