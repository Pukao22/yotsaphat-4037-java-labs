package prasartsri.yotsaphat.lab6;

import java.util.Scanner;

/**
 * The NumberGuessingOOPGameV3 class is an extension of the Number Guessing Game
 * that provides more features.
 * It allows users to play the game, view complete or specific game records, and
 * provides options for repeating the game or quitting.
 * The game records each play, storing details such as guesses, results, and
 * game configuration.
 * 
 * Purpose:
 * This version extends the previous functionality by introducing a feature to
 * view game records after playing. Users can choose to view all records or a
 * specific game, play again, or quit.
 * 
 * Main Features:
 * 1. Users can configure the game with the min and max values, as well as the
 * maximum number of tries.
 * 2. After playing, users can choose to view complete game records or a
 * specific game record.
 * 3. Users can play another game, view records, or quit the game.
 * 
 * Author: Yotsaphat Prasartsri
 * ID: 673040403-7
 * Sec: 1
 * Last Updated: December 30, 2024
 */
public class NumberGuessingOOPGameV3 {
    private static Scanner input = new Scanner(System.in);

    // Method to configure the game based on user input
    public void configure() {
        System.out.print("Enter the min value: ");
        int min = input.nextInt();
        System.out.print("Enter the max value: ");
        int max = input.nextInt();
        System.out.print("Enter the maximum number of tries: ");
        int maxTries = input.nextInt();

        // Create a new game instance and play the game
        GuessGameV3 gameV3 = new GuessGameV3(min, max, maxTries);
        boolean result = gameV3.playSingleGame();

        // Add the game record to the list of records
        GuessGameV3.addGameRecord(gameV3);

        // Display the result of the game
        System.out.println(result ? "You Win!" : "Better luck next time.");
    }

    // Method to view game records
    public void viewRecords() {
        boolean viewAgain = true;
        while (viewAgain) {
            System.out.println("View:");
            System.out.println("1. Complete records");
            System.out.println("2. Specific game record");
            int choice = input.nextInt();

            // Display all game records
            if (choice == 1) {
                for (int i = 0; i < GuessGameV3.getRecordCount(); i++) {
                    System.out.println((i + 1) + ": " + GuessGameV3.getGameRecords()[i].getGameLog());
                }
            }
            // Display a specific game record
            else if (choice == 2) {
                System.out.print("Enter the game number to view: ");
                int gameNumber = input.nextInt();
                if (gameNumber >= 1 && gameNumber <= GuessGameV3.getRecordCount()) {
                    System.out.println(GuessGameV3.getGameRecords()[gameNumber - 1].getGameLog());
                } else {
                    System.out.println("Invalid game number.");
                }
            } else {
                System.out.println("Invalid choice.");
            }

            // After viewing records, ask the user if they want to play again or view
            // records
            System.out.println("Do you want to play again or view records?");
            System.out.println("1. Play another game");
            System.out.println("2. View game records");
            System.out.println("3. Quit");
            int choiceAfterView = input.nextInt();

            // Handle user choice after viewing records
            switch (choiceAfterView) {
                case 1:
                    viewAgain = false; // Exit the view records loop and continue to play another game
                    break;
                case 2:
                    break; // Stay in the view records loop to allow the user to view records again
                case 3:
                    viewAgain = false;
                    System.out.println("Thank you for playing Number Guessing Game V3!");
                    System.exit(0); // Exit the loop and quit the game
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Method to play the game and handle user decisions
    public void playGames() {
        boolean playAgain = true;
        while (playAgain) {
            configure(); // Configure and play the game

            // Ask the user what they want to do after playing
            System.out.println("Do you want to:");
            System.out.println("1. Play again");
            System.out.println("2. View game records");
            System.out.println("3. Quit");
            int choice = input.nextInt();

            // Handle user choice
            switch (choice) {
                case 1:
                    break; // Continue playing
                case 2:
                    viewRecords(); // View game records
                    break;
                case 3:
                    playAgain = false; // Exit the loop and quit the game
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        System.out.println("Thank you for playing Number Guessing Game V3!");
    }

    // Main method to start the game
    public static void main(String[] args) {
        NumberGuessingOOPGameV3 gameProgram = new NumberGuessingOOPGameV3();
        gameProgram.playGames(); // Start playing the game
    }
}
