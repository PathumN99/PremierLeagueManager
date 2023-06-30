package com.server.plmserver.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "football_club")
public class FootballClubEntity {

    @Id
    @SequenceGenerator(
            name = "football_club_sequence",
            sequenceName = "football_club_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "football_club_sequence")
    @Column(name = "id")
    private Long club_id;

    @Column(name = "club_name")
    private String clubName;

    @Column(name = "club_location")
    private String clubLocation;

    @Column(name = "wins")
    private int wins;

    @Column(name = "draws")
    private int draws;

    @Column(name = "defeats")
    private int defeats;

    @Column(name = "goals_received")
    private int goalsReceived;

    @Column(name = "goals_scored")
    private int goalsScored;

    @Column(name = "num_of_points")
    private int numOfPoints;

    @Column(name = "matches_played")
    private int matchesPlayed;

    public FootballClubEntity() {
    }

    public FootballClubEntity(Long club_id, String clubName, String clubLocation,
                              int wins, int draws, int defeats, int goalsReceived,
                              int goalsScored, int numOfPoints, int matchesPlayed) {
        this.club_id = club_id;
        this.clubName = clubName;
        this.clubLocation = clubLocation;
        this.wins = wins;
        this.draws = draws;
        this.defeats = defeats;
        this.goalsReceived = goalsReceived;
        this.goalsScored = goalsScored;
        this.numOfPoints = numOfPoints;
        this.matchesPlayed = matchesPlayed;
    }

    public Long getClub_id() {
        return club_id;
    }

    public void set_id(Long club_id) {
        this.club_id = club_id;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubLocation() {
        return clubLocation;
    }

    public void setClubLocation(String clubLocation) {
        this.clubLocation = clubLocation;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public int getGoalsReceived() {
        return goalsReceived;
    }

    public void setGoalsReceived(int goalsReceived) {
        this.goalsReceived = goalsReceived;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getNumOfPoints() {
        return numOfPoints;
    }

    public void setNumOfPoints(int numOfPoints) {
        this.numOfPoints = numOfPoints;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }
}
