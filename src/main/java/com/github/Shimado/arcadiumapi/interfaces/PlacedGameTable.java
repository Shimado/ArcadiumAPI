package com.github.Shimado.arcadiumapi.interfaces;

import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * Represents a placed table in the world.
 * Stores metadata about its identity, location, orientation,
 * associated game, and owner.
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
     * Gets the ID of the {@link GameTableItem} that defines this table.
     *
     * @return the table item ID
     */

    @NotNull
    String getGameTableItemID();

    /**
     * Gets the {@link GameTableItem} definition linked to this placed table.
     *
     * @return the table item definition
     */

    @NotNull
    GameTableItem getGameTableItem();

    /**
     * Gets the game mode name associated with this table.
     * Can be "ALL".
     *
     * @return the game mode name
     */

    @NotNull
    String getGame();

    /**
     * Sets the game mode name associated with this table.
     * Can be "ALL".
     *
     * @param game the game mode name
     * @return this instance for chaining
     */

    PlacedGameTable setGame(@Nullable String game);

    /**
     * Gets the location of this table in the world.
     *
     * @return this table location
     */

    @NotNull
    Location getLoc();

    /**
     * Gets the yaw (rotation) of this table.
     * Needs for the developers pack.
     *
     * @return the yaw angle
     */

    float getYaw();

    /**
     * Gets the UUID of the player who owns this table.
     *
     * @return the owner's UUID, or {@code null} if not set
     */

    @Nullable
    UUID getOwner();

}

