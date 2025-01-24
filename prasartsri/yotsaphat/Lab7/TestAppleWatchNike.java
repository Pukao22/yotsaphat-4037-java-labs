/*
 * This class demonstrates the usage of the AppleWatchNike class, which is a subclass of AppleWatch.
 * It creates an instance of AppleWatchNike, displays its details, and calls methods to display running statistics, heart rates, and sleep hours.
 * It also demonstrates polymorphism by assigning the AppleWatchNike instance to a reference of type AppleWatch.
 * 
 * Author: Yotsaphat Prasartsri 
 * ID : 673040403-7 
 * Sec : 1 
 * Last Updated: January 25, 2025
 */
package prasartsri.yotsaphat.Lab7;

public class TestAppleWatchNike {

    /**
     * The main method demonstrates the functionality of the AppleWatchNike class.
     * It creates an instance of AppleWatchNike, calls various methods, and prints the details.
     * @param args Command line arguments (not used in this case).
     */
    public static void main(String[] args) {
        // Create an instance of AppleWatchNike with specific attributes
        AppleWatchNike nikeWatch = new AppleWatchNike("Space Gray", 12900.0, "Nike SE GPS", 72.5, 75, 7.5);

        // Print the details of the Nike Watch
        System.out.println(nikeWatch);

        // Call methods to display running statistics, heart rates, and sleep hours
        nikeWatch.displayRunningStats();
        nikeWatch.displayHeartRates();
        nikeWatch.displaySleepHours();

        // Check and print if the device is a watch
        System.out.println("Is this a watch? " + nikeWatch.isWatch());

        // Demonstrate polymorphism by assigning AppleWatchNike to an AppleWatch reference
        AppleWatch baseWatch = nikeWatch;
        System.out.println("Through base reference: " + baseWatch);
    }
}

