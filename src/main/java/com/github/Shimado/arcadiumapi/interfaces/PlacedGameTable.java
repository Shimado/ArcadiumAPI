package com.github.Shimado.arcadiumapi.interfaces;

import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * Represents a game table placed in the world.
 * <p>
 * Stores information about the table instance,
 * including its unique identifier, location,
 * rotation, associated game mode, and owner data.
 */
public interface PlacedGameTable {

    /**
     * Gets the unique identifier of this placed table.
     *
     * @return the table UUID
     */
    @NotNull
    UUID getUUID();


    /**
     * Gets the unique ID of the {@link GameTableItem}
     * used to create this table.
     *
     * @return the table item ID
     */
    @NotNull
    String getGameTableItemID();


    /**
     * Gets the {@link GameTableItem} definition
     * associated with this placed table.
     *
     * @return the table item definition
     */
    @NotNull
    GameTableItem getGameTableItem();


    /**
     * Gets the name of the game mode linked to this table.
     * <p>
     * May return {@code "ALL"} if the table supports
     * multiple game modes.
     *
     * @return the associated game mode name
     */
    @NotNull
    String getGameName();


    /**
     * Sets the game mode associated with this table.
     * <p>
     * The value may be {@code "ALL"} to indicate
     * support for multiple game modes.
     *
     * @param gameName the new game mode name
     * @return this table instance for chaining
     */
    PlacedGameTable setGameName(@Nullable String gameName);


    /**
     * Gets the world location of this table.
     *
     * @return the table location
     */
    @NotNull
    Location getLoc();


    /**
     * Gets the yaw rotation of this table.
     * <p>
     * Mainly used for rendering and developer tools.
     *
     * @return the yaw rotation value
     */
    float getYaw();


    /**
     * Gets the UUID of the player who owns this table.
     *
     * @return the owner UUID, or {@code null} if the table has no owner
     */
    @Nullable
    UUID getOwner();

}

