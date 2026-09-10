package com.github.Shimado.arcadiumapi.instances.duel.sessions;

import com.github.Shimado.arcadiumapi.instances.GameBet;
import com.github.Shimado.arcadiumapi.interfaces.CycleRunnable;
import com.github.Shimado.arcadiumapi.interfaces.ISession;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * Represents a single duel game session between two players.
 * <p>
 * Stores all runtime data related to the current duel state,
 * including the participating player, session, bet, active cycle,
 * gameplay status, score, rating changes, and the outcome of the duel.
 */
public class DuelGameSession {

    private UUID playerUUID;
    private ISession session;
    private GameBet bet;
    private Object cycle;
    private int cycleTime = 0;
    private boolean canClick = false;
    private int score = 0;
    private long playerRating = 0;
    private int ratingToAdd = 0;
    private int victoryStatus = 0;

    public DuelGameSession(@NotNull UUID playerUUID, @NotNull ISession session, @NotNull GameBet bet){
        this.playerUUID = playerUUID;
        this.session = session;
        this.bet = bet;
    }

    public DuelGameSession(){}



    /**
     * Gets the UUID of the player associated with this duel game session.
     *
     * @return the UUID of the player who owns this duel game session
     */
    @Nullable
    public UUID getPlayer(){
        return playerUUID;
    }

    public void setPlayer(@Nullable UUID playerUUID) {
        this.playerUUID = playerUUID;
    }


    /**
     * Gets the session associated with this duel game session.
     *
     * @return the session, or {@code null} if none has been set
     */
    @Nullable
    public ISession getSession() {
        return session;
    }

    public void setSession(@Nullable ISession session) {
        this.session = session;
    }


    /**
     * Gets the bet associated with this duel game session.
     *
     * @return the current bet, or {@code null} if none has been set
     */
    @Nullable
    public GameBet getBet() {
        return bet;
    }

    public void setBet(@Nullable GameBet bet) {
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
     * Checks whether the player can currently interact with the GUI.
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
     * Gets the current session score.
     *
     * @return the current score
     */
    public int getScore() {
        return score;
    }

    public void setScore(int score){
        this.score = score;
    }

    public void addScore(int score){
        this.score += score;
    }

    public void addScore(){
        this.score++;
    }


    /**
     * Gets the rating of the player at the time this duel session was created.
     *
     * @return the player's rating
     */
    public long getPlayerRating() {
        return playerRating;
    }

    public void setPlayerRating(long playerRating) {
        this.playerRating = playerRating;
    }

    public void addPlayerRating(long playerRating) {
        this.playerRating += playerRating;
    }


    /**
     * Gets the amount of rating pending to be added to the player
     * as a result of this duel.
     *
     * @return the rating amount to add
     */
    public int getRatingToAdd() {
        return ratingToAdd;
    }

    public void setRatingToAdd(int ratingToAdd) {
        this.ratingToAdd = ratingToAdd;
    }

    public void addRatingToAdd(int ratingToAdd){
        this.ratingToAdd += ratingToAdd;
    }


    /**
     * Gets the outcome status of the duel.
     * <p>
     * A value of {@code 0} indicates a draw, {@code -1} indicates a loss,
     * and {@code 1} indicates a victory.
     *
     * @return the victory status of the duel
     */
    public int getVictoryStatus() {
        return victoryStatus;
    }

    public void setVictoryStatus(int victoryStatus){
        this.victoryStatus = victoryStatus;
    }
}
