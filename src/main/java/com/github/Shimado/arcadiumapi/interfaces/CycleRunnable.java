package com.github.Shimado.arcadiumapi.interfaces;

import org.jetbrains.annotations.Nullable;

@FunctionalInterface
public interface CycleRunnable {

    void run(@Nullable Object cycle);

}
