package com.github.Shimado.arcadiumapi.api;

import com.github.Shimado.arcadiumapi.instances.ArcadiumGame;
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

    void placeBet(@NotNull Player player, @NotNull GameBet bet, int slot, @NotNull T gameMode, @Nullable ItemRunnable betRunnable);


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

    void placeBetToSingleplayerGameInventory(@NotNull Player player, @NotNull Inventory inv, @NotNull T gameMode, @NotNull ItemStack itemToSet, int slot);


    /**
     * Responsible for the visual display of the bet for a multiplayer mode.
     * Places the bet itself in the GUI.
     * Sets the placed game table and visual item to the session memory.
     *
     * @param player             the player placing the bet
     * @param sessionHub         the hub that contains all sessions of players who play in one session
     * @param gameSession        the session of the player who places the bet
     * @param gameMode           the game mode where the bet is placed
     * @param itemToSet          the item that will be placed in the bet slot
     * @param slot               the bet slot where the item will be installed
     * **/

    void placeBetToMultiplayerGameInventory(@NotNull Player player, @NotNull MultiplayerGameSessionsHub sessionHub, @NotNull MultiplayerGameSession gameSession, @NotNull T gameMode, @NotNull ItemStack itemToSet, int slot);


    /**
     * Refunds a bet or free spin back to the player.
     * Resets the bet data.
     *
     * @param player          the player whose bet is refunded
     * @param bet             the bet to refund
     * @param gameMode        the game itself
     */

    void refundBet(@NotNull Player player, @Nullable GameBet bet, @NotNull T gameMode);


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
     * Handles the player closing the GUI, returns their bet if the game has not yet started.
     * It counts as a loss if you lose during an active game.
     *
     * @param player         the player who closed the GUI
     * @param gameSession    the player game session
     * @param gameMode the game mode itself that was closed
     * @param runnable       necessary to complement the method. But it's generally used to remove a player from the session map.
     * **/

    void closeSingleplayerGameGUI(@NotNull Player player, @Nullable SingleplayerGameSession gameSession, @NotNull T gameMode, @Nullable Runnable runnable);


    /**
     * Sets the bid buttons, replacing all placeholders.
     *
     * @param player          for whom is the button installed and whose data will be taken
     * @param inv             the inventory where it will be installed
     * @param spotSlots       the slots in the GUI to set
     * @param gameMode  the game mode itself
     * **/

    void setSpotItems(@NotNull Player player, @NotNull Inventory inv, @NotNull List<Integer> spotSlots, @NotNull ArcadiumGame gameMode);


    /**
     * Handles mode update on /arcadium reload, returns their bet if the game has not yet started.
     *
     * @param sessions        the map with all players in this mode, where UUID - is the UUID of the player
     * @param gameMode  the game mode itself
     * **/

    void reloadSingleplayerGameGUI(@NotNull Map<UUID, SingleplayerGameSession> sessions, @NotNull T gameMode);


    /**
     * Sets the delay for recharging the mode.
     *
     * @param delay       the delay in ticks before starting a new game
     * @param player      the player who plays in this mode
     * @param gameSession the game session that requires a restart
     * @param runnable    where the method itself is implemented that restarts the mode
     * **/

    void restartSingleplayerGameWithDelay(int delay, @NotNull Player player, @NotNull SingleplayerGameSession gameSession, @NotNull Runnable runnable);


    /**
     * Sets the delay for recharging the mode.
     *
     * @param delay       the delay in ticks before starting a new game
     * @param sessionHub  the game session that contains all game sessions
     * @param runnable    where the method itself is implemented that restarts the mode
     * **/

    void restartMultiplayerGameWithDelay(int delay, @NotNull MultiplayerGameSessionsHub sessionHub, @NotNull Runnable runnable);

}
