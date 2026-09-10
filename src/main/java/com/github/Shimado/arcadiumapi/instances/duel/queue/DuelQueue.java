package com.github.Shimado.arcadiumapi.instances.duel.queue;

import com.github.Shimado.arcadiumapi.enums.RivalType;
import com.github.Shimado.arcadiumapi.instances.GameBet;
import com.github.Shimado.arcadiumapi.interfaces.CycleRunnable;
import com.github.Shimado.arcadiumapi.interfaces.ISession;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

/**
 * Represents a matchmaking queue entry for a duel between players.
 * <p>
 * Stores all runtime data related to the duel queue state,
 * including the associated player and session, bets, timers,
 * active cycles, invited players, notifications, rival selection
 * criteria, and player search results.
 */
public class DuelQueue {

    private final UUID playerUUID;
    private final ISession session;
    private final boolean withoutBet;
    private GameBet bet;
    private Object cycle;
    private int cycleTime = 0;
    private Object timeCycle;
    private int timePlayed = 0;
    private long playerRating = 0;
    private Deque<UUID> selectedPlayersToInvite = new ArrayDeque<>();
    private Set<UUID> sentNotifications = new HashSet<>();                    // Notification UUIDs
    private boolean active = false;
    private RivalType rivalType;                                              // What player selected
    private List<UUID> searchPlayers = new ArrayList<>();                     // Players in GamePage.PLAYERS

    /**
     * Creates a new duel queue entry for the specified player.
     * <p>
     * An empty {@link GameBet} is created automatically for the player.
     *
     * @param playerUUID the UUID of the player who owns this queue entry
     * @param session    the session associated with this queue entry
     * @param withoutBet {@code true} if the duel can be played without a bet,
     *                   otherwise {@code false}
     */
    public DuelQueue(@NotNull UUID playerUUID, @NotNull ISession session, boolean withoutBet){
        this.playerUUID = playerUUID;
        this.session = session;
        this.bet = new GameBet(playerUUID);
        this.withoutBet = withoutBet;
    }


    /**
     * Gets the UUID of the player associated with this duel queue entry.
     *
     * @return the UUID of the player who owns this queue entry
     */
    @NotNull
    public UUID getPlayerUUID() {
        return playerUUID;
    }


    /**
     * Gets the session associated with this duel queue entry.
     *
     * @return the current session
     */
    @NotNull
    public ISession getSession() {
        return session;
    }


    /**
     * Checks whether the duel queue allows gameplay without a bet.
     *
     * @return {@code true} if betting is not required, otherwise {@code false}
     */
    public boolean isWithoutBet() {
        return withoutBet;
    }


    /**
     * Gets the current bet associated with this duel queue entry.
     *
     * @return the current bet
     */
    @NotNull
    public GameBet getBet() {
        return bet;
    }

    /**
     * Sets the bet associated with this duel queue entry.
     *
     * @param bet the bet to assign
     */
    public void setBet(@NotNull GameBet bet) {
        this.bet = bet;
    }


    /**
     * Checks whether the main gameplay cycle is active.
     *
     * @return {@code true} if a cycle task is currently running
     */
    public boolean isCycleActive() {
        return cycle != null;
    }

    /**
     * Gets the identifier of the active gameplay cycle.
     *
     * @return the cycle identifier, or {@code null} if no cycle is active
     */
    @Nullable
    public Object getCycleID(){
        return cycle;
    }

    /**
     * Sets the identifier of the gameplay cycle.
     *
     * @param cycle the cycle identifier, or {@code null} to clear it
     */
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

    /**
     * Sets the gameplay cycle timer value.
     *
     * @param cycleTime the new cycle time
     */
    public void setCycleTime(int cycleTime) {
        this.cycleTime = cycleTime;
    }

    /**
     * Increments the gameplay cycle timer by one.
     */
    public void addCycleTime() {
        cycleTime++;
    }

    /**
     * Decrements the gameplay cycle timer by one.
     */
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

    /**
     * Gets the identifier of the active playtime tracking cycle.
     *
     * @return the playtime cycle identifier, or {@code null} if no cycle is active
     */
    @Nullable
    public Object getTimeCycleID(){
        return timeCycle;
    }

    /**
     * Sets the identifier of the playtime tracking cycle.
     *
     * @param timeCycle the playtime cycle identifier, or {@code null} to clear it
     */
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
     * Gets the total played time of this duel queue entry.
     *
     * @return the total playtime
     */
    public int getTimePlayed() {
        return timePlayed;
    }

    /**
     * Sets the total played time of this duel queue entry.
     *
     * @param timePlayed the new total playtime
     */
    public void setTimePlayed(int timePlayed) {
        this.timePlayed = timePlayed;
    }

    /**
     * Increments the total played time by one.
     */
    public void addTimePlayed() {
        timePlayed++;
    }


    /**
     * Gets the rating of the player at the time this queue entry was created.
     *
     * @return the player's rating
     */
    public long getPlayerRating() {
        return playerRating;
    }

    /**
     * Sets the rating of the player for this queue entry.
     *
     * @param playerRating the player's rating
     */
    public void setPlayerRating(long playerRating) {
        this.playerRating = playerRating;
    }


    /**
     * Gets the deque of player uuids selected to be invited to the duel.
     *
     * @return the deque of selected player uuids to invite
     */
    @NotNull
    public Deque<UUID> getSelectedPlayersToInvite(){
        return selectedPlayersToInvite;
    }

    /**
     * Sets the deque of player uuids selected to be invited to the duel.
     *
     * @param selectedPlayersToInvite the deque of player uuids to invite
     */
    public void setSelectedPlayersToInvite(@NotNull Deque<UUID> selectedPlayersToInvite){
        this.selectedPlayersToInvite = selectedPlayersToInvite;
    }


    /**
     * Gets the set of notification UUIDs that have already been sent
     * for this duel queue entry.
     *
     * @return the set of sent notification UUIDs
     */
    @NotNull
    public Set<UUID> getSentNotifications() {
        return sentNotifications;
    }

    /**
     * Sets the set of notification UUIDs that have already been sent
     * for this duel queue entry.
     *
     * @param sentNotifications the set of sent notification UUIDs
     */
    public void setSentNotifications(@NotNull Set<UUID> sentNotifications) {
        this.sentNotifications = sentNotifications;
    }

    /**
     * Marks a notification as sent by adding its UUID to the set
     * of sent notifications.
     *
     * @param sentNotification the UUID of the notification that was sent
     */
    public void addSentNotification(@NotNull UUID sentNotification){
        sentNotifications.add(sentNotification);
    }


    /**
     * Checks whether this duel queue entry is currently active.
     *
     * @return {@code true} if the queue entry is active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets whether this duel queue entry is currently active.
     *
     * @param active {@code true} to mark the queue entry as active
     */
    public void setActive(boolean active) {
        this.active = active;
    }


    /**
     * Gets the type of rival the player has chosen to search for.
     *
     * @return the selected rival type, or {@code null} if none has been chosen
     */
    @Nullable
    public RivalType getRivalType() {
        return rivalType;
    }

    /**
     * Sets the type of rival the player wants to search for.
     *
     * @param rivalType the rival type to assign
     */
    public void setRivalType(@NotNull RivalType rivalType) {
        this.rivalType = rivalType;
    }


    /**
     * Gets the list of player uuids found when the player searched by nickname
     * on the players' page.
     *
     * @return the list of found player uuids
     */
    @NotNull
    public List<UUID> getSearchPlayers(){
        return searchPlayers;
    }

    /**
     * Sets the list of player uuids found when the player searched by nickname
     * on the players' page.
     *
     * @param searchPlayers the list of found player uuids
     */
    public void setSearchPlayers(@NotNull List<UUID> searchPlayers){
        this.searchPlayers = searchPlayers;
    }

}
