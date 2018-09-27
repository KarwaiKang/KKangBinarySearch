package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class KKangGuessingGame {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("What is your name? ");
        String name = input.nextLine();
        System.out.print("\nHello, " + name + ". We are going to guess numbers. First, enter a range: 1-10^");

        int range;

        while (true) {
            try {
                int power = input.nextInt();

                if (power < 0) {
                    System.out.print("Please choose a positive number: 1-10^");
                    input.nextLine();
                    continue;
                }

                range = (int) Math.pow(10, power);
                input.nextLine();
                break;
            }
            catch (InputMismatchException e) {
                System.out.print("Please enter an integer: 1-10^");
                input.nextLine();
            }
        }

        System.out.println("\nOkay, the range will be 1-" + range + ".");

        System.out.println("\nNow, choose a role:");
        System.out.println("1. Guess a number I think of, or");
        System.out.println("2. think of a number that I will guess.");
        System.out.print("What would you like to do, " + name + "? Enter the corresponding number: ");

        int game;

        while (true) {
            try {
                game = input.nextInt();
                input.nextLine();

                if (game != 1 && game != 2) {
                    System.out.print("You may only choose two options (1 or 2): ");
                    continue;
                }

                break;
            }
            catch (InputMismatchException e) {
                System.out.print("That wasn't a number. Try again: ");
                input.nextLine();
            }
        }

        if (game == 1) {
            // Objective 1

            int num = (int) (Math.random() * range);
            int guess;

            System.out.print(name + ", try guessing a random number from 1-" + range + ": ");

            while (true) {
                guess = input.nextInt();

                if (guess == num) {
                    System.out.println("Yes, the correct number is " + num + ". Good job, " + name + ".");
                    break;
                }
                else {
                    if (guess < num)
                        System.out.print(guess + " is too low, " + name + ". Try again: ");
                    else
                        System.out.print(guess + " is too high, " + name + ". Try again: ");
                }
            }
        }
        else {
            // Objective 2

            int iteration = 1;

            System.out.println("\nOkay, " + name + ". Think of a number from 1-" + range + " and I will try to guess it.");
            System.out.println("If my guess is too low, say \"higher\".");
            System.out.println("If my guess is too high, say \"lower\".");
            System.out.println("If my guess is correct, say \"correct\".\n");

            int guess = range / 2;

            while (true) {
                System.out.print("(Guess #" + iteration + ") " + name + ", is your number " + guess + "? ");
                String answer = input.nextLine();

                iteration++;
                double difference = Math.ceil(range / Math.pow(2, iteration));

                if (answer.equals("higher"))
                    guess += difference;
                else if (answer.equals("lower"))
                    guess -= difference;
                else if (answer.equals("correct")) {
                    System.out.println("Yes, I was correct! It only took me " + (iteration - 1) + " guesses.");
                    System.out.println("A linear search would have taken " + guess + " guesses.");
                    System.out.println("That's " + (guess / (double) (iteration - 1)) + " times as fast!");
                    System.out.println("Thanks for playing with me, " + name + ".");
                    break;
                }
            }
        }
    }
}
