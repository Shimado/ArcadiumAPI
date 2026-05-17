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
 * Represents a session for a game GUI (inventory-based).
 * Stores information about the current state of the session such as
 * opened inventory, associated game, table, and pagination.
 *
 * @param <T> the game mode, which must implement {@link ArcadiumGame}, {@link GameMethods}
 */

public interface ISession<T extends ArcadiumGame & GameMethods> {

    /**
     * Gets the current inventory associated with this session.
     *
     * @return the inventory
     */

    @NotNull
    Inventory getInv();

    void setInv(@NotNull Inventory inv);


    /**
     * Gets the type of the current GUI.
     *
     * @return the GUI type, or {@code null}
     */

    @Nullable
    InventoryType getInvType();

    void setInvType(@Nullable InventoryType invType);


    /**
     * Gets the type of the previous GUI.
     *
     * @return the previous GUI type, or {@code null}
     */

    @Nullable
    InventoryType getPreviousInvType();

    void setPreviousInvType(@Nullable InventoryType invType);


    /**
     * Gets the opened Music inventory associated with this session.
     *
     * @return the inventory, or {@code null} if GUI is closed
     */

    @Nullable
    Inventory getMusicInv();

    void setMusicInv(@Nullable Inventory musicInv);


    /**
     * Gets the opened Notifications inventory associated with this session.
     *
     * @return the inventory, or {@code null} if GUI is closed
     */

    @Nullable
    Inventory getNotificationsInv();

    void setNotificationsInv(@Nullable Inventory notificationsInv);


    /**
     * Gets the currently opened game instance in this session.
     *
     * @return the opened game, or {@code null} if none is active
     */

    @Nullable
    T getOpenedGame();

    void setOpenedGame(@Nullable T openedGame);


    /**
     * Gets the type of the game page.
     *
     * @return the page type, or {@code null}
     */

    @Nullable
    GamePage getGamePage();

    void setGamePage(@Nullable GamePage gamePage);


    /**
     * Checks whether the session is currently changing pages.
     *
     * @return {@code true} if a page change is in progress, otherwise {@code false}
     */

    boolean isChangingPage();

    void setChangingPage(boolean changingPage);


    /**
     * Gets the name of the game mode associated with this session's table.
     * Can be "ALL"
     *
     * @return the table game identifier
     */

    @NotNull
    String getTableGame();

    void setTableGame(@NotNull String tableGame);


    /**
     * Gets the placed table the player is playing.
     *
     * @return the placed table, or {@code null} if opened by a command.
     */

    @Nullable
    PlacedGameTable getGameTable();

    void setGameTable(@Nullable PlacedGameTable placedGameTable);


    /**
     * Gets the current page index.
     *
     * @return the page number
     */

    int getPage();

    void setPage(int page);


    /**
     * Advances to the next page and returns the new index.
     *
     * @param maxPage - maximum page size
     *
     * @return the next page number or -1 if it > maxPage
     */

    int nextPage(int maxPage);


    /**
     * Goes back to the previous page and returns the new index.
     *
     * @return the previous page number or -1 if it less than 0
     */

    int previousPage();


    /**
     * Gets the background song settings of the current GUI.
     *
     * @return the background song settings, or {@code null}
     */

    @Nullable
    BackgroundSongSettings getBackgroundSong();

    void setBackgroundSong(@Nullable BackgroundSongSettings backgroundSong);


    /**
     * Closes the GUI for the given player.
     * Closes the GUI and does not return to the previous one.
     *
     * @param player the player whose inventory should be closed
     */

    void closeInventoryWithoutReturn(@NotNull Player player);

}

