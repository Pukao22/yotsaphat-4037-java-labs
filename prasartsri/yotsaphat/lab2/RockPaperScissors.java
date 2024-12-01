package prasartsri.yotsaphat.lab2;

/*
 *  The RockPaperScissors Program simulates a game between two players. It validates 
 * two command-line arguments and checks if they match valid choices ('ROCK', 'PAPER', 'SCISSORS'). 
 * Then, it compares the choices and prints the result (winner or tie).
 * 
 * The output will display:
 * Player 1 chooses:  <player1choice>
 * Player 2 chooses:  <player2choice>
 * The winner of the game or if it's a tie
 * 
 * Author: Yotsaphat Prasartsri
 * ID : 673040403-7
 * Sec : 1
 * Last Updated: December 1, 2024
 */

public class RockPaperScissors {

    public enum Game {
        ROCK, PAPER, SCISSORS;
    }

    public static void main(String[] args) {
        
        if (args.length != 2) {
            System.err.println("Error: invalid number of arguments. Please provide exactly two arguments.");
            return;
        }

        String player1choice = args[0], player2choice = args[1];

        
        String testplayer1choice = player1choice.toUpperCase(), testplayer2choice = player2choice.toUpperCase();;
        

        Game enumplayer1, enumplayer2;

        
        try {
            enumplayer1 = Game.valueOf(testplayer1choice);
            enumplayer2 = Game.valueOf(testplayer2choice);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: invalid choice(s). Valid choices are 'rock', 'paper', or 'scissors'.");
            return;
        }

        
        System.out.println("Player 1 chooses: " + player1choice);
        System.out.println("Player 2 chooses: " + player2choice);

        
        if (enumplayer1 == enumplayer2) {
            System.out.println("It's a tie!");
        } else if ((enumplayer1 == Game.ROCK && enumplayer2 == Game.SCISSORS) ||
                   (enumplayer1 == Game.PAPER && enumplayer2 == Game.ROCK) ||
                   (enumplayer1 == Game.SCISSORS && enumplayer2 == Game.PAPER)) {
            System.out.println("Player 1 wins!");
        } else {
            System.out.println("Player 2 wins!");
        }
    }
}
