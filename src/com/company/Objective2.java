package com.company;

import java.util.Scanner;

public class Objective2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("What is your name? ");
        String name = input.nextLine();

        System.out.print("Hello, " + name + ". We are going to guess numbers. First, enter a range: 1-10^");
        int range = (int) Math.pow(10, input.nextInt());
        input.nextLine();

        System.out.println("Now, choose a role:");
        System.out.println("1. Guess my number, or");
        System.out.println("2. think of a number.");
        System.out.print("What would you like to do, " + name + "? (Type the corresponding number to select) ");
        int game = input.nextInt();
        input.nextLine();

        if (game == 1) {
            // Objective 1

            int num = (int) (Math.random() * range);
            int guess;

            System.out.println("(Psst, " + name + ". The random number is " + num + ".)");
            System.out.print(name + ", try guessing a random number from 1-" + range + ": ");

            while (true) {
                guess = input.nextInt();

                if (guess == num) {
                    System.out.println("Yes, " + name + ". The correct number is " + num + ".");
                    break;
                }
                else
                    System.out.print(guess + " is not the correct number, " + name + ". Try again: ");
            }
        }
        else if (game == 2) {
            // Objective 2

            int iteration = 1;

            System.out.println("Okay, " + name + ". Think of a number from 1-" + range + " and I will try to guess it.");
            System.out.println("If my guess is too low, say \"higher\".");
            System.out.println("If my guess is too high, say \"lower\".");
            System.out.println("If my guess is correct, say \"correct\".");

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
        else {
            System.out.println("Invalid input. Try again.");
        }
    }
}
