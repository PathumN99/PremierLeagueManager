package com.company;

import java.util.Comparator;

public class FootballClub extends SportsClub {
    private int wins;
    private int draws;
    private int defeats;
    private int goalsReceived;
    private int goalsScored;
    private int numOfPoints;
    private int matchesPlayed;

    public FootballClub(int clubId, String clubName, String clubLocation, int wins, int draws, int defeats,
                        int goalsReceived, int goalsScored, int numOfPoints, int matchesPlayed) {
        super(clubId, clubName, clubLocation);
        this.wins = wins;
        this.draws = draws;
        this.defeats = defeats;
        this.goalsReceived = goalsReceived;
        this.goalsScored = goalsScored;
        this.numOfPoints = numOfPoints;
        this.matchesPlayed = matchesPlayed;
    }

    public int getNumOfPoints() {
        return this.numOfPoints;
    }

    public int getGoalDifference() {
        return this.goalsScored - this.goalsReceived;
    }

    @Override
    public String toString() {
        return "FootballClub { " +
                "Club ID=" + super.getClubId() +
                ", Name=" + super.getClubName() +
                ", Location=" + super.getClubLocation() +
                ", wins=" + wins +
                ", draws=" + draws +
                ", defeats=" + defeats +
                ", goalsReceived=" + goalsReceived +
                ", goalsScored=" + goalsScored +
                ", numOfPoints=" + numOfPoints +
                ", matchesPlayed=" + matchesPlayed +
                " } ";
    }

//    @Override
//    public int compareTo(FootballClub compareClub) {
//        int comparePoints = ((FootballClub)compareClub).getNumOfPoints();
//        return this.numOfPoints - comparePoints;
//    }

//    @Override
//    public int compareTo(FootballClub o) {
//        return 0;
//    }
}
