package com.github.Shimado.arcadiumapi.instances.stats;

public class ArcadiumStats {

    private int gamesPlayed = 0;
    private int victories = 0;
    private int defeats = 0;
    private int draws = 0;
    private long timePlayed = 0;
    private long score = 0;
    private long rating = 0;

    public ArcadiumStats(){}

    public ArcadiumStats(int gamesPlayed, int victories, int defeats, int draws, long timePlayed, long score, long rating){
        this.gamesPlayed = gamesPlayed;
        this.victories = victories;
        this.defeats = defeats;
        this.draws = draws;
        this.timePlayed = timePlayed;
        this.score = score;
        this.rating = rating;
    }


    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public void addGamesPlayed() {
        gamesPlayed++;
    }


    public int getVictories() {
        return victories;
    }

    public void setVictories(int victories) {
        this.victories = victories;
    }

    public void addVictory() {
        victories++;
    }


    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public void addDefeat() {
        defeats++;
    }


    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public void addDraws() {
        draws++;
    }


    public long getTimePlayed() {
        return timePlayed;
    }

    public void setTimePlayed(long timePlayed) {
        this.timePlayed = timePlayed;
    }

    public void addTimePlayed() {
        timePlayed++;
    }

    public void addTimePlayed(long timePlayed) {
        this.timePlayed += timePlayed;
    }


    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public void addScore() {
        score++;
    }

    public void addScore(long score) {
        this.score += score;
    }


    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public void addRating() {
        rating++;
    }

    public void addRating(long rating) {
        this.rating += rating;
    }

}
