package com.github.Shimado.arcadiumapi.instances.duel.queue;

import com.github.Shimado.arcadiumapi.interfaces.ISession;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Handles the lifecycle and storage of duel queue entries for players.
 * <p>
 * Provides a generic base for managing a collection of {@link DuelQueue}
 * (or its subclasses) instances, keyed by player UUID, and delegates
 * the creation of queue instances to subclasses.
 *
 * @param <Q> the specific type of duel queue managed by this handler
 */
public abstract class DuelQueueHandler<Q extends DuelQueue> {

    private Map<UUID, Q> playerQueues = new ConcurrentHashMap<>();


    /**
     * Creates a new queue instance for the given player and session.
     *
     * @param playerUUID   the UUID of the player who owns this queue entry
     * @param session      the session associated with the queue
     * @param withoutBet   {@code true} if the queue should not require a bet
     * @return the newly created queue instance
     */
    protected abstract Q createQueue(@NotNull UUID playerUUID, @NotNull ISession session, boolean withoutBet);


    /**
     * Gets all player queues currently managed by this handler.
     *
     * @return a map of player UUIDs to their associated queue entries
     */
    @NotNull
    public Map<UUID, Q> getQueues() {
        return playerQueues;
    }

    /**
     * Gets the queue entry associated with the given player UUID.
     *
     * @param playerUUID the UUID of the player
     * @return the queue entry for the player, or {@code null} if none exists
     */
    @Nullable
    public Q getQueueByPlayerUUID(@NotNull UUID playerUUID){
        return playerQueues.get(playerUUID);
    }

    /**
     * Replaces the map of player queues managed by this handler.
     *
     * @param playerQueues the new map of player UUIDs to queue entries
     */
    public void setPlayerQueues(@NotNull Map<UUID, Q> playerQueues) {
        this.playerQueues = playerQueues;
    }

    /**
     * Adds a queue entry for the given player UUID.
     *
     * @param playerUUID the UUID of the player
     * @param queue      the queue entry to associate with the player
     */
    public void addPlayerToQueue(@NotNull UUID playerUUID, @NotNull Q queue){
        playerQueues.put(playerUUID, queue);
    }

    /**
     * Removes the queue entry associated with the given player UUID.
     *
     * @param playerUUID the UUID of the player whose queue entry should be removed
     */
    public void removeQueueByPlayerUUID(@NotNull UUID playerUUID){
        playerQueues.remove(playerUUID);
    }

}
