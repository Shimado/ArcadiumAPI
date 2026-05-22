package com.github.Shimado.arcadiumapi.interfaces;

import com.github.Shimado.arcadiumapi.api.GameMethods;
import com.github.Shimado.arcadiumapi.enums.GamePage;
import com.github.Shimado.arcadiumapi.enums.InventoryType;
import com.github.Shimado.arcadiumapi.instances.ArcadiumGame;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents an inventory-based game session.
 * <p>
 * Stores information about the currently opened GUI,
 * active game mode, linked table, pagination state,
 * background music settings, and additional session data.
 *
 * @param <T> the game mode type
 */
public interface ISession<T extends ArcadiumGame & GameMethods> {

    /**
     * Gets the currently opened inventory.
     * Except Music and Notifications GUI.
     *
     * @return the active inventory
     */
    @NotNull
    Inventory getInv();

    void setInv(@NotNull Inventory inv);


    /**
     * Gets the type of the currently opened GUI.
     *
     * @return the current inventory type, or {@code null} if not defined
     */
    @Nullable
    InventoryType getInvType();

    void setInvType(@Nullable InventoryType invType);


    /**
     * Gets the type of the previously opened GUI.
     *
     * @return the previous inventory type, or {@code null} if not defined
     */
    @Nullable
    InventoryType getPreviousInvType();

    void setPreviousInvType(@Nullable InventoryType invType);


    /**
     * Gets the currently opened music inventory.
     *
     * @return the music inventory, or {@code null} if not opened
     */
    @Nullable
    Inventory getMusicInv();

    void setMusicInv(@Nullable Inventory musicInv);


    /**
     * Gets the currently opened notifications inventory.
     *
     * @return the notifications inventory, or {@code null} if not opened
     */
    @Nullable
    Inventory getNotificationsInv();

    void setNotificationsInv(@Nullable Inventory notificationsInv);


    /**
     * Gets the currently opened game mode instance.
     *
     * @return the opened game, or {@code null} if no game is active
     */
    @Nullable
    T getOpenedGame();

    void setOpenedGame(@Nullable T openedGame);


    /**
     * Gets the currently opened game page type.
     *
     * @return the game page type, or {@code null} if not defined
     */
    @Nullable
    GamePage getGamePage();

    void setGamePage(@Nullable GamePage gamePage);


    /**
     * Checks whether the session is currently switching pages.
     *
     * @return {@code true} if a page transition is active, otherwise {@code false}
     */
    boolean isChangingPage();

    void setChangingPage(boolean changingPage);


    /**
     * Gets the game mode name associated with the linked table.
     * <p>
     * May return {@code "ALL"} if the table supports
     * multiple game modes.
     *
     * @return the associated table game name
     */
    @NotNull
    String getTableGame();

    void setTableGame(@NotNull String tableGame);


    /**
     * Gets the placed game table associated with this session.
     *
     * @return the placed table, or {@code null} if the GUI was opened without a table
     */
    @Nullable
    PlacedGameTable getGameTable();

    void setGameTable(@Nullable PlacedGameTable placedGameTable);


    /**
     * Gets the current page (not index).
     *
     * @return the current page number
     */
    int getPage();

    void setPage(int page);

    int nextPage(int maxPage);

    int previousPage();


    /**
     * Gets the current background music.
     *
     * @return the background song, or {@code null} if not configured
     */
    @Nullable
    BackgroundSongSettings getBackgroundSong();

    void setBackgroundSong(@Nullable BackgroundSongSettings backgroundSong);


    /**
     * Gets the current clicked notification.
     * It is necessary in order to process the connection to the session of the player who sent it.
     *
     * @return the notification, or {@code null} if not set
     */

    @Nullable
    Notification getNotification();

    void setNotification(@Nullable Notification notification);


    /**
     * Closes the inventory for the specified player
     * without returning to the previous GUI.
     *
     * @param player the target player
     */
    void closeInventoryWithoutReturn(@NotNull Player player);

}

