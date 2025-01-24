/*
 * This class implements the Comparator interface to define a custom sorting order for MobileDevice objects based solely on price.
 * The class demonstrates how to sort an array of MobileDevice objects by price in ascending order.
 * 
 * Author: Yotsaphat Prasartsri 
 * ID : 673040403-7 
 * Sec : 1 
 * Last Updated: January 25, 2025
 */
package prasartsri.yotsaphat.Lab7;

import java.util.*;

/**
 * This class defines a custom comparator for sorting MobileDevice objects based on price.
 * It compares MobileDevice objects by their price attribute.
 */
public class SortMobileDevicesbyPrice implements Comparator<MobileDevice> {

    /**
     * Compares two MobileDevice objects based on their price.
     * @param a The first MobileDevice to compare.
     * @param b The second MobileDevice to compare.
     * @return A negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
     */
    public int compare(MobileDevice a, MobileDevice b) {
        return Double.compare(a.price, b.price);  // Compare devices based on price
    }

    /**
     * The main method demonstrates sorting of MobileDevice objects by price.
     * It creates an array of MobileDevice objects, sorts them using the custom comparator, and prints the sorted list.
     * @param args Command line arguments (not used in this case).
     */
    public static void main(String[] args) {
        // Create an array of MobileDevice objects (both IPadAir and AppleWatch)
        MobileDevice[] devices = new MobileDevice[4];
        devices[0] = new IPadAir("Rose Gold", 19900.0, 64.0);
        devices[1] = new IPadAir("Silver", 24900.0, 256.0);
        devices[2] = new AppleWatch("Silver", 9400.0, "Apple Watch SE GPS");
        devices[3] = new AppleWatch("Space Gray", 12900.0, "Apple Watch Ultra");

        // Sort the devices using the SortMobileDevicesbyPrice comparator
        Arrays.sort(devices, new SortMobileDevicesbyPrice());

        // Print the sorted list of devices by price
        System.out.println("Mobile devices sorted by price:");
        for (MobileDevice device : devices) {
            System.out.println(device);
        }
    }
}
