package com.github.Shimado.arcadiumapi.api;

import com.github.Shimado.arcadiumapi.instances.GameBet;
import com.github.Shimado.arcadiumapi.interfaces.Notification;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Deque;
import java.util.Map;
import java.util.UUID;

/**
 * Handler responsible for managing game notifications.
 * <p>
 * Provides functionality for creating, storing, retrieving, and processing
 * {@link Notification} instances exchanged between players as part of
 * game invitations (e.g. invitations to a game with a bet).
 */
public interface NotificationsHandler {

    /**
     * Returns all notifications grouped by recipient UUID.
     *
     * @return a map where the key is the recipient's UUID and the value
     * is a deque of their notifications; an empty map if there are none
     */
    @NotNull
    Map<UUID, Deque<@NotNull Notification>> getNotifications();


    /**
     * Returns a notification by its unique identifier.
     *
     * @param notificationUUID the UUID of the notification to find
     * @return the found notification, or {@code null} if no notification
     * with the given UUID exists
     */
    @Nullable
    Notification getNotificationByUUID(@NotNull UUID notificationUUID);


    /**
     * Returns all notifications addressed to the specified recipient.
     *
     * @param recipientUUID the UUID of the recipient
     * @return a deque of the recipient's notifications; an empty deque
     * if there are none
     */
    @NotNull
    Deque<@NotNull Notification> getRecipientNotifications(@NotNull UUID recipientUUID);


    /**
     * Returns the notifications of the specified recipient related
     * to a specific game.
     *
     * @param recipientUUID the UUID of the recipient
     * @param gameName      the name of the game
     * @return a deque of the recipient's notifications for the given game;
     * an empty deque if there are none
     */
    @NotNull
    Deque<@NotNull Notification> getRecipientGameNotifications(@NotNull UUID recipientUUID, @NotNull String gameName);


    /**
     * Returns a specific notification sent by the given sender to the given
     * recipient within a specific game.
     *
     * @param recipientUUID the UUID of the recipient
     * @param senderUUID    the UUID of the sender
     * @param gameName      the name of the game
     * @return the found notification, or {@code null} if no such
     * notification exists
     */
    @Nullable
    Notification getRecipientGameNotifications(@NotNull UUID recipientUUID, @NotNull UUID senderUUID, @NotNull String gameName);


    /**
     * Returns all notifications sent by the specified sender within
     * a specific game.
     *
     * @param senderUUID the UUID of the sender
     * @param gameName   the name of the game
     * @return a deque of notifications sent by the given sender for the
     * given game; an empty deque if there are none
     */
    @NotNull
    Deque<@NotNull Notification> getSenderGameNotifications(@NotNull UUID senderUUID, @NotNull String gameName);


    /**
     * Sends a game notification from one player to another, optionally
     * including a bet.
     *
     * @param sender    the player sending the notification
     * @param recipient the player receiving the notification
     * @param gameName  the name of the game the notification refers to
     * @param bet       the bet associated with the notification, or
     *                  {@code null} if there is no bet
     * @return {@code true} if the notification was successfully sent,
     * {@code false} otherwise
     */
    boolean sendNotification(@NotNull Player sender, @NotNull Player recipient, @NotNull String gameName, @Nullable GameBet bet);


    /**
     * Removes a notification by its unique identifier.
     *
     * @param notificationUUID the UUID of the notification to remove
     */
    void removeNotificationByUUID(@NotNull UUID notificationUUID);


    /**
     * Accepts a notification on behalf of the specified player.
     *
     * @param player           the player accepting the notification
     * @param notificationUUID the UUID of the notification being accepted
     * @return {@code true} if the notification was successfully accepted,
     * {@code false} otherwise
     */
    boolean acceptNotification(@NotNull Player player, @NotNull UUID notificationUUID);


    /**
     * Reloads the handler's state.
     */
    void reload();

}
