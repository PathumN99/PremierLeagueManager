package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class PremierLeagueManager implements LeagueManager {

    public static ArrayList<FootballClub> clubList = new ArrayList<FootballClub>();
    public static ArrayList<String> testList = new ArrayList<String>();

    public static void main(String[] args) {

        while (true) {

            System.out.println("-------------------------------------");
            System.out.println("Welcome to the premier league manager");
            System.out.println("-------------------------------------");
            System.out.println(" ");
            System.out.println("Press 1 to add a football club");
            System.out.println("Press 2 to delete a football club");
            System.out.println("Press 3 to display club statistics");
            System.out.println("Press 4 to display the premier league table");
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
                      break;

                  case 5 :
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

}
