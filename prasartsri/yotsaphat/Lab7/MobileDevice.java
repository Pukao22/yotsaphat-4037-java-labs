/*
 * This is an abstract class named MobileDevice, which represents a generic mobile device.
 * It defines common properties such as color and price, along with getter and setter methods for these properties.
 * The class also defines an abstract method isWatch(), which must be implemented by subclasses to determine if the device is a watch.
 * 
 * Author: Yotsaphat Prasartsri 
 * ID : 673040403-7 
 * Sec : 1 
 * Last Updated: January 25, 2025
 */
package prasartsri.yotsaphat.Lab7;

public abstract class MobileDevice {
    protected String color;  // The color of the mobile device
    protected double price;  // The price of the mobile device

    /**
     * Sets the color of the mobile device.
     * @param newColor The new color to be set.
     */
    public void setColor(String newColor) {
        color = newColor;
    }

    /**
     * Gets the color of the mobile device.
     * @return The current color of the device.
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the price of the mobile device.
     * @param newPrice The new price to be set.
     */
    public void setPrice(Double newPrice) {
        price = newPrice;
    }

    /**
     * Gets the price of the mobile device.
     * @return The current price of the device.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Abstract method to check if the device is a watch.
     * Subclasses must provide an implementation for this method.
     * @return true if the device is a watch, false otherwise.
     */
    public abstract boolean isWatch();
}
