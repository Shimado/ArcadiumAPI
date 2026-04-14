package com.github.Shimado.arcadiumapi.api;

import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * API for handling economy operations.
 * Provides methods to check balances, modify them, and access special accounts
 * such as the town account.
 */

public interface EconomyUtil {

    /**
     * Sets the UUID of the town (server-wide) account.
     *
     * @param townAccount The player's UUID or name, which will act as the account
     */

    void setupTownAccountUUID(@Nullable String townAccount);


    /**
     * Gets the UUID of the town (server-wide) account, if it exists.
     *
     * @return the UUID of the town account, or {@code null} if not defined
     */

    @Nullable
    UUID getTownAccountUUID();


    /**
     * Sets the balance of a specific player.
     *
     * @param playerUUID the unique identifier of the player
     * @param money      the amount of money to set
     */

    void setBalance(@Nullable UUID playerUUID, double money);


    /**
     * Gets the balance of a specific player.
     *
     * @param playerUUID the unique identifier of the player
     * @return the balance as a double
     */

    double getBalance(@Nullable UUID playerUUID);


    /**
     * Checks if a player has at least the specified amount of money.
     *
     * @param playerUUID the unique identifier of the player
     * @param money      the amount of money to check
     * @return {@code true} if the player has enough money, {@code false} otherwise
     */

    boolean isHaveMoney(@Nullable UUID playerUUID, double money);


    /**
     * Adds money to a player's balance.
     *
     * @param playerUUID the unique identifier of the player
     * @param money      the amount to add
     */

    void addBalance(@Nullable UUID playerUUID, double money);


    /**
     * Removes money from a player's balance.
     *
     * @param playerUUID the unique identifier of the player
     * @param money      the amount to remove
     */

    void removeBalance(@Nullable UUID playerUUID, double money);

}
