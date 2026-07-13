package com.github.Shimado.arcadiumapi.instances;

import org.jetbrains.annotations.Nullable;

public class Pair<L, R> {

    private L left;
    private R right;

    public Pair(@Nullable L left, @Nullable R right){
        this.left = left;
        this.right = right;
    }

    @Nullable
    public L getLeft(){
        return left;
    }

    public void setLeft(@Nullable L left){
        this.left = left;
    }


    @Nullable
    public R getRight(){
        return right;
    }

    public void setRight(@Nullable R right){
        this.right = right;
    }

}
