package prasartsri.yotsaphat.lab6;

import java.util.Scanner;

/**
 * The GuessGameV3 class extends the GuessGameV2 class and adds the
 * functionality to record
 * game history, including storing multiple game records, tracking the number of
 * guesses,
 * and providing detailed game logs.
 * 
 * Purpose:
 * This version of the guessing game includes a feature to track multiple games,
 * store
 * game logs, and manage the game's history. The user can play multiple games,
 * and
 * the game results will be recorded and stored for later review.
 * 
 * Main Features:
 * 1. Multiple games can be played, with each game having a unique number.
 * 2. Records of each game, including guesses and results, are stored.
 * 3. Enhanced logging of game activities, such as guesses and results.
 * 4. Limits the number of games that can be recorded to a predefined constant.
 * 
 * Author: Yotsaphat Prasartsri
 * ID: 673040403-7
 * Sec: 1
 * Last Updated: December 30, 2024
 */
public class GuessGameV3 extends GuessGameV2 {
    private static final int MAX_GAMES = 100;
    private static GuessGameV3[] gameRecords = new GuessGameV3[MAX_GAMES];
    private static int recordIndex = 0;
    private static int gameCount = 1; // Static variable to track the game number
    private int gameNumber;

    private int[] guesses;
    private int guessCount;
    private boolean win;

    // Constructor to initialize the game with default values
    public GuessGameV3() {
        super();
        this.gameNumber = gameCount++; // Set the game number and increment the counter
        this.guessCount = 0;
        this.guesses = new int[getMaxTries()];
        this.win = false;
    }

    // Constructor to initialize the game with custom values for min, max, and
    // maxTries
    public GuessGameV3(int min, int max, int maxTries) {
        super(min, max, maxTries);
        this.gameNumber = gameCount++; // Set the game number and increment the counter
        this.guessCount = 0;
        this.guesses = new int[getMaxTries()];
        this.win = false;
    }

    // Configure the game settings, including resetting guesses and results
    public void configureGame(int min, int max, int maxTries) {
        super.configureGame(min, max, maxTries);
        this.guesses = new int[getMaxTries()];
        this.guessCount = 0;
        this.win = false;
    }

    // Play a single game and return whether the player won or lost
    public boolean playSingleGame() {
        int min = getMin();
        int max = getMax();
        int maxTries = getMaxTries();
        int attempts = 0;
        this.win = false;

        int answer = getAnswer();
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the Guessing Game!");

        // Start the guessing process
        for (attempts = 1; attempts <= maxTries; attempts++) {
            System.out.print("Enter an integer between " + min + " and " + max + ": ");
            int guess = scan.nextInt();

            // Check if the guess is within the valid range
            while (guess < min || guess > max) {
                System.out.println("The number must be between " + min + " and " + max);
                System.out.print("Enter an integer between " + min + " and " + max + ": ");
                guess = scan.nextInt();
            }

            guesses[guessCount++] = guess; // Store the guess

            // Check if the guess is correct
            if (guess == answer) {
                if (attempts > 1) {
                    System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts.");
                    this.win = true;
                    break;
                }
                if (attempts == 1) {
                    System.out.println("Congratulations! You've guessed the number in " + attempts + " attempt.");
                    this.win = true;
                    break;
                }
            } else if (guess < answer) {
                System.out.println("Try a higher number!");
            } else {
                System.out.println("Try a lower number!");
            }
        }

        // If the player didn't win, show the correct answer
        if (!this.win) {
            System.out.println("Sorry, you've used all your attempts. The correct answer was: " + answer);
        }

        return this.win;
    }

    // Get the game log for the current game, including guesses and results
    public String getGameLog() {
        StringBuilder log = new StringBuilder();
        log.append("Game ").append(gameNumber).append(": ").append(", ");
        log.append("Range: [").append(getMin()).append("-").append(getMax()).append("], ");
        log.append("Max Tries: ").append(getMaxTries()).append(", ");
        log.append("Attempts: ").append(guessCount).append(", ");
        log.append("Result: ").append(win ? "Win" : "Lose").append(", ");
        log.append("Guesses: ");
        for (int i = 0; i < guessCount; i++) {
            log.append(guesses[i]);
            if (i < guessCount - 1)
                log.append(", ");
        }
        return log.toString();
    }

    // Add a game record to the static array
    public static void addGameRecord(GuessGameV3 game) {
        if (recordIndex < MAX_GAMES) {
            gameRecords[recordIndex++] = game;
        } else {
            System.out.println("Maximum game records reached.");
        }
    }

    // Get all game records
    public static GuessGameV3[] getGameRecords() {
        return gameRecords;
    }

    // Get the current count of recorded games
    public static int getRecordCount() {
        return recordIndex;
    }
}
