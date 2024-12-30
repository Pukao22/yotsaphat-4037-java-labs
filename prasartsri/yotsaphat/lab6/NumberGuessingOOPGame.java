package prasartsri.yotsaphat.lab6;

import java.util.Scanner;

/**
 * The NumberGuessingOOPGame class provides a user interface for playing the
 * Number Guessing game.
 * It allows users to configure the game with custom parameters such as the
 * range of numbers
 * and the maximum number of attempts, and provides an option to play multiple
 * rounds.
 * 
 * Purpose:
 * This class facilitates playing the number guessing game in an object-oriented
 * manner.
 * The user can configure the game settings and play multiple rounds of the
 * game.
 * After each round, the user is asked if they want to play again.
 * 
 * Main Features:
 * 1. Users can configure the game by specifying the min and max values and the
 * maximum number of tries.
 * 2. The game can be played multiple times, with results displayed after each
 * round.
 * 3. The game ends when the user chooses not to play again.
 * 
 * Author: Yotsaphat Prasartsri
 * ID: 673040403-7
 * Sec: 1
 * Last Updated: December 30, 2024
 */
public class NumberGuessingOOPGame {
    public static Scanner input = new Scanner(System.in);
    private GuessGame game;

    // Method to configure the game with user input
    public void configure() {
        System.out.print("Enter the min value: ");
        int min = input.nextInt();
        System.out.print("Enter the max value: ");
        int max = input.nextInt();
        System.out.print("Enter the maximum number of tries: ");
        int maxTries = input.nextInt();

        // Create a new game with the provided configuration
        this.game = new GuessGame(min, max, maxTries);
    }

    // Method to play multiple games in a loop
    public void playGames() {
        boolean playAgain;
        do {
            // Play a single game and display the result
            boolean result = this.game.playSingleGame();
            System.out.println(result ? "You win!" : "Better luck next time.");

            // Ask the user if they want to play again
            System.out.print("Do you want to play again? (y/n): ");
            playAgain = input.next().equalsIgnoreCase("y");

            // Reconfigure the game if the user wants to play again
            if (playAgain) {
                configure();
            }
        } while (playAgain); // Continue playing as long as the user answers 'y'

        // Thank the user for playing when they choose not to play again
        System.out.println("Thank you for playing the Number Guessing Game!");
    }

    // Main method to start the game
    public static void main(String[] args) {
        NumberGuessingOOPGame program = new NumberGuessingOOPGame();
        program.configure(); // Configure the game with user input
        program.playGames(); // Start playing the game
    }
}
