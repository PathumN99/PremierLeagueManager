package com.company;

import java.util.*;

public class PremierLeagueManager implements LeagueManager {

    public static ArrayList<FootballClub> clubList = new ArrayList<FootballClub>();
    public static ArrayList<PlayedMatch> playedMatch = new ArrayList<PlayedMatch>();

    public static void main(String[] args) {

        while (true) {

            System.out.println("-------------------------------------");
            System.out.println("Welcome to the premier league manager");
            System.out.println("-------------------------------------");
            System.out.println(" ");
            System.out.println("Press 1 to add a football club");
            System.out.println("Press 2 to delete a football club");
            System.out.println("Press 3 to display club statistics");
            System.out.println("Press 4 to display the sorted premier league points table");
            System.out.println("Press 5 to add a played match");
            System.out.println("Press 6 to save the information");
            System.out.println("Press 7 to exit");
            System.out.println(" ");

            System.out.print("Select an option : ");
            Scanner sc = new Scanner(System.in);

            if (sc.hasNextInt()) {
              int userInput = sc.nextInt();

              switch (userInput) {

                  case 1 :
                      addFootballClub();
                      break;

                  case 2 :
                      deleteFootballClub();
                      break;

                  case 3 :
                      viewClubStats();
                      break;

                  case 4 :
                      displayLeagueTable();
                      break;

                  case 5 :
                      addPlayedMatch();
                      break;

                  case 6 :
                      break;

                  case 7 :
                      System.out.println("Terminating program!");
                      System.exit(0);
              }

            } else {
                System.out.println("Please enter a valid input!");
            }
        }
    }

    public static void addFootballClub() {
        Scanner scanner = new Scanner(System.in);

        try {
            int genClubID = 1;

            if(clubList.size() != 0) {
                genClubID = clubList.get(clubList.size() - 1).getClubId() + 1;
            }

            System.out.print("Enter the club name : ");
            String clbNameInput = scanner.next();

            System.out.print("Enter the club location : ");
            String clbLocInput = scanner.next();

            System.out.print("Enter the club wins : ");
            int clbWinsInput = scanner.nextInt();

            System.out.print("Enter the club draws : ");
            int clbDrawsInput = scanner.nextInt();

            System.out.print("Enter the club defeats : ");
            int clbDefeatsInput = scanner.nextInt();

            System.out.print("Enter the club received goals : ");
            int recGoalsInput = scanner.nextInt();

            System.out.print("Enter the club scored goals : ");
            int scoredGoalsInput = scanner.nextInt();

            System.out.print("Enter the club points : ");
            int pointsInput = scanner.nextInt();

            System.out.print("Enter the club played matches : ");
            int playedMatInput = scanner.nextInt();

            FootballClub footballClub = new FootballClub(genClubID, clbNameInput,clbLocInput,clbWinsInput,clbDrawsInput,
                    clbDefeatsInput,recGoalsInput,scoredGoalsInput,pointsInput,playedMatInput);

            clubList.add(footballClub);
            System.out.println("Football club successfully added!");

        } catch (Exception e) {
            System.out.println("Error : "+ e + " - Check input and Try again!");
        }
    }

    public static void viewClubStats() {
        if(clubList.size() != 0 ) {
            System.out.println("..................................");
            System.out.println("            Clubs List            ");
            System.out.println("..................................");
            for (FootballClub item: clubList) {
                System.out.println(item);
            }
        } else {
            System.out.println("Club list is empty!");
        }
    }

    public static void deleteFootballClub() {

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the club ID you want to delete : ");
            int delClubId = scanner.nextInt();
            boolean clubExist = false;

            Iterator<FootballClub> clubIterator = clubList.iterator();

            while (clubIterator.hasNext()) {
                FootballClub item = clubIterator.next();
                if (item.getClubId() == delClubId) {
                    clubIterator.remove();
                    clubExist = true;
                    System.out.println("Club successfully deleted!");
                }
            }

            if (clubExist == false) {
                System.out.println("Entered club ID does not exist!");
            }

        } catch (Exception e) {
            System.out.println("Error : " + e + " - Try again!");
        }
    }

    public static void displayLeagueTable() {

        Comparator<FootballClub> comparator = new Comparator<FootballClub>() {
            @Override
            public int compare(FootballClub obj1, FootballClub obj2) {

                if(obj1.getNumOfPoints() < obj2.getNumOfPoints()) {
                    return 1;   // value 1 swaps the objects
                } else if ((obj1.getNumOfPoints() == obj2.getNumOfPoints())
                        && (obj1.getGoalDifference() < obj2.getGoalDifference())) {
                    return 1;
                } else {
                    return -1;   // value -1 will not swap the objects
                }
            }
        };

        Collections.sort(clubList, comparator);

        for (FootballClub item: clubList) {
            System.out.println(item);
        }
    }

    public static void addPlayedMatch() {
        Scanner scanner = new Scanner(System.in);

        try {

            System.out.print("Enter the year : ");
            int year = scanner.nextInt();

            if(year > 2030 || year < 1989) {
                throw new Exception("Entered year is not valid!");
            }

            System.out.print("Enter the month : ");
            int month = scanner.nextInt();

            if(month == 0 || month > 12) {
                throw new Exception("Entered Month is not valid!");
            }

            System.out.print("Enter the Day : ");
            int day = scanner.nextInt();

            if(day == 0 || day > 31) {
                throw new Exception("Entered Day is not valid!");
            } else if(month == 2 && day > 28) {
                throw new Exception("Month of February must have only 28 days!");
            }

            System.out.print("Enter the winning club's ID : ");
            int winClubId = scanner.nextInt();

            System.out.print("Number of goals scored by the winning club : ");
            int goalsScoredWinClub = scanner.nextInt();

            System.out.print("Enter the defeated club's ID : ");
            int defeatedClubId = scanner.nextInt();

            System.out.print("Number of goals scored by the defeated club : ");
            int goalsScoredDefClub = scanner.nextInt();

            Iterator<FootballClub> clubIterator = clubList.iterator();

            while (clubIterator.hasNext()) {
                FootballClub item = clubIterator.next();

                if (item.getClubId() == winClubId) {
                    item.setWins(item.getWins() + 1);
                    item.setGoalsReceived(item.getGoalsReceived() + goalsScoredDefClub);
                    item.setGoalsScored(item.getGoalsScored() + goalsScoredWinClub);
                    item.setNumOfPoints(item.getNumOfPoints() + 1);
                    item.setMatchesPlayed(item.getMatchesPlayed() + 1);
                    System.out.println("Club: "+ winClubId + "stats updated successfully!");
                }

                if (item.getClubId() == defeatedClubId) {
                    item.setDefeats(item.getDefeats() + 1);
                    item.setGoalsReceived(item.getGoalsReceived() + goalsScoredWinClub);
                    item.setGoalsScored(item.getGoalsScored() + goalsScoredDefClub);
                    item.setMatchesPlayed(item.getMatchesPlayed() + 1);
                    System.out.println("Club: "+ defeatedClubId + "stats updated successfully!");
                }
            }

        } catch (Exception e) {
            System.out.println("Error : "+ e.getMessage() + " - Try again!");
        }


    }

}
