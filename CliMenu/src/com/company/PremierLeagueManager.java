package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class PremierLeagueManager implements LeagueManager {

    public static ArrayList<FootballClub> clubList = new ArrayList<FootballClub>();
    public static ArrayList<String> testList = new ArrayList<String>();

    public static void main(String[] args) {
        while (true) {

            System.out.println("--------------------------------------");
            System.out.println("Welcome to the premier league manager");
            System.out.println("--------------------------------------");
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
                      for (FootballClub item: clubList) {
                          System.out.println(item);
                      }
                      break;

                  case 3 :
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

            FootballClub footballClub = new FootballClub(clbNameInput,clbLocInput,clbWinsInput,clbDrawsInput,
                    clbDefeatsInput,recGoalsInput,scoredGoalsInput,pointsInput,playedMatInput);

            clubList.add(footballClub);
            System.out.println("Football club successfully added!");

        } catch (Exception e) {
            System.out.println("Error : "+ e + " Check input and Try again!");
        }
    }

}
