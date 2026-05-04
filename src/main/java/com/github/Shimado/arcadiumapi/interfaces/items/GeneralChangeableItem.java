package com.github.Shimado.arcadiumapi.interfaces.items;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public interface GeneralChangeableItem {

    @Nullable
    List<Integer> getSlots();

    @NotNull
    Map<Integer, GeneralItem> getItems();

}
