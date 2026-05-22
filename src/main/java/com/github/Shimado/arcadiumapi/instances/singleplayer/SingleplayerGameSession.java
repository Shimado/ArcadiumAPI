package com.github.Shimado.arcadiumapi.instances.singleplayer;

import com.github.Shimado.arcadiumapi.instances.GameBet;
import com.github.Shimado.arcadiumapi.interfaces.CycleRunnable;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a single-player game session.
 * <p>
 * Stores all runtime data related to the current game state,
 * including bets, timers, active cycles, gameplay status,
 * score tracking, and GUI-related information.
 */
public class SingleplayerGameSession {

    private boolean withoutBet = false;
    private GameBet bet;
    private Object cycle;
    private int cycleTime = 0;
    private Object timeCycle;
    private int timePlayed = 0;
    private boolean canClick = true;
    private boolean started = false;
    private boolean ended = false;
    private int page = 1;
    private long bestScore = 0;
    private long score = 0;

    public SingleplayerGameSession(@NotNull Player player){
        bet = new GameBet(player);
    }


    /**
     * Checks whether the session allows gameplay without a bet.
     *
     * @return {@code true} if betting is not required, otherwise {@code false}
     */
    public boolean isWithoutBet() {
        return withoutBet;
    }

    public void setWithoutBet(boolean withoutBet) {
        this.withoutBet = withoutBet;
    }


    /**
     * Gets the current bet associated with this session.
     *
     * @return the current bet, or {@code null} if no bet is active
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
     * Gets the total played time of this session.
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
     * Checks whether the game has started.
     *
     * @return {@code true} if the game is active
     */
    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }


    /**
     * Checks whether the game session has ended.
     *
     * @return {@code true} if the session has ended
     */
    public boolean isEnded() {
        return ended;
    }

    public void setEnded(boolean ended) {
        this.ended = ended;
    }


    /**
     * Gets the currently opened GUI page.
     *
     * @return the current page number
     */
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }


    /**
     * Gets the best score achieved by the player ever.
     *
     * @return the best score value
     */
    public long getBestScore() {
        return bestScore;
    }

    public void setBestScore(long bestScore) {
        this.bestScore = bestScore;
    }

    public void addBestScore(){
        bestScore++;
    }

    public void addBestScore(long bestScore){
        this.bestScore += bestScore;
    }


    /**
     * Gets the current session score.
     *
     * @return the current score
     */
    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public void addScore(){
        score++;
    }

    public void addScore(long score){
        this.score += score;
    }

}
