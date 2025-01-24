/*
 * This class implements the Comparator interface to define a custom sorting order for MobileDevice objects.
 * It compares MobileDevice objects based on multiple criteria: price, storage, color, and for specific device types like iPadAir and AppleWatch,
 * it further compares based on their respective attributes (storage for iPadAir and model name for AppleWatch).
 * The class also demonstrates how to sort an array of MobileDevice objects and print the sorted list.
 * 
 * Author: Yotsaphat Prasartsri 
 * ID : 673040403-7 
 * Sec : 1 
 * Last Updated: January 25, 2025
 */
package prasartsri.yotsaphat.Lab7;

import java.util.*;

/**
 * This class defines a custom comparator for sorting MobileDevice objects based on multiple criteria.
 * The criteria include price, storage (for IPadAir), model name (for AppleWatch), and color.
 */
public class SortMobileDevices implements Comparator<MobileDevice> {

    /**
     * Compares two MobileDevice objects based on multiple criteria: price, storage, model name (for specific device types), and color.
     * @param a The first MobileDevice to compare.
     * @param b The second MobileDevice to compare.
     * @return A negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
     */
    public int compare(MobileDevice a, MobileDevice b) {
        // Compare by price first
        int priceComparison = Double.compare(a.getPrice(), b.getPrice());
        if (priceComparison != 0) {
            return priceComparison;  // If prices are different, sort by price
        }

        // If prices are the same, compare by storage for IPadAir
        if (a instanceof IPadAir && b instanceof IPadAir) {
            int storageComparison = Double.compare(((IPadAir) a).getStorage(), ((IPadAir) b).getStorage());
            if (storageComparison != 0) {
                return storageComparison;  // If storage is different, sort by storage
            }
            // If storage is the same, compare by color
            return a.getColor().compareTo(b.getColor());
        }

        // If both are AppleWatch objects, compare by model name
        if (a instanceof AppleWatch && b instanceof AppleWatch) {
            int modelNameComparison = ((AppleWatch) a).getModelName().compareTo(((AppleWatch) b).getModelName());
            if (modelNameComparison != 0) {
                return modelNameComparison;  // If model names are different, sort by model name
            }
            // If model name is the same, compare by color
            return a.getColor().compareTo(b.getColor());
        }

        // If devices are of different types (e.g., one is IPadAir and the other is AppleWatch), compare by color
        return a.getColor().compareTo(b.getColor());  // Compare by color
    }

    /**
     * The main method to demonstrate sorting of MobileDevice objects.
     * It creates an array of MobileDevice objects, sorts them using the custom comparator, and prints the sorted list.
     * @param args Command line arguments (not used in this case).
     */
    public static void main(String[] args) {
        // Create an array of MobileDevice objects (both IPadAir and AppleWatch)
        MobileDevice[] devices = new MobileDevice[7];
        devices[0] = new IPadAir("Rose Gold", 19900.0, 64.0);
        devices[1] = new IPadAir("Silver", 24900.0, 256.0);
        devices[2] = new IPadAir("Space Gray", 19900.0, 128.0);
        devices[3] = new IPadAir("Silver", 19900.0, 64.0);
        devices[4] = new AppleWatch("Silver", 9400.0, "Apple Watch Nike SE GPS");
        devices[5] = new AppleWatch("Space Gray", 12900.0, "Apple Watch Ultra");
        devices[6] = new AppleWatch("Gold", 12900.0, "Apple Watch Series 7");

        // Sort the devices using the SortMobileDevices comparator
        Arrays.sort(devices, new SortMobileDevices());

        // Print the sorted list of devices
        System.out.println("Mobile devices sorted by multiple criteria:");
        for (MobileDevice device : devices) {
            System.out.println(device);
        }
    }
}
