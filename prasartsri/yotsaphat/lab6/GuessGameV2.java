package prasartsri.yotsaphat.lab6;

/**
 * The GuessGameV2 class extends the GuessGame class and provides enhanced
 * functionality.
 * 
 * Purpose:
 * This version of the guessing game includes error handling for invalid inputs,
 * such as ensuring
 * that the minimum value is less than or equal to the maximum value, and that
 * the maximum number
 * of attempts is greater than 0. Additionally, the game play is enhanced to
 * provide clearer messages
 * and error handling.
 * 
 * Main Features:
 * 1. Customizable range for the random number (min and max).
 * 2. Error handling for invalid input.
 * 3. Random number generation within the specified range.
 * 4. Enhanced game flow with better feedback on user guesses.
 * 5. Ends when the user guesses correctly or exhausts all attempts.
 * 
 * Author: Yotsaphat Prasartsri
 * ID: 673040403-7
 * Sec: 1
 * Last Updated: December 30, 2024
 */
public class GuessGameV2 extends GuessGame {

    // Constructor to initialize the game with default values by calling the parent
    // constructor
    public GuessGameV2() {
        super(); // Call constructor from parent class
    }

    // Constructor to initialize the game with custom values for min, max, and
    // maxTries
    public GuessGameV2(int min, int max, int maxTries) {
        super(min, max, maxTries); // Call constructor from parent class and set values
    }

    // Override configureGame method to add error handling for invalid inputs
    @Override
    public void configureGame(int min, int max, int maxTries) {
        // Fix error if min is greater than max
        do {
            if (min > max) {
                System.out.println("Invalid input: Max must be greater than or equal to min.");
                System.out.print("Enter the min value: ");
                min = my_Obj.nextInt();
                System.out.print("Enter the max value: ");
                max = my_Obj.nextInt();
            }
        } while (min > max);

        // Fix error if maxTries is less than or equal to 0
        do {
            if (maxTries <= 0) {
                System.out.println("Invalid input: MaxTries must be greater than 0.");
                System.out.print("Enter the maximum number of tries: ");
                maxTries = my_Obj.nextInt();
            }
        } while (maxTries <= 0);

        // Update the game configuration with the valid values
        setMin(min);
        setMax(max);
        setMaxTries(maxTries);
    }

    // Override playSingleGame method to add enhanced gameplay features
    @Override
    public boolean playSingleGame() {
        // Get the values from the parent class (using getter methods)
        int min = getMin();
        int max = getMax();
        int maxTries = getMaxTries();
        int attempts = 0;

        // Variable to track if the player wins
        boolean win = false;

        // Get the answer from the parent class
        int answer = getAnswer();

        // Output before the game starts
        System.out.println("Welcome to a number Guessing Game V2!");

        // Start the guessing process
        for (attempts = 1; attempts <= maxTries; attempts++) {
            // Output for guessing number
            System.out.print("Enter an integer between " + min + " and " + max + ": ");
            int guess = my_Obj.nextInt(); // Read user input

            // Check for invalid input (out of range)
            while (guess > max || guess < min) {
                System.out.println("Invalid input: guess must be between " + min + " and " + max);
                // Ask the user for input again
                System.out.print("Enter an integer between " + min + " and " + max + ": ");
                guess = my_Obj.nextInt();
            }

            // Check the conditions of the guess
            if (guess == answer) {
                // Win condition
                System.out.print("Congratulations! ");
                if (attempts == 1) { // One try
                    System.out.println("You've guessed the number in " + attempts + " attempt.");
                } else { // Multiple attempts
                    System.out.println("You've guessed the number in " + attempts + " attempts.");
                }
                win = true; // Set the win flag
                break;

            } else if (guess > answer) {
                System.out.println("Try a lower number!");

            } else if (guess < answer) {
                System.out.println("Try a higher number!");

            } else {
                System.err.println("Error: You should enter an integer.");
            }
        }

        // Lose condition if the user runs out of attempts
        if (!win) {
            System.out.print("Sorry, you've used all your attempts. ");
            System.out.println("The correct answer was: " + answer);
        }

        // End of the game
        return win;
    }

    // Override toString method to return a string representation of the game
    // configuration
    @Override
    public String toString() {
        return "Game Configuration: [Min: " + getMin() + ", Max: " + getMax() + ", Max Tries: " + getMaxTries()
                + ", Attempts: " + "0" + "]";
    }
}
