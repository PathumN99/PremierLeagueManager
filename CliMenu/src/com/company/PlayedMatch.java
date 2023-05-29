package com.company;

public class PlayedMatch {
    private int year;
    private int month;
    private int day;
    private int winClubId;
    private int winClubGoals;
    private int DefClubId;
    private int DefClubGoals;

    public PlayedMatch(int year, int month, int day, int winClubId, int winClubGoals, int DefClubId, int DefClubGoals) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.winClubId = winClubId;
        this.winClubGoals = winClubGoals;
        this.DefClubId = DefClubId;
        this.DefClubGoals = DefClubGoals;
    }

    @Override
    public String toString() {
        return "PlayedMatch{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", winClubId=" + winClubId +
                ", winClubGoals=" + winClubGoals +
                ", DefClubId=" + DefClubId +
                ", DefClubGoals=" + DefClubGoals +
                '}';
    }
}
