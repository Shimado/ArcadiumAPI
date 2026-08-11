package com.github.Shimado.arcadiumapi.instances.duel.queue;

import com.github.Shimado.arcadiumapi.enums.RivalType;
import com.github.Shimado.arcadiumapi.instances.GameBet;
import com.github.Shimado.arcadiumapi.interfaces.CycleRunnable;
import com.github.Shimado.arcadiumapi.interfaces.ISession;
import org.bukkit.entity.Player;
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

    private final Player player;
    private final ISession session;
    private final boolean withoutBet;
    private GameBet bet;
    private Object cycle;
    private int cycleTime = 0;
    private Object timeCycle;
    private int timePlayed = 0;
    private long playerRating = 0;
    private Deque<Player> selectedPlayersToInvite = new ArrayDeque<>();
    private Set<UUID> sentNotifications = new HashSet<>();              // Notification UUIDs
    private boolean active = false;
    private RivalType rivalType;                                        // What player selected
    private List<Player> searchPlayers = new ArrayList<>();             // Players in GamePage.PLAYERS

    public DuelQueue(@NotNull Player player, @NotNull ISession session, boolean withoutBet){
        this.player = player;
        this.session = session;
        this.bet = new GameBet(player);
        this.withoutBet = withoutBet;
    }


    /**
     * Gets the player associated with this duel queue entry.
     *
     * @return the player who initiated or is part of this queue entry
     */
    @NotNull
    public Player getPlayer() {
        return player;
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
     * Gets the total played time of this duel queue entry.
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
     * Gets the rating of the player at the time this queue entry was created.
     *
     * @return the player's rating
     */
    public long getPlayerRating() {
        return playerRating;
    }

    public void setPlayerRating(long playerRating) {
        this.playerRating = playerRating;
    }


    /**
     * Gets the deque of players selected to be invited to the duel.
     *
     * @return the deque of selected players to invite
     */
    @NotNull
    public Deque<Player> getSelectedPlayersToInvite(){
        return selectedPlayersToInvite;
    }

    public void setSelectedPlayersToInvite(@NotNull Deque<Player> selectedPlayersToInvite){
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

    public void setRivalType(@NotNull RivalType rivalType) {
        this.rivalType = rivalType;
    }


    /**
     * Gets the list of players found when the player searched by nickname
     * on the players' page.
     *
     * @return the list of found players
     */
    @NotNull
    public List<Player> getSearchPlayers(){
        return searchPlayers;
    }

    public void setSearchPlayers(@NotNull List<Player> searchPlayers){
        this.searchPlayers = searchPlayers;
    }

}
