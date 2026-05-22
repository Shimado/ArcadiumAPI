package com.github.Shimado.arcadiumapi.api;

import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * Provides methods for interacting with the economy system.
 * <p>
 * Includes balance management operations for player and shared accounts,
 * such as checking balances, depositing, withdrawing, and accessing
 * special accounts like the town account.
 */
public interface EconomyUtil {

    /**
     * Gets the UUID of the global town/server account (player UUID).
     *
     * @return the UUID of the town account, or {@code null} if no town account is configured
     */
    @Nullable
    UUID getTownAccountUUID();


    /**
     * Sets the balance of the specified player.
     *
     * @param playerUUID the UUID of the target player
     * @param money      the new balance amount
     */
    void setBalance(@Nullable UUID playerUUID, double money);


    /**
     * Gets the current balance of the specified player.
     *
     * @param playerUUID the UUID of the target player
     * @return the current balance
     */
    double getBalance(@Nullable UUID playerUUID);


    /**
     * Checks whether the specified player has at least the provided amount of money.
     *
     * @param playerUUID the UUID of the target player
     * @param money      the amount to check
     * @return {@code true} if the player has sufficient funds, otherwise {@code false}
     */
    boolean isHaveMoney(@Nullable UUID playerUUID, double money);


    /**
     * Adds money to the specified player balance.
     *
     * @param playerUUID the UUID of the target player
     * @param money      the amount to add
     */
    void addBalance(@Nullable UUID playerUUID, double money);


    /**
     * Removes money from the specified player balance.
     *
     * @param playerUUID the UUID of the target player
     * @param money      the amount to remove
     */
    void removeBalance(@Nullable UUID playerUUID, double money);

}
