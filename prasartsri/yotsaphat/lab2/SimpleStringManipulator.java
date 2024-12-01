package prasartsri.yotsaphat.lab2;

/*
 * The SimpleStringManipulator Program:
 * This program takes two strings as command-line arguments, manipulates the first and last characters based on vowel rules,
 * and prints the result. If exactly two arguments are not provided:
 * - An error message is printed: "Error: invalid number of arguments. Please provide exactly two strings as arguments."
 * - The program terminates without further execution.
 * 
 * Functions:
 * 1. isVowel(char c): Checks if the given character is a vowel (a, e, i, o, u). 
 *    Returns true if it is a vowel, otherwise returns false.
 * 
 * 2. isnotVowel(char c): Checks if the given character is not a vowel. 
 *    Returns true if it is not a vowel, otherwise returns false.
 * 
 * Author: Yotsaphat Prasartsri
 * ID : 673040403-7
 * Sec : 1
 * Last Updated: December 1, 2024
 */

public class SimpleStringManipulator {public static void main(String[] args) {
    
    if (args.length != 2){
    System.err.print("Error: invalid number of argumemts. Please provide exactly two strings as arguments."); 
    return;}
        String firstString = args[0];
        String secondString = args[1];
        
        char first_char_firststring = firstString.charAt(0);
        char end_char_secondstring = secondString.charAt(secondString.length() - 1);

        

        if(isVowel(first_char_firststring))
            {firstString = firstString.substring(0,1).toUpperCase() + firstString.substring(1);}
        else
            {firstString = firstString.substring(0,1).toLowerCase() + firstString.substring(1);}

        if(isnotVowel(end_char_secondstring))
            {secondString = secondString.substring(0, secondString.length() - 1) + secondString.substring(secondString.length() - 1).toUpperCase() ;}
        else    
            {secondString = secondString.substring(0, secondString.length() - 1) + secondString.substring(secondString.length() - 1).toLowerCase() ;}
        System.out.println("First String: " + args[0]);
        System.out.println("Second String: " + args[1]);
        System.out.println("Resulting String: " + firstString + secondString);
    }
    private static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }
    private static boolean isnotVowel(char c) {
        return "AEIOUaeiou".indexOf(c) == -1;
    }
    
}
