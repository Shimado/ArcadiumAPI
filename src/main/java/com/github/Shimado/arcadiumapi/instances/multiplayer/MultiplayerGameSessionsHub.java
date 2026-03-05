package com.github.Shimado.arcadiumapi.instances.multiplayer;

import com.github.Shimado.arcadiumapi.instances.ArcadiumGame;
import com.github.Shimado.arcadiumapi.interfaces.CycleRunnable;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.stream.Collectors;

/**
 * A hub that manages multiple multiplayer game sessions for a game.
 * This class serves as a central manager for all player sessions within a single
 * multiplayer game instance, providing session management, player tracking, and
 * game state coordination.
 */

public class MultiplayerGameSessionsHub<S extends MultiplayerGameSession> {

    private UUID sessionUUID;
    private Map<Player, S> playerSessions = new HashMap<>();
    private Object cycle;
    private int time = 0;
    private boolean opened = true;
    private boolean ended = false;

    /**
     * Constructs a new multiplayer game sessions hub with the specified session UUID.
     *
     * @param sessionUUID the unique identifier for this game session hub
     */

    public MultiplayerGameSessionsHub(@NotNull UUID sessionUUID) {
        this.sessionUUID = sessionUUID;
    }


    /**
     * Gets the unique identifier for this session hub.
     *
     * @return the session UUID
     */

    @NotNull
    public UUID getSessionUUID() {
        return sessionUUID;
    }

    /**
     * Gets all player sessions managed by this hub.
     *
     * @return a map of all players to their respective game sessions
     */

    @NotNull
    public Map<Player, S> getPlayerSessions() {
        return playerSessions;
    }

    public void setPlayerSessions(@NotNull Map<Player, S> playerSessions) {
        if (playerSessions == null) {
            this.playerSessions = new HashMap<>();
            return;
        }
        this.playerSessions = playerSessions;
    }

    /**
     * Gets the game session for a specific player.
     *
     * @param player the player whose session to retrieve
     * @return the player's game session, or null if the player doesn't have a session
     */

    @Nullable
    public S getPlayerSession(@NotNull Player player) {
        return playerSessions.get(player);
    }

    public void addPlayerSession(@NotNull Player player, @NotNull S gameSession) {
        playerSessions.put(player, gameSession);
    }

    /**
     * Removes a player session from the hub using the player's UUID.
     *
     * @param player the player to remove
     */

    public void removePlayerSession(@NotNull Player player) {
        playerSessions.remove(player);
    }


    /**
     * Gets all player sessions that have active bets and assigned slots.
     * A session is considered to have an active bet if it has a non-null bet
     *
     * @return a map of players to sessions that meet the criteria
     */

    @NotNull
    public Map<Player, S> getPlayerSessionsWithActiveBetsAndSlots() {
        return playerSessions.entrySet().stream()
                .filter(it -> it.getValue().getBet() != null && it.getValue().getBet().isAnyBet() && it.getValue().getBet().getSlot() != -1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }


    /**
     * Gets the total number of players in this session hub.
     *
     * @return the number of players
     */

    public int getPlayersAmount() {
        return playerSessions.size();
    }


    /**
     * Gets the number of players who have active bets and assigned slots.
     *
     * @return the count of players with active bets and valid slots
     */

    public int getPlayerAmountWithActiveBetsAndSlots() {
        return (int) playerSessions.values().stream().filter(it -> it.getBet() != null && it.getBet().isAnyBet() && it.getBet().getSlot() != -1).count();
    }


    /**
     * Gets the list of another players in the session.
     *
     * @return the list of the players in the session except the player
     * **/

    @NotNull
    public List<Player> getAnotherPlayers(@NotNull Player player){
        return playerSessions.keySet().stream().filter(it -> !it.getUniqueId().equals(player.getUniqueId())).collect(Collectors.toList());
    }


    /**
     * Gets a list of available (free) spot slots for the specified game mode.
     * This method calculates which slots from the game mode's available slots
     * are not currently occupied by any player.
     *
     * @param gameMode the game mode to get available slots for
     * @return a list of free slot numbers
     */

    @NotNull
    public List<Integer> getFreeSpotSlots(@NotNull ArcadiumGame gameMode) {
        List<Integer> emptySlots = new ArrayList<>(gameMode.getSpotSlots());
        Set<Integer> occupiedSlots = playerSessions.values().stream()
                .filter(it -> it.getBet() != null && it.getBet().getSlot() != -1)
                .map(it -> it.getBet().getSlot())
                .collect(Collectors.toSet());

        emptySlots.removeAll(occupiedSlots);
        return emptySlots;
    }


    /**
     * Checks whether a cycle task is currently active for this session.
     *
     * @return true if a cycle task is active, false otherwise
     */

    public boolean isCycleActive() {
        return cycle != null;
    }

    @Nullable
    public Object getCycleID(){
        return cycle;
    }

    public void setCycleID(@Nullable Object cycle) {
        this.cycle = cycle;
    }

    /**
     * Cancels and clears the current cycle task if one is active.
     */

    public void cancelCycleID(@NotNull CycleRunnable cancelCycleRunnable) {
        if (cycle != null) {
            cancelCycleRunnable.run(cycle);
            cycle = null;
        }
    }


    /**
     * Gets the current timer value for this session.
     *
     * @return the current timer value
     */

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void addTime() {
        time++;
    }

    public void removeTime() {
        time--;
    }


    /**
     * Checks if the session hub is currently open for another players.
     * And any another player can join.
     *
     * @return true if the hub is open, false if closed
     */

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }


    /**
     * Checks if the game has ended.
     *
     * @return true if the game has ended, false if still active
     */

    public boolean isEnded() {
        return ended;
    }

    public void setEnded(boolean ended) {
        this.ended = ended;
    }
}
