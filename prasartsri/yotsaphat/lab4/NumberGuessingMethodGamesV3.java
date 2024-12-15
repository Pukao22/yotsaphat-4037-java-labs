/** 
 * This is an advanced version of NumberGuessingMethodGamesV2, 
 * designed to include additional functionalities and statistical tracking.
 * The program reinforces concepts of loops, conditionals, arrays, and basic statistics in Java.
 * 
 * Features of NumberGuessingMethodGamesV3:
 * 
 * - **Inheritance of Core Gameplay**: 
 *   Includes all features from NumberGuessingMethodGamesV2.
 * 
 * - **Post-Game Options**: 
 *   After the game ends (either by correct guess or running out of tries), the player can:
 *   - Enter 'a' to list all guesses made during the game.
 *   - Enter 'g' to view a specific guess by its number.
 *   - Press any other key to exit.
 * 
 * - **New Feature: Game Log**: 
 *   After each game, the program outputs the game log, which includes:
 *   - Answer: the correct number.
 *   - Number of guesses: the total number of guesses the player made.
 *   - Win/Loss status: whether the player won or lost the game.
 *   Format:
 *   - Game log: Answer: <answer>, Guesses: <numTries>, Win: <The result (true/false)>
 * 
 * - **Replay Option**: 
 *   After the game ends, the player can choose to play again by pressing 'Y' or 'y'. 
 *   The game will restart with the same min/max range but with a new number.
 * 
 * - **New Feature: Statistical Information**: 
 *   Upon exit, the program displays the following stati
 * 
 * Author: Yotsaphat Prasartsri 
 * ID :673040403-7 
 * Sec : 1 
 * Last Updated: December 15, 2024
 */

package prasartsri.yotsaphat.lab4;


import java.util.ArrayList;
import java.util.Scanner;

public class NumberGuessingMethodGamesV3 {
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
    static boolean youarewin;
    static int totalGuesses;
    static int totalOfGames = 1;
    static int winTotal = 0;
    static int sumtries = 0;
    static int totalgamewin = 0;
    static ArrayList<Integer> guessesList = new ArrayList<>();
    static int highscore = Integer.MAX_VALUE;

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
                    totalGuesses = i;
                    youarewin = true;
                    winTotal += 1;
                    sumtries += totalGuesses;
                    totalgamewin += 1;
                } else {
                    System.out.println("You have tried " + i + " times.");
                    totalGuesses = i;
                    youarewin = true;
                    winTotal += 1;
                    sumtries += totalGuesses;
                    totalgamewin += 1;
                }
                if (totalGuesses < highscore) {
                    highscore = totalGuesses;
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
                youarewin = false;
                totalGuesses = try_;
                sumtries += totalGuesses;
            }
            if (try_ > 1) {
                System.out.println("You have tried " + try_ + " times. You ran out of guesses");
                System.out.println("The answer is " + correctNumber);
                youarewin = false;
                totalGuesses = try_;
            }

        }

    }

    static void playGames() {
        while (isPlaying) {
            isDisplaying = true;
            playGame(min, max, try_);
            displayGuesesLoop();
            displayGameLog();
            System.out.print("Want to play again (y or Y): ");
            want_ToPlay = my_Obj.next();

            if (!want_ToPlay.equalsIgnoreCase("y")) {
                System.out.println("Thank you for playing our games. Bye!");
                isPlaying = false;
                displayAllGamesStats();
            }
            if (want_ToPlay.equalsIgnoreCase("y")) {
                totalOfGames += 1;
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

        } else if (display_Choice.equals("g")) {
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

    static void displayGameLog() {
        if (youarewin == true) {
            System.out.println("GameLog:Answer: " + correctNumber + ", Guesses: " + totalGuesses + ", Win: true");
        }
        if (youarewin == false) {
            System.out.println("GameLog:Answer: " + correctNumber + ", Guesses: " + totalGuesses + ", Win: false");
        }

    }

    static void displayAllGamesStats() {
        float winRate = (float) ((winTotal / totalOfGames) * 100.0f);
        int avgNumOfGuess = (int) (sumtries / totalOfGames);

        int highscoreCalculated = Integer.MAX_VALUE;
        for (int guesses : guessesList) {
            if (guesses < highscoreCalculated) {
                highscoreCalculated = guesses;
            }
        }

        System.out.println("===== All Games Stats =====");
        System.out.println("Total games played: " + totalOfGames);
        System.out.println("Total games win: " + totalgamewin);
        System.out.println("Win ratio: " + winRate + "%");
        System.out.println("Average number of guesses per game: " + avgNumOfGuess);
        System.out.println("High score (the lowest number of guesses): " + highscore);

    }

}
