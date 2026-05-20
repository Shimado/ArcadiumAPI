package com.github.Shimado.arcadiumapi.api;

import com.github.Shimado.arcadiumapi.instances.ArcadiumGame;
import com.github.Shimado.arcadiumapi.instances.ArcadiumGamePage;
import com.github.Shimado.arcadiumapi.instances.GameBet;
import com.github.Shimado.arcadiumapi.instances.SingleplayerGameSession;
import com.github.Shimado.arcadiumapi.instances.multiplayer.MultiplayerGameSession;
import com.github.Shimado.arcadiumapi.instances.multiplayer.MultiplayerGameSessionsHub;
import com.github.Shimado.arcadiumapi.interfaces.ItemRunnable;
import com.github.Shimado.arcadiumapi.interfaces.PlacedGameTable;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * A set of optional methods to simplify the creation of a game mode.
 */

public interface GameUtil<T extends ArcadiumGame & GameMethods> {

    /**
     * Places a bet for a player in a specific game mode.
     * Checks for all restrictions: minimum/maximum bet amount, etc.
     * Processes all three bet types, as well as free spins.
     * Updates GameBet to the current bet value.
     *
     * @param player           the player placing the bet
     * @param bet              the bet object containing bet details
     * @param slot             the slot in GUI for bet
     * @param gameMode         the game mode where the bet is placed
     * @param betRunnable      action to run if the bet is made with chips/money/items. Handles further actions after a bet has been placed
     */

    void placeBet(@NotNull Player player, @NotNull GameBet bet, int slot, @NotNull T game, @Nullable ItemRunnable betsRunnable);


    /**
     * Responsible for the visual display of the bet for a singleplayer mode.
     * Places the bet itself in the GUI. Sets active levers.
     *
     * @param player          the player placing the bet
     * @param inv             the inventory in which it will be installed
     * @param gameMode        the game mode where the bet is placed
     * @param itemToSet       the item that will be placed in the bet slot
     * @param slot            the bet slot where the item will be installed
     * **/

    void placeBetToSingleplayerGameInventory(@NotNull Player player, @NotNull Inventory inv, @NotNull T game, @NotNull ArcadiumGamePage gamePage, @Nullable ItemStack itemToSet, int slot);



    /**
     * Refunds a bet or free spin back to the player.
     * Resets the bet data.
     *
     * @param player          the player whose bet is refunded
     * @param bet             the bet to refund
     * @param gameMode        the game itself
     */

    void refundBet(@NotNull Player player, @Nullable GameBet bet, @Nullable Runnable runnable);


    void removeBetFromSingleplayerGameInventory(@NotNull Player player, @NotNull Inventory inv, @NotNull T game, @NotNull ArcadiumGamePage gamePage);


    /**
     * Checks whether a business-owned table has enough funds.
     *
     * @param player         the player attempting to use the table
     * @param tableOwnerUUID the UUID of the table's owner
     * @return {@code true} if the business table has sufficient money, {@code false} otherwise
     */

    boolean checkIfBusinessTableHasMoney(@NotNull Player player, @Nullable UUID tableOwnerUUID);


    /**
     * Checks whether a business-owned table has enough funds.
     *
     * @param player               the player attempting to use the table
     * @param placedGameTable      the placed game table instance with owner's data
     * @return {@code true} if the business table has sufficient money, {@code false} otherwise
     */

    boolean checkIfBusinessTableHasMoney(@NotNull Player player, @Nullable PlacedGameTable placedGameTable);


    /**
     * Handles mode update on /arcadium reload, returns their bet if the game has not yet started.
     *
     * @param sessions        the map with all players in this mode, where UUID - is the UUID of the player
     * @param gameMode  the game mode itself
     * **/

    void reloadSingleplayerGame(@NotNull Map<UUID, SingleplayerGameSession> sessions, @NotNull T gameMode);

}
