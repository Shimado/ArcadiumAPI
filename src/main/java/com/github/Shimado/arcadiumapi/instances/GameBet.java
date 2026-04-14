package com.github.Shimado.arcadiumapi.instances;

import com.github.Shimado.arcadiumapi.enums.BetType;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a game bet.
 * A bet can be placed in one of two different forms:
 *     MONEY (numeric value)
 *     ITEMS ({@link ItemStack})
 * Provides utility methods for modifying the bet, checking its type,
 * and retrieving its total value.
 */

public class GameBet {

    private int slot = -1;
    private double moneyBet = 0.0;
    private ItemStack itemsBet;


    /**
     * Gets the bet slot of the player in the game session GUI.
     *
     * @return the slot position, or -1 if no slot is assigned
     */

    public int getSlot() {
        return slot;
    }

    public GameBet setSlot(int slot) {
        this.slot = slot;
        return this;
    }


    /**
     * Gets the money bet.
     *
     * @return the money bet value
     */

    public double getMoneyBet() {
        return moneyBet;
    }

    public GameBet setMoneyBet(double moneyBet) {
        this.moneyBet = moneyBet;
        return this;
    }

    public GameBet addMoneyBet(double moneyBet) {
        this.moneyBet += moneyBet;
        return this;
    }

    public GameBet removeMoneyBet(double moneyBet) {
        this.moneyBet -= moneyBet;
        if (this.moneyBet < 0) this.moneyBet = 0;
        return this;
    }


    /**
     * Gets the items bet.
     *
     * @return the items bet, or {@code null} if none
     */

    @Nullable
    public ItemStack getItemsBet() {
        return itemsBet;
    }

    public GameBet setItemsBet(@Nullable ItemStack itemsBet) {
        this.itemsBet = itemsBet;
        return this;
    }


    /**
     * Checks if there is any bet (money or items).
     *
     * @return {@code true} if at least one type of bet is present, otherwise {@code false}
     */

    public boolean isAnyBet() {
        return moneyBet > 0 || itemsBet != null;
    }


    /**
     * Gets the bet type.
     *
     * @return the chip type, or {@code null} if none
     * **/

    @Nullable
    public BetType getChipType(){
        if(moneyBet > 0) return BetType.MONEY;
        if(itemsBet != null) return BetType.ITEMS;
        return null;
    }


    /**
     * Gets the bet price.
     *
     * @return the bet price as double
     * **/

    public double getBetPrice(@Nullable GameBet bet){
        if(bet == null) return 0.0;
        if(bet.getItemsBet() != null){
            return bet.getItemsBet().getAmount();
        }
        else{
            return bet.getMoneyBet();
        }
    }

}
