/*
 * This class demonstrates the usage of the MobileDevice class and its subclasses (IPadAir and AppleWatch).
 * It creates instances of IPadAir and AppleWatch, compares their prices, and displays whether a device is a watch or not.
 * The comparePrice method is used to compare the prices of two MobileDevice objects and prints the result.
 * 
 * Author: Yotsaphat Prasartsri 
 * ID : 673040403-7 
 * Sec : 1 
 * Last Updated: January 25, 2025
 */
package prasartsri.yotsaphat.Lab7;

public class TestMobileDevices {

    /**
     * The main method demonstrates the functionality of IPadAir and AppleWatch objects.
     * It creates instances of both, checks if an iPad is a watch, compares prices, and prints the results.
     * @param args Command line arguments (not used in this case).
     */
    public static void main(String[] args) {
        // Create instances of IPadAir and AppleWatch
        IPadAir iPadAir1 = new IPadAir("Rose Gold", 19900.0, 64.0);
        IPadAir iPadAir2 = new IPadAir("Silver", 24900.0, 256.0);
        AppleWatch appleWatch1 = new AppleWatch("Silver", 9400.0, "Apple Watch Nike SE GPS");

        // Print the chip name of the iPad Air class
        System.out.println("IPadAir chip name is " + IPadAir.getChipName());

        // Check if the second iPad is a watch and print the result
        if (iPadAir2.isWatch()) {
            System.out.println(iPadAir2 + " is a watch");
        } else {
            System.out.println(iPadAir2 + " is not a watch");
        }

        // Compare the prices of iPadAir1 and iPadAir2
        comparePrice(iPadAir1, iPadAir2);

        // Compare the prices of iPadAir1 and appleWatch1
        comparePrice(iPadAir1, appleWatch1);
    }

    /**
     * This method compares the prices of two MobileDevice objects and prints which one is cheaper.
     * @param device1 The first MobileDevice to compare.
     * @param device2 The second MobileDevice to compare.
     */
    public static void comparePrice(MobileDevice device1, MobileDevice device2) {
        // Compare the prices and print the result
        if (device1.getPrice() > device2.getPrice()) {
            System.out.println(device2 + " is cheaper than " + device1);
        } else {
            System.out.println(device1 + " is cheaper than " + device2);
        }
    }
}
