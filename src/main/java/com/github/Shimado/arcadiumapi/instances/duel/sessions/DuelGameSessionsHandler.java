package com.github.Shimado.arcadiumapi.instances.duel.sessions;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Handles the lifecycle and lookup of duel game session hubs.
 * <p>
 * Provides a generic base for managing a collection of {@link DuelGameSessionsHub}
 * (or its subclasses) instances, keyed by session UUID, and delegates
 * the creation of hub instances to subclasses. Also provides convenience
 * lookups for hubs and individual game sessions by player UUID.
 *
 * @param <S> the specific type of duel game session managed within each hub
 * @param <H> the specific type of duel game sessions hub managed by this handler
 */
public abstract class DuelGameSessionsHandler<S extends DuelGameSession, H extends DuelGameSessionsHub<S>> {

    private Map<UUID, H> hubs = new ConcurrentHashMap<>();

    /**
     * Creates a new hub instance for the given session UUID.
     *
     * @param sessionUUID the unique identifier for the new session hub
     * @param withoutBet  {@code true} if the hub should not require a bet
     * @return the newly created hub instance
     */
    protected abstract H createHub(@NotNull UUID sessionUUID, boolean withoutBet);


    /**
     * Gets all session hubs currently managed by this handler.
     *
     * @return a map of session UUIDs to their associated hubs
     */
    @NotNull
    public Map<UUID, H> getHubs() {
        return hubs;
    }


    /**
     * Finds the hub containing a game session for the given player UUID.
     *
     * @param playerUUID the UUID of the player
     * @return the hub containing the player's session, or {@code null} if none is found
     */
    @Nullable
    public H getHubByPlayerUUID(@NotNull UUID playerUUID){
        for (H session : hubs.values()) {
            if (session.getSessions().containsKey(playerUUID)) {
                return session;
            }
        }
        return null;
    }


    /**
     * Finds the game session associated with the given player UUID,
     * searching across all managed hubs.
     *
     * @param playerUUID the UUID of the player
     * @return the player's game session, or {@code null} if none is found
     */
    @Nullable
    public S getGameSessionByPlayerUUID(@NotNull UUID playerUUID){
        for (H session : hubs.values()) {
            S gameSession = session.getSessionByPlayerUUID(playerUUID);
            if (gameSession != null) {
                return gameSession;
            }
        }
        return null;
    }


    /**
     * Creates a new game session hub with a randomly generated UUID
     * and registers it with this handler.
     *
     * @param withoutBet {@code true} if the hub should not require a bet
     * @return the newly created hub
     */
    @NotNull
    public H createGameSessionHub(boolean withoutBet){
        UUID sessionUUID = UUID.randomUUID();
        H hub = hubs.computeIfAbsent(sessionUUID, k -> createHub(sessionUUID, withoutBet));
        return hub;
    }


    /**
     * Removes the hub associated with the given session UUID.
     *
     * @param sessionUUID the UUID of the session hub to remove
     */
    public void removeSessionBySessionUUID(@NotNull UUID sessionUUID) {
        hubs.remove(sessionUUID);
    }


    /**
     * Gets the total number of players currently participating in
     * duel game sessions across all managed hubs.
     *
     * @return the total number of players online in duels
     */
    public int getGameOnline(){
        return (int) hubs.values().stream().mapToInt(it -> it.getSessions().size()).count();
    }

}
