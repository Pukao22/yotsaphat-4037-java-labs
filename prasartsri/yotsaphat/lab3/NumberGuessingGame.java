/**
 * This program is a simple number guessing game that gives the user 5 chances to guess a number. 
 * The answer is randomly generated within a range between 1 and 10. 
 * After each guess, the program will indicate whether the entered number is higher or lower than the correct answer. 
 * If the user guesses correctly, the program will display a congratulatory message along with the number of attempts made. 
 * If the user fails to guess correctly after 5 attempts, the program will reveal the correct answer. 
 * The code uses a for loop to control the number of attempts and a Scanner to handle user input.
 * 
 * Author: Yotsaphat Prasartsri 
 * ID :673040403-7 
 * Sec : 1 
 * Last Updated: December 6, 2024
 */

package prasartsri.yotsaphat.lab3;

import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {

        int min = 1;
        int max = 10;
        int correctNumber = min + (int) (Math.random() * ((max - min) + 1));
        int i = 0;

        System.out.println("Welcome to a number guessing game!");

        for (i = 1; i <= 5; i++) {

            Scanner myObj = new Scanner(System.in);
            System.out.print("Enter an integer between " + min + " and " + max + ":");
            int number = myObj.nextInt();

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
        if (i > 5) {
            System.out.println("You have tried 5 times. You ran out of guesses");
            System.out.println("The answer is " + correctNumber);
        }
    }

}
