package com.company;

import java.util.Scanner;

public class Objective1 {

    public static void main(String[] args) {
        int num = (int) (Math.random() * 100);
        Scanner input = new Scanner(System.in);
        int guess = 0;

        System.out.println("(Psst. The random number is " + num + ".)");
        System.out.print("Try guessing a random number from 1-100: ");

        while (true) {
            guess = input.nextInt();

            if (guess == num) {
                System.out.println("Yes, the correct number is " + num + ".");
                break;
            }
            else
                System.out.print(guess + " is not the correct number. Try again: ");
        }
    }
}
