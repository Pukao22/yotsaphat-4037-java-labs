/**
 * This program is a configurable number guessing game where users can define the range of numbers (min and max) 
 * and the maximum number of attempts allowed. The program ensures valid inputs for both the range and the number of tries. 
 * During the game, users must guess the randomly generated number within the specified range. If the guess is outside 
 * the range, it doesn't count as an attempt, and the user is prompted to try again. 
 * The remaining functionality is the same as the previous version: feedback is provided for each guess (too high, 
 * too low, or correct), and after all attempts, the correct answer is revealed if the user fails to guess it.
 * 
 * Author: Yotsaphat Prasartsri 
 * ID :673040403-7 
 * Sec : 1 
 * Last Updated: December 6, 2024
 */

package prasartsri.yotsaphat.lab3;

import java.util.Scanner;

public class ConfigurableNumberGuessingGame {
    public static void main(String[] args) {

        Scanner my_Obj = new Scanner(System.in);

        int min;
        int max;
        int try_;

        System.out.print("Enter the min value:");
        min = my_Obj.nextInt();

        do {

            System.out.print("Enter the max value:");
            max = my_Obj.nextInt();

            if (min > max) {
                System.out.println(
                        "The max value must be at least equal to the min value");

            }
        } while (min > max);

        do {
            System.out.print("Enter the maximum number of tries:");
            try_ = my_Obj.nextInt();

            if (try_ <= 0) {
                System.out.println(
                        "The maximum number of tries must be greater than 0");

            }
        } while (try_ <= 0);

        int correctNumber = min + (int) (Math.random() * ((max - min) + 1));
        int i = 0;

        System.out.println("Welcome to a number guessing game!");

        for (i = 1; i <= try_; i++) {

            System.out.print("Enter an integer between " + min + " and " + max + ":");
            int number = my_Obj.nextInt();

            if (number < min || number > max) {
                System.out.println("The number must be between " + min + " and " + max);
                i--;
                continue;
            }

            if (number == correctNumber) {
                System.out.println("Congratulations!");
                if (i == 1) {
                    System.out.println("You have tried 1 time.");
                } else {
                    System.out.println("You have tried " + i + " times.");
                }
                break;
            }
            if (number > correctNumber) {
                System.out.println("Try a lower number!");
            }
            if (number < correctNumber) {
                System.out.println("Try a higher number!");
            }

        }
        if (i > try_) {
            if (try_ == 1) {
                System.out.println("You have tried " + try_ + " time. You ran out of guesses");
                System.out.println("The answer is " + correctNumber);
            }
            if (try_ > 1) {
                System.out.println("You have tried " + try_ + " times. You ran out of guesses");
                System.out.println("The answer is " + correctNumber);

            }

        }
    }

}
