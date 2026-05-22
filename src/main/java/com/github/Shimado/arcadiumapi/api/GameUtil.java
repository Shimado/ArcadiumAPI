package com.github.Shimado.arcadiumapi.api;

import com.github.Shimado.arcadiumapi.instances.ArcadiumGame;
import com.github.Shimado.arcadiumapi.instances.ArcadiumGamePage;
import com.github.Shimado.arcadiumapi.instances.GameBet;
import com.github.Shimado.arcadiumapi.instances.singleplayer.SingleplayerGameSession;
import com.github.Shimado.arcadiumapi.interfaces.ItemRunnable;
import com.github.Shimado.arcadiumapi.interfaces.PlacedGameTable;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.UUID;

/**
 * Utility interface that provides helper methods for managing game modes,
 * bets, and related GUI interactions.
 */
public interface GameUtil<T extends ArcadiumGame & GameMethods> {

    /**
     * Places a bet for a player in the specified game mode.
     * <p>
     * Validates all betting restrictions such as minimum/maximum bet limits,
     * processes supported bet types and free spins, and updates the current {@link GameBet}.
     *
     * @param player         the player placing the bet
     * @param bet            the bet data
     * @param slot           the GUI slot associated with the bet
     * @param game           the target game instance
     * @param betsRunnable   action executed after a successful bet placement
     */
    void placeBet(@NotNull Player player, @NotNull GameBet bet, int slot, @NotNull T game, @Nullable ItemRunnable betsRunnable);


    /**
     * Updates the GUI representation of a bet in a singleplayer game.
     * <p>
     * Places the bet item into the inventory and updates related interactive elements,
     * such as active levers.
     *
     * @param player      the player viewing the inventory
     * @param inv         the inventory to update
     * @param game        the target game instance
     * @param gamePage    the current game page
     * @param itemToSet   the item to place into the bet slot, or {@code null} to clear it
     * @param slot        the inventory slot used for the bet
     */
    void placeBetToSingleplayerGameInventory(@NotNull Player player, @NotNull Inventory inv, @NotNull T game, @NotNull ArcadiumGamePage gamePage, @Nullable ItemStack itemToSet, int slot);


    /**
     * Refunds a previously placed bet or free spin to the player.
     *
     * @param player     the player receiving the refund
     * @param bet        the bet being refunded
     * @param runnable   optional action executed after the refund
     */
    void refundBet(@NotNull Player player, @Nullable GameBet bet, @Nullable Runnable runnable);


    /**
     * Removes the bet display and related controls from a singleplayer game inventory.
     *
     * @param player      the player viewing the inventory
     * @param inv         the inventory to update
     * @param game        the target game instance
     * @param gamePage    the current game page
     */
    void removeBetFromSingleplayerGameInventory(@NotNull Player player, @NotNull Inventory inv, @NotNull T game, @NotNull ArcadiumGamePage gamePage);


    /**
     * Checks whether a business-owned table has enough funds to continue operating.
     *
     * @param player           the player attempting to use the table
     * @param tableOwnerUUID   the UUID of the table owner
     * @return {@code true} if the table has sufficient funds, otherwise {@code false}
     */
    boolean checkIfBusinessTableHasMoney(@NotNull Player player, @Nullable UUID tableOwnerUUID);


    /**
     * Checks whether a business-owned table has enough funds to continue operating.
     *
     * @param player           the player attempting to use the table
     * @param placedGameTable  the placed table instance containing ownership data
     * @return {@code true} if the table has sufficient funds, otherwise {@code false}
     */
    boolean checkIfBusinessTableHasMoney(@NotNull Player player, @Nullable PlacedGameTable placedGameTable);


    /**
     * Reloads all active singleplayer game sessions.
     * <p>
     * Intended to be used during plugin reload operations.
     *
     * @param sessions   map of active sessions where the key is the player's UUID
     * @param runnable   optional action executed after reload handling
     */
    void reloadSingleplayerGame(@NotNull Map<UUID, SingleplayerGameSession> sessions, @Nullable Runnable runnable);

}
