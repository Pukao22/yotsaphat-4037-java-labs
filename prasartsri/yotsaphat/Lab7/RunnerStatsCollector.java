/*
 * This interface defines the contract for collecting and displaying running statistics and heart rates.
 * Any class implementing this interface must provide implementations for the methods displayRunningStats() and displayHeartRates().
 * 
 * Author: Yotsaphat Prasartsri 
 * ID : 673040403-7 
 * Sec : 1 
 * Last Updated: January 25, 2025
 */
package prasartsri.yotsaphat.Lab7;

public interface RunnerStatsCollector {
    
    /**
     * Displays the statistics related to running.
     * Implementing classes should define how to display running statistics such as distance, time, or pace.
     */
    public void displayRunningStats();

    /**
     * Displays the heart rates during a run.
     * Implementing classes should define how to display the heart rate data.
     */
    public void displayHeartRates();
}
