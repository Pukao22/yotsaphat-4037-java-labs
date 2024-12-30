package prasartsri.yotsaphat.lab6;

import java.util.Scanner;

/**
 * The NumberGuessingOOPGameV2 class provides an enhanced user interface for
 * playing the Number Guessing game.
 * It allows users to configure the game with custom parameters such as the
 * range of numbers and the maximum number of attempts,
 * and provides an option to play multiple rounds with validation for input.
 * 
 * Purpose:
 * This class enhances the original NumberGuessingOOPGame by using the updated
 * GuessGameV2 class.
 * It offers a more user-friendly experience with input validation and allows
 * multiple rounds of gameplay.
 * 
 * Main Features:
 * 1. Users can configure the game by specifying the min and max values and the
 * maximum number of tries.
 * 2. The game can be played multiple times, with results displayed after each
 * round.
 * 3. After each game, the user is asked if they want to play again, with input
 * validation for 'y' or 'n'.
 * 4. The game ends when the user chooses not to play again.
 * 
 * Author: Yotsaphat Prasartsri
 * ID: 673040403-7
 * Sec: 1
 * Last Updated: December 30, 2024
 */
public class NumberGuessingOOPGameV2 {

    public static Scanner input = new Scanner(System.in);
    private GuessGameV2 gameV2;

    // Method to configure the game with user input
    public void configure() {
        // scan min
        System.out.print("Enter the min value: ");
        int min = input.nextInt();

        // scan max
        System.out.print("Enter the max value: ");
        int max = input.nextInt();

        // make new obj. and configure game with min and max values
        this.gameV2 = new GuessGameV2(min, max, 1);
        this.gameV2.configureGame(min, max, 1);

        // scan maximum tries
        System.out.print("Enter the maximum number of tries: ");
        int maxTries = input.nextInt();

        // configure the game with the specified max tries
        this.gameV2.configureGame(min, max, maxTries);

        // display the game configuration
        System.out.println(this.gameV2.toString());
    }

    // Method to play multiple games in a loop
    public void playGames() {
        boolean playAgain = true;
        do {
            // Play a single game and display the result
            boolean result = this.gameV2.playSingleGame();
            System.out.println(result ? "You Win!" : "Better luck next time.");

            // Ask if the user wants to play again
            boolean ifPlayAgain = true;
            while (ifPlayAgain) {
                System.out.print("Want to play again (y/n): ");
                String want = input.next();

                // Check if the input is 'y' or 'n'
                if (want.equalsIgnoreCase("Y")) {
                    playAgain = true;
                    configure(); // Reconfigure the game for the next round
                    break;
                } else if (want.equalsIgnoreCase("N")) {
                    playAgain = false;
                    break;
                } else {
                    System.err.println("Please type only y and n."); // Error message for invalid input
                }
            }
        } while (playAgain); // Continue playing as long as the user answers 'y'

        // Thank the user for playing when they choose not to play again
        System.out.println("Thank you for playing the Number Guessing Game V2!");
    }

    // Main method to start the game
    public static void main(String[] args) {
        NumberGuessingOOPGameV2 program = new NumberGuessingOOPGameV2();
        program.configure(); // Configure the game with user input
        program.playGames(); // Start playing the game
    }
}
