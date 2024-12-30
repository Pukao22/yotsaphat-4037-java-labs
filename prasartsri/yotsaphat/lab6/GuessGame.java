package prasartsri.yotsaphat.lab6;

import java.util.Scanner;

/**
 * The GuessGame class represents a simple number guessing game.
 * 
 * Purpose:
 * This game allows the player to guess a randomly generated number within a
 * specified range.
 * The player has a limited number of attempts (maxTries) to guess the correct
 * number.
 * The game provides hints whether the player's guess is too high or too low.
 * The game ends when the player guesses the correct number or exhausts all
 * attempts.
 * 
 * Main Features:
 * 1. Configurable range for the random number (min and max).
 * 2. Configurable number of attempts (maxTries).
 * 3. Random number generation within the specified range.
 * 4. Game flow that allows the player to input guesses and receive feedback.
 * 5. The game ends when the player guesses the number correctly or uses up all
 * attempts.
 * 
 * Author: Yotsaphat Prasartsri
 * ID: 673040403-7
 * Sec: 1
 * Last Updated: December 30, 2024
 */
public class GuessGame {
    private int min; // Minimum value for the range
    private int max; // Maximum value for the range
    private int maxTries; // Maximum number of attempts allowed
    private int answer; // The correct answer that the user needs to guess
    private int attempt; // Number of attempts made by the user

    static Scanner my_Obj = new Scanner(System.in); // Scanner object to take user input

    // Default constructor to initialize the game with default values
    public GuessGame() {
        min = 1;
        max = 100;
        maxTries = 10;
        answer = 0;
        attempt = 0;
    }

    // Constructor to initialize the game with custom values for min, max, and
    // maxTries
    public GuessGame(int min, int max, int maxTries) {
        this.min = min;
        this.max = max;
        this.maxTries = maxTries;
        this.answer = 0;
        this.attempt = 0;
    }

    // Setter methods to set the values for min, max, and maxTries
    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setMaxTries(int maxTries) {
        this.maxTries = maxTries;
    }

    // Getter methods to retrieve the values for min, max, maxTries, and the answer
    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getMaxTries() {
        return maxTries;
    }

    public int getAnswer() {
        generateAnswer();
        return answer;
    }

    // Method to configure the game with custom values
    public void configureGame(int min, int max, int maxTries) {
        setMin(min); // Set the minimum value
        setMax(max); // Set the maximum value
        setMaxTries(maxTries); // Set the maximum number of tries
    }

    // Method to generate a random answer within the given range (min to max)
    public void generateAnswer() {
        this.answer = min + (int) (Math.random() * (max - min + 1)); // Random number between min and max
    }

    // Method to play a single game
    public boolean playSingleGame() {
        generateAnswer(); // Generate the correct answer
        System.out.println("Welcome to the number guessing game!"); // Display welcome message

        // Loop for the maximum number of attempts
        for (int attempt = 0; attempt < maxTries; attempt++) {
            System.out.print("Enter an integer between " + min + " and " + max + ": "); // Prompt user for input
            int guess = my_Obj.nextInt(); // Take user input

            // Check if the guess is within the valid range
            if (guess < min || guess > max) {
                System.out.println("The number must be between " + min + " and " + max); // Inform the user if the guess
                                                                                         // is out of range
                continue;
            }

            // Check if the guess is correct
            if (guess == answer) {
                System.out.println("Congratulations! You've guessed the correct number."); // Success message
                System.out.println("You guessed it in " + (attempt + 1) + " attempts."); // Display number of attempts
                                                                                         // taken
                return true; // Return true if the user guesses correctly
            } else if (guess > answer) {
                System.out.println("Try a lower number!"); // Hint if the guess is too high
            } else {
                System.out.println("Try a higher number!"); // Hint if the guess is too low
            }
        }

        // If the user runs out of attempts, reveal the correct answer
        System.out.println("Sorry, you've used all your attempts. The correct answer was: " + answer);
        return false; // Return false if the user fails to guess the correct answer
    }
}
