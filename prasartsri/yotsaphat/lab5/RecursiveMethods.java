/*
 * This class, RecursiveMethods, contains three recursive methods: 
 * 1. `sumOfDigits`: This method calculates the sum of digits of a given number. 
 *    For example, the sum of digits of 123 is 1 + 2 + 3 = 6.
 * 2. `reverseArray`: This method recursively reverses an array between specified start and end indices.
 * 3. `isPalindrome`: This method checks whether an array is a palindrome by comparing the elements 
 *    at the start and end indices recursively.
 * The `main` method demonstrates the usage of these methods by testing them on sample data, 
 * printing the results for sum of digits, reversed arrays, and palindrome checks.
 * 
 * Author: Yotsaphat Prasartsri 
 * ID :673040403-7 
 * Sec : 1 
 * Last Updated: December 23, 2024
 */
package prasartsri.yotsaphat.lab5;

public class RecursiveMethods {
    
    /**
 	* Recursively finds the sum of digits in a number.
 	* Example: For the number 123, the answer is 1+2+3 = 6
 	* @param number the input number
 	* @return sum of digits
 	*/


    public static int sumOfDigits(int number) {
        if (number == 0) {
            return 0;
        }
        return number % 10 + sumOfDigits(number / 10);
    }

    /**
 	* Recursively reverses an array between start and end indices.
 	* @param arr the array to reverse
 	* @param start starting index
 	* @param end ending index
 	*/

    public static void reverseArray(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int tempo = arr[start];
        arr[start] = arr[end];
        arr[end] = tempo;
        reverseArray(arr, start + 1, end - 1);
    }

    /**
 	* Recursively checks if an array is palindrome.
 	* @param arr the array to check
 	* @param start starting index
 	* @param end ending index
 	* @return true if palindrome, false otherwise
 	*/


    public static boolean isPalindrome(int[] arr, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (arr[start] != arr[end]) {
            return false;
        }
        return isPalindrome(arr, start + 1, end - 1);
    }

    public static void main(String[] args) {

        System.out.println("Sum of digits in 45: " + sumOfDigits(45));
        System.out.println("Sum of digits in 12345: " + sumOfDigits(12345));
        System.out.println("");


        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println("Original array: ");
        
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        reverseArray(arr, 0, arr.length - 1);
        System.out.println("Reversed array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("");

        int[] arr1 = { 1, 2, 3, 2, 1 };
        System.out.println("Testing palindrome");
        for (int num : arr1) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("Is palindrome: " + isPalindrome(arr1, 0, arr1.length - 1));
        System.out.println(" ");
        
        int[] arr2 = { 1, 2, 1, 2 };
        System.out.println("Testing palindrome");
        for (int num : arr2) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("Is palindrome: " + isPalindrome(arr2, 0, arr2.length - 1));
    }
}
