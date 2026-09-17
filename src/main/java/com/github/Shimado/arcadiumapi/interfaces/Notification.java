package com.github.Shimado.arcadiumapi.interfaces;

import com.github.Shimado.arcadiumapi.instances.GameBet;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * Represents a game notification sent from one player to another,
 * optionally carrying a bet and an item associated with it.
 */
public interface Notification {

    /**
     * Returns the unique identifier of this notification.
     *
     * @return the notification's UUID
     */
    @NotNull
    UUID getUUID();

    /**
     * Returns the UUID of the player who sent this notification.
     *
     * @return the UUID of the sender of the notification
     */
    @NotNull
    UUID getSenderUUID();

    /**
     * Returns the UUID of the player who received this notification.
     *
     * @return the UUID of the recipient of the notification
     */
    @NotNull
    UUID getRecipientUUID();

    /**
     * Returns the ID of the game this notification is related to.
     *
     * @return the game ID
     */
    @NotNull
    String getGameID();

    /**
     * Returns the bet placed by the sender, if any.
     *
     * @return the sender's bet, or {@code null} if no bet was placed
     */
    @Nullable
    GameBet getSenderBet();

    /**
     * Returns the time at which the notification was sent.
     *
     * @return notification sending time
     */
    long getCreatedAt();

    /**
     * Returns the instance of the lifecycle responsible for this
     * notification's lifetime, after which the notification becomes
     * inactive. (CycleTask from BasicUtils library)
     *
     * @return the lifecycle instance bound to this notification, or
     * {@code null} if none is set
     */
    @Nullable
    Object getLifeTimeCycleID();

    /**
     * Sets the instance of the lifecycle responsible for this
     * notification's lifetime, after which the notification becomes
     * inactive. (CycleTask from BasicUtils library)
     *
     * @param lifeTimeCycleID the lifecycle instance to bind to this
     *                        notification, or {@code null} to clear it
     */
    void setLifeTimeCycleID(@Nullable Object lifeTimeCycleID);

}
