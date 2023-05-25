package com.company;

public class SportsClub {
    private String clubName;
    private String clubLocation;
    private int clubId;

    public SportsClub( int clubId, String clubName, String clubLocation) {
        this.clubId = clubId;
        this.clubName = clubName;
        this.clubLocation = clubLocation;
    }

    public String getClubName() {
        return clubName;
    }

    public String getClubLocation() {
        return clubLocation;
    }

    public int getClubId() {
        return clubId;
    }

}
