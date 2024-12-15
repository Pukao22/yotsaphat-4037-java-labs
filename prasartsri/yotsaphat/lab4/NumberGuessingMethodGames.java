/*
 * This program is a number guessing game that utilizes static variables and methods to control the game settings and logic.
 * 
 * The program includes the following methods:
 * 1. configure(): This method allows the user to input the minimum and maximum number for the guessing range, as well as the maximum number of tries. It also ensures the input is valid.
 * 2. genAnswer(): This method generates a random number within the specified range (min and max) and stores it as the correct answer for the game.
 * 3. playGame(): This method handles the core gameplay. It prompts the user to guess a number within the range and provides feedback on whether the guess is too high or too low. It continues until the user guesses correctly or runs out of tries.
 * 4. playGames(): This method controls the flow of the game, allowing the user to play multiple rounds. After each game, the user is asked if they want to play again. If not, the program ends with a thank you message.
 * 
 * The program runs in a loop, allowing the user to play multiple rounds of the game until they decide to stop.
 * 
 * Author: Yotsaphat Prasartsri 
 * ID :673040403-7 
 * Sec : 1 
 * Last Updated: December 15, 2024
 */

package prasartsri.yotsaphat.lab4;

import java.util.Scanner;

public class NumberGuessingMethodGames {
    static int min;
    static int max;
    static int try_;
    static int correctNumber;
    static boolean isPlaying = true;
    static String want_ToPlay;
    static Scanner my_Obj = new Scanner(System.in);


    public static void main(String[] args) {
        configure();
        playGames();

    }

    static void configure() {
        System.out.print("Enter the min value:");
        min = my_Obj.nextInt();

        do {
            System.out.print("Enter the max value:");
            max = my_Obj.nextInt();

            if (min > max) {
                System.out.println("The max value must be at least equal to the min value");
            }
        } while (min > max);

        do {
            System.out.print("Enter the maximum number of tries:");
            try_ = my_Obj.nextInt();

            if (try_ <= 0) {
                System.out.println("The maximum number of tries must be greater than 0");
            }
        } while (try_ <= 0);

    }

    static void genAnswer(int min, int max) {

        correctNumber = min + (int) (Math.random() * ((max - min) + 1));

    }

    static void playGame(int min, int max, int try_) {

        System.out.println("Welcome to a number guessing game!");

        genAnswer(min, max);
        int i;

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
            } else if (number > correctNumber) {
                System.out.println("Try a lower number!");
            } else {
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

    static void playGames() {
        while (isPlaying) {
            playGame(min, max, try_);
            System.out.print("Want to play again (y or Y): ");
            want_ToPlay = my_Obj.next();

            if (!want_ToPlay.equalsIgnoreCase("y")) {
                System.out.println("Thank you for playing our games. Bye!");
                isPlaying = false;
            }

        }

    }
}
