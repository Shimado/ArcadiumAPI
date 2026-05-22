package com.github.Shimado.arcadiumapi.instances.multiplayer;

import com.github.Shimado.arcadiumapi.instances.GameBet;
import com.github.Shimado.arcadiumapi.interfaces.ISession;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a multiplayer game session in a multiplayer hub.
 * This class manages the state of a player's participation in a table game,
 * including their inventory, bets, and table information.
 */

public class MultiplayerGameSession {

    private ISession session;
    private GameBet bet;


    /**
     * Gets the inventory associated with this game session.
     *
     * @return the inventory, or null if no inventory is set
     */

    @Nullable
    public Inventory getInv() {
        return null;
    }

    public void setInv(@Nullable Inventory inv) {

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


}
