package com.company;

import java.util.Scanner;

public class Objective2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int range = 100;
        int iteration = 1;
        int guess = range / 2;

        System.out.println("Think of a number from 1-" + range + " and I will try to guess it.");
        System.out.println("If my guess is too low, say \"higher\".");
        System.out.println("If my guess is too high, say \"lower\".");
        System.out.println("If my guess is correct, say \"correct\".");

        while (true) {
            System.out.print("(Guess #" + iteration + ") Is the number " + guess + "? ");
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
                break;
            }
        }
    }
}
