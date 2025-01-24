/*
 * This class represents the IPadAir, a subclass of MobileDevice.
 * It defines the properties specific to the iPad Air, such as storage, and the chip name (Apple M2).
 * The class also provides methods to get and set storage, as well as a method to check if the device is a watch (always returns false).
 * 
 * Author: Yotsaphat Prasartsri 
 * ID : 673040403-7 
 * Sec : 1 
 * Last Updated: January 25, 2025
 */
package prasartsri.yotsaphat.Lab7;

public class IPadAir extends MobileDevice {
    private double storage;  // The storage capacity of the iPad Air
    static private final String CHIP_NAME = "Apple M2";  // The chip used in the iPad Air

    /**
     * Sets the storage capacity of the iPad Air.
     * @param newStorage The new storage value to be set.
     */
    public void setStorage(Double newStorage) {
        storage = newStorage;
    }

    /**
     * Gets the storage capacity of the iPad Air.
     * @return The current storage value.
     */
    public double getStorage() {
        return storage;
    }

    /**
     * Gets the chip name used in the iPad Air.
     * @return The chip name (Apple M2).
     */
    public static String getChipName() {
        return CHIP_NAME;
    }

    /**
     * Constructor to create an instance of IPadAir with specified color, price, and storage.
     * @param color The color of the iPad Air.
     * @param price The price of the iPad Air.
     * @param storage The storage capacity of the iPad Air.
     */
    public IPadAir(String color, Double price, Double storage) {
        this.color = color;
        this.price = price;
        this.storage = storage;
    }

    /**
     * Returns whether the device is a watch. For IPadAir, this will always return false.
     * @return false, since an iPad Air is not a watch.
     */
    public boolean isWatch() {
        return false;
    }

    /**
     * Returns a string representation of the IPadAir object.
     * @return A string describing the IPadAir's color, price, storage, and chip name.
     */
    @Override
    public String toString() {
        return "IPadAir " + "[color=" + color + ", " + "price=" + price + ", " + "storage=" + storage + ", " + "chip=" + CHIP_NAME + " ]";
    }
}

