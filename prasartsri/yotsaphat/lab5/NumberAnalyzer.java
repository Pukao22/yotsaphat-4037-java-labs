/*
 * This program defines a class called NumberAnalyzer, which provides methods for analyzing arrays of integers. 
 * The `findMinMax` method returns the minimum and maximum values in the array. The `calculateRunningAverages` 
 * method computes the running averages of the array, updating the average after each element. The `isSorted` method 
 * checks whether the array is sorted in ascending order. The `main` method demonstrates the functionality by 
 * testing these methods on an example array and displaying the results, including the minimum and maximum values, 
 * running averages, and whether the arrays are sorted.
 * 
 * Author: Yotsaphat Prasartsri 
 * ID :673040403-7 
 * Sec : 1 
 * Last Updated: December 23, 2024
 */

package prasartsri.yotsaphat.lab5;

public class NumberAnalyzer {
    public static int[] findMinMax(int[] numbers) {
        int min = numbers[0];
        int max = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        return new int[] { min, max };
    }

    public static double[] calculateRunningAverages(int[] numbers) {
        double[] runnuningAvgs = new double[numbers.length];
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            runnuningAvgs[i] = (double) sum / (i + 1);
        }

        return runnuningAvgs;
    }

    public static boolean isSorted(int[] numbers) {

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] numbers = { 4, 2, 7, 1, 9 };
        int[] result = findMinMax(numbers);
        int[] arrofnumbers = { 1, 2, 3, 4, 5 };
        double[] averages = calculateRunningAverages(numbers);

        System.out.println("Minimum value: " + result[0]);
        System.out.println("Maximum value: " + result[1]);
        System.err.println("");

        

        System.out.println("Running Averages:");
        for (int i = 0; i < averages.length; i++) {
            System.out.println("Position " + i + ": " + String.format("%.2f", averages[i]));
        }
        System.err.println("");
        
        System.out.println("Testing if arrays are sorted:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("Number is sorted: " + isSorted(numbers));
        for (int num : arrofnumbers) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("Number is sorted: " + isSorted(arrofnumbers));
    }
}
