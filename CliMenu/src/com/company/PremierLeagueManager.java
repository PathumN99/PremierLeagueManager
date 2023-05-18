package com.company;

import java.util.Scanner;

public class PremierLeagueManager implements LeagueManager {

    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a number : ");
            int userInput = sc.nextInt();
            System.out.println("Your input is : " + userInput);

        }
    }

}
