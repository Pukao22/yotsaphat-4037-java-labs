/** 
 * This program is an advanced iteration of NumberGuessingMethodGames, 
 * designed with enhanced features to elevate player engagement and interaction.
 * 
 * Features of GuessNumberGamesV2:
 * 
 * - **Inheritance of Core Gameplay**: 
 *   NumberGuessingMethodGamesV2 integrates all the features of the original NumberGuessingMethodGames.
 * 
 * - **Post-Game Guess Review**: 
 *   Upon the game's conclusion (regardless of whether the player guesses correctly or depletes all attempts), 
 *   the player is provided with various options to review their guesses.
 * 
 * - **'a' Option**: 
 *   Selecting this option displays a comprehensive list of all guesses made by the player throughout the game in the following format:
 *   - Guess 1: the guess number at the 1st time 
 *   - Guess 2: the guess number at the 2nd time 
 *   - Guess <numTries>: the guess number at the <numTries> time
 * 
 * - **'g' Option**: 
 *   This option allows the player to choose and view a specific guess <n>. The output is shown in the following format:
 *   - Guess <n>: the guess number at the <n> time
 * 
 * - **Exit Feature**: 
 *   Any other keypress will exit the program.
 * 
 * - **Continuous Gameplay**: 
 *   After the player finishes reviewing their guesses, the game reverts to the standard gameplay as in NumberGuessingMethodGames, 
 *   allowing for a new round of play.
 * 
 * Author: Yotsaphat Prasartsri 
 * ID :673040403-7 
 * Sec : 1 
 * Last Updated: December 15, 2024
 */

package prasartsri.yotsaphat.lab4;

import java.util.Scanner;

public class NumberGuessingMethodGamesV2 {
    static int min;
    static int number;
    static int max;
    static int try_;
    static int correctNumber;
    static boolean isPlaying = true;
    static String want_ToPlay;
    static Scanner my_Obj = new Scanner(System.in);
    static int[] guess = new int[10];
    static String display_Choice;
    static int theGuessnumber;
    static boolean isDisplaying = true;

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

            guess[i - 1] = number;

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

            isDisplaying = true; 
            playGame(min, max, try_);
            displayGuesesLoop();
            System.out.print("Want to play again (y or Y): ");
            want_ToPlay = my_Obj.next();

            if (!want_ToPlay.equalsIgnoreCase("y")) {
                System.out.println("Thank you for playing our games. Bye!");
                isPlaying = false;
            }

        }

    }

    static void displayGuesses() {
        System.out.print("Enter 'a' to display guesses, 'g' for a specific guess, or any other key to quit:");
        display_Choice = my_Obj.next();
        if (display_Choice.equals("a")) {
            for (int i = 0; i < guess.length; i++) {
                if (guess[i] != 0) {
                    System.out.println("Guess " + (i + 1) + ": " + guess[i]);
                    isDisplaying = true;
                }
            }

        }
        else if (display_Choice.equals("g")) {
            System.out.print("Enter the guess number:");
            theGuessnumber = my_Obj.nextInt();
            System.out.println("Guess" + theGuessnumber + ":" + guess[theGuessnumber - 1]);

        } else {
            isDisplaying = false;
        }

    }

    static void displayGuesesLoop() {
        while (isDisplaying) {
            displayGuesses();
            
        }

    }

}
