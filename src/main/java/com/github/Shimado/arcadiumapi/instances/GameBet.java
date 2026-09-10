package com.github.Shimado.arcadiumapi.instances;

import com.github.Shimado.arcadiumapi.enums.BetType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * Represents a player bet used within the game system.
 * <p>
 * A bet can exist in one of three forms:
 * <ul>
 *     <li>{@link BetType#NONE} - no active bet</li>
 *     <li>{@link BetType#MONEY} - a money-based bet</li>
 *     <li>{@link BetType#ITEMS} - an item-based bet</li>
 * </ul>
 * <p>
 * Provides utility methods for modifying bet values,
 * determining the active bet type, and retrieving
 * the total bet value.
 */
public class GameBet {

    private final UUID playerUUID;
    private int slot = -1;
    private double moneyBet = 0.0;
    private ItemStack itemsBet;


    /**
     * Creates a money-based bet with an assigned GUI slot.
     *
     * @param playerUUID the UUID of the player who owns the bet
     * @param slot       the GUI slot associated with the bet
     * @param moneyBet   the money amount placed as a bet
     */
    public GameBet(@NotNull UUID playerUUID, int slot, double moneyBet){
        this.playerUUID = playerUUID;
        this.slot = slot;
        this.moneyBet = moneyBet;
    }

    /**
     * Creates a money-based bet without an assigned GUI slot.
     *
     * @param playerUUID the UUID of the player who owns the bet
     * @param moneyBet   the money amount placed as a bet
     */
    public GameBet(@NotNull UUID playerUUID, double moneyBet){
        this.playerUUID = playerUUID;
        this.moneyBet = moneyBet;
    }


    /**
     * Creates an item-based bet with an assigned GUI slot.
     *
     * @param playerUUID the UUID of the player who owns the bet
     * @param slot       the GUI slot associated with the bet
     * @param itemsBet   the item stack placed as a bet
     */
    public GameBet(@NotNull UUID playerUUID, int slot, ItemStack itemsBet){
        this.playerUUID = playerUUID;
        this.slot = slot;
        this.itemsBet = itemsBet;
    }

    /**
     * Creates an item-based bet without an assigned GUI slot.
     *
     * @param playerUUID the UUID of the player who owns the bet
     * @param itemsBet   the item stack placed as a bet
     */
    public GameBet(@NotNull UUID playerUUID, ItemStack itemsBet){
        this.playerUUID = playerUUID;
        this.itemsBet = itemsBet;
    }


    /**
     * Creates an empty bet for the specified player.
     *
     * @param playerUUID the UUID of the player who owns the bet
     */
    public GameBet(@NotNull UUID playerUUID){
        this.playerUUID = playerUUID;
    }


    /**
     * Gets the UUID of the owner of this bet.
     *
     * @return the UUID of the player who owns the bet
     */
    public UUID getPlayerUUID() {
        return playerUUID;
    }


    /**
     * Gets the GUI slot associated with this bet.
     *
     * @return the assigned slot, or {@code -1} if no slot is assigned
     */
    public int getSlot() {
        return slot;
    }

    /**
     * Sets the GUI slot associated with this bet.
     *
     * @param slot the GUI slot to assign
     */
    public void setSlot(int slot) {
        this.slot = slot;
    }


    /**
     * Gets the money-based bet amount.
     *
     * @return the current money bet value
     */
    public double getMoneyBet() {
        return moneyBet;
    }

    /**
     * Sets the money-based bet amount.
     *
     * @param moneyBet the new money bet value
     */
    public void setMoneyBet(double moneyBet) {
        this.moneyBet = moneyBet;
    }

    /**
     * Adds the given amount to the current money bet.
     *
     * @param moneyBet the amount to add
     */
    public void addMoneyBet(double moneyBet) {
        this.moneyBet += moneyBet;
    }

    /**
     * Subtracts the given amount from the current money bet.
     * <p>
     * If the resulting value would be negative, it is clamped to {@code 0}.
     *
     * @param moneyBet the amount to subtract
     */
    public void removeMoneyBet(double moneyBet) {
        this.moneyBet -= moneyBet;
        if (this.moneyBet < 0) this.moneyBet = 0;
    }


    /**
     * Gets the item-based bet.
     *
     * @return the item stack used as a bet, or {@code null} if no item bet exists
     */
    @Nullable
    public ItemStack getItemsBet() {
        return itemsBet;
    }

    /**
     * Sets the item-based bet.
     *
     * @param itemsBet the item stack to use as a bet, or {@code null} to clear it
     */
    public void setItemsBet(@Nullable ItemStack itemsBet) {
        this.itemsBet = itemsBet;
    }


    /**
     * Checks whether this bet contains
     * either a money bet or an item bet.
     *
     * @return {@code true} if at least one bet type is active, otherwise {@code false}
     */
    public boolean isAnyBet() {
        return moneyBet > 0 || itemsBet != null;
    }


    /**
     * Gets the current type of this bet.
     *
     * @return the active {@link BetType}, or {@link BetType#NONE} if no bet exists
     */
    @NotNull
    public BetType getBetType(){
        if(moneyBet > 0) return BetType.MONEY;
        if(itemsBet != null) return BetType.ITEMS;
        return BetType.NONE;
    }


    /**
     * Gets the total value of this bet.
     * <p>
     * For item bets, the returned value equals the item stack amount.
     * For money bets, the returned value equals the money amount.
     *
     * @return the calculated bet value
     */
    public double getBetPrice(){
        if(getItemsBet() != null){
            return getItemsBet().getAmount();
        }
        else{
            return Math.max(0.0, getMoneyBet());
        }
    }

}
