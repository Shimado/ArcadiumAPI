package com.github.Shimado.arcadiumapi.instances.multiplayer;

import com.github.Shimado.arcadiumapi.instances.GameBet;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a multiplayer game session in a multiplayer hub.
 * This class manages the state of a player's participation in a table game,
 * including their inventory, bets, and table information.
 */

public class MultiplayerGameSession {

    private Inventory inv;
    private GameBet bet;
    private ItemStack visualBetItem;
    private ItemStack visualHeadItem;


    /**
     * Gets the inventory associated with this game session.
     *
     * @return the inventory, or null if no inventory is set
     */

    @Nullable
    public Inventory getInv() {
        return inv;
    }

    public void setInv(@Nullable Inventory inv) {
        this.inv = inv;
    }


    /**
     * Gets the current game bet of the player placed in this session.
     *
     * @return the game bet, or null if no bet is placed
     */

    @Nullable
    public GameBet getBet() {
        return bet;
    }

    public void setBet(@Nullable GameBet bet) {
        this.bet = bet;
    }


    /**
     * Gets the visual representation of the bet item.
     * This is typically an ItemStack that visually represents the bet in the GUI.
     *
     * @return the visual bet item, or null if not set
     */

    @Nullable
    public ItemStack getVisualBetItem() {
        return visualBetItem;
    }

    public void setVisualBetItem(@Nullable ItemStack visualBetItem) {
        this.visualBetItem = visualBetItem;
    }


    /**
     * Gets the visual representation of the head item (Optional).
     * This is typically an ItemStack that visually represents the player's head in the GUI.
     *
     * @return the visual head item, or null if not set
     */

    @Nullable
    public ItemStack getVisualHeadItem() {
        return visualHeadItem;
    }

    public void setVisualHeadItem(@Nullable ItemStack visualHeadItem) {
        this.visualHeadItem = visualHeadItem;
    }

}
