package com.github.Shimado.arcadiumapi.instances.stats;

public class ArcadiumStats {

    private int gamesPlayed = 0;
    private int victories = 0;
    private int defeats = 0;
    private long timePlayed = 0;

    public ArcadiumStats(){}

    public ArcadiumStats(int gamesPlayed, int victories, int defeats, long timePlayed){
        this.gamesPlayed = gamesPlayed;
        this.victories = victories;
        this.defeats = defeats;
        this.timePlayed = timePlayed;
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


    public long getTimePlayed() {
        return timePlayed;
    }

    public void setTimePlayed(long timePlayed) {
        this.timePlayed = timePlayed;
    }

    public void addTimePlayed() {
        timePlayed++;
    }

}
