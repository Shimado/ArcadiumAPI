package com.github.Shimado.arcadiumapi.instances.duel.sessions;

import com.github.Shimado.arcadiumapi.enums.RivalType;
import com.github.Shimado.arcadiumapi.interfaces.CycleRunnable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Represents a hub that groups together the individual duel game sessions
 * of the players participating in a single duel.
 * <p>
 * Stores shared runtime data for the duel as a whole, including the
 * participating players' sessions, rival type, timers, active cycles,
 * and overall gameplay status.
 *
 * @param <S> the specific type of duel game session managed by this hub
 */
public class DuelGameSessionsHub<S extends DuelGameSession> {

    private final UUID sessionUUID;
    private final boolean withoutBet;
    private RivalType rivalType;
    private Map<UUID, S> sessions = new ConcurrentHashMap<>();
    private Object cycle;
    private int cycleTime = 0;
    private Object timeCycle;
    private int timePlayed = 0;
    private boolean canClick = true;
    private boolean started = false;
    private boolean ended = false;

    public DuelGameSessionsHub(@NotNull UUID sessionUUID, boolean withoutBet) {
        this.sessionUUID = sessionUUID;
        this.withoutBet = withoutBet;
    }


    /**
     * Gets the unique identifier of this duel session hub.
     *
     * @return the session UUID
     */
    @NotNull
    public UUID getSessionUUID() {
        return sessionUUID;
    }


    /**
     * Checks whether the duel allows gameplay without a bet.
     *
     * @return {@code true} if betting is not required, otherwise {@code false}
     */
    public boolean isWithoutBet() {
        return withoutBet;
    }


    /**
     * Gets the type of rival for this duel.
     *
     * @return the rival type, or {@code null} if none has been set
     */
    @Nullable
    public RivalType getRivalType() {
        return rivalType;
    }

    public void setRivalType(@NotNull RivalType rivalType) {
        this.rivalType = rivalType;
    }


    /**
     * Gets all individual player game sessions managed by this hub.
     *
     * @return a map of player UUIDs to their associated duel game sessions
     */
    @NotNull
    public Map<UUID, S> getSessions() {
        return sessions;
    }

    public void setSessions(@NotNull Map<UUID, S> sessions) {
        this.sessions = sessions;
    }


    /**
     * Gets the duel game session associated with the given player UUID.
     *
     * @param playerUUID the UUID of the player
     * @return the game session for the player, or {@code null} if none exists
     */
    @Nullable
    public S getSessionByPlayerUUID(@NotNull UUID playerUUID) {
        return sessions.get(playerUUID);
    }

    /**
     * Adds a game session for the given player UUID.
     *
     * @param playerUUID  the UUID of the player
     * @param gameSession the game session to associate with the player
     */
    public void addSession(@NotNull UUID playerUUID, @NotNull S gameSession) {
        sessions.put(playerUUID, gameSession);
    }

    /**
     * Removes the game session associated with the given player UUID.
     *
     * @param playerUUID the UUID of the player whose game session should be removed
     */
    public void removeSessionByPlayerUUID(@NotNull UUID playerUUID) {
        sessions.remove(playerUUID);
    }


    /**
     * Gets the UUID of the opponent, i.e. any player in this hub whose
     * UUID does not match the given player UUID.
     *
     * @param playerUUID the UUID of the player whose opponent should be found
     * @return the UUID of the opponent, or {@code null} if no other player is present
     */
    @Nullable
    public UUID getAnotherPlayerUUID(@NotNull UUID playerUUID){
        return sessions.keySet().stream().filter(it -> !it.equals(playerUUID)).findFirst().orElse(null);
    }


    /**
     * Checks whether the main gameplay cycle is active.
     *
     * @return {@code true} if a cycle task is currently running
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
     * Cancels the active gameplay cycle task.
     *
     * @param cancelCycleRunnable callback used to stop the cycle task
     */
    public void cancelCycleID(@NotNull CycleRunnable cancelCycleRunnable) {
        if (cycle != null) {
            cancelCycleRunnable.run(cycle);
            cycle = null;
        }
    }


    /**
     * Gets the current gameplay cycle timer value.
     *
     * @return the current cycle time
     */
    public int getCycleTime() {
        return cycleTime;
    }

    public void setCycleTime(int cycleTime) {
        this.cycleTime = cycleTime;
    }

    public void addCycleTime() {
        cycleTime++;
    }

    public void removeCycleTime() {
        cycleTime--;
    }


    /**
     * Checks whether the playtime tracking cycle is active.
     *
     * @return {@code true} if the playtime cycle is running
     */
    public boolean isTimeCycleActive() {
        return timeCycle != null;
    }

    @Nullable
    public Object getTimeCycleID(){
        return timeCycle;
    }

    public void setTimeCycleID(@Nullable Object timeCycle) {
        this.timeCycle = timeCycle;
    }

    /**
     * Cancels the active playtime tracking cycle.
     *
     * @param cancelTimeCycleRunnable callback used to stop the cycle task
     */
    public void cancelTimeCycleID(@NotNull CycleRunnable cancelTimeCycleRunnable) {
        if (timeCycle != null) {
            cancelTimeCycleRunnable.run(timeCycle);
            timeCycle = null;
        }
    }


    /**
     * Gets the total played time of this duel.
     *
     * @return the total playtime
     */
    public int getTimePlayed() {
        return timePlayed;
    }

    public void setTimePlayed(int timePlayed) {
        this.timePlayed = timePlayed;
    }

    public void addTimePlayed() {
        timePlayed++;
    }


    /**
     * Checks whether the players can currently interact with the GUI.
     *
     * @return {@code true} if clicking is allowed
     */
    public boolean isCanClick() {
        return canClick;
    }

    public void setCanClick(boolean canClick) {
        this.canClick = canClick;
    }


    /**
     * Checks whether the duel has started.
     *
     * @return {@code true} if the duel is active
     */
    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }


    /**
     * Checks whether the duel has ended.
     *
     * @return {@code true} if the duel has ended
     */
    public boolean isEnded() {
        return ended;
    }

    public void setEnded(boolean ended) {
        this.ended = ended;
    }
}
