/*
 * This is an interface named HealthMonitorer, which is used to define a contract for displaying sleep hours.
 * Any class that implements this interface will need to provide the implementation for the displaySleepHours() method.
 * 
 * Author: Yotsaphat Prasartsri 
 * ID : 673040403-7 
 * Sec : 1 
 * Last Updated: January 25, 2025
 */
package prasartsri.yotsaphat.Lab7;

/**
 * This interface defines a contract for displaying sleep hours.
 * The implementing class should provide the implementation for the displaySleepHours() method to show the sleep hours.
 */
public interface HealthMonitorer {
    /**
     * This method is used to display the number of hours of sleep.
     */
    public void displaySleepHours();
}
