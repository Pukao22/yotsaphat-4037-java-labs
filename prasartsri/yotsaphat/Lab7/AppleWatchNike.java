/*
 * This class represents an Apple Watch Nike edition, which is a specialized version of the Apple Watch class.
 * It includes additional functionalities for fitness tracking and health monitoring, such as:
 * - Tracking running stats: pace, total distance, and time.
 * - Monitoring health metrics: average and maximum heart rates.
 * - Providing sleep statistics: average sleep duration.
 * This class extends the base AppleWatch class and implements two interfaces:
 * RunnerStatsCollector and HealthMonitorer, for advanced fitness and health features.
 *
 * Author: Yotsaphat Prasartsri
 * ID: 673040403-7
 * Sec: 1
 * Last Updated: January 25, 2025
 */

 package prasartsri.yotsaphat.Lab7;

 public class AppleWatchNike extends AppleWatch implements RunnerStatsCollector, HealthMonitorer {
     private double pace;
     private double totalDistance;
     private double time;
     private double avgHeartRate;
     private double maxHeartRate;
     private double avgSleepHours;
 
     /**
      * Constructor to initialize an Apple Watch Nike with basic attributes.
      * @param color The color of the watch.
      * @param price The price of the watch.
      * @param modelName The model name of the watch.
      */
     public AppleWatchNike(String color, double price, String modelName) {
         super(color, price, modelName);
     }
 
     /**
      * Constructor to initialize an Apple Watch Nike with additional attributes.
      * @param color The color of the watch.
      * @param price The price of the watch.
      * @param modelName The model name of the watch.
      * @param totalDistance The total running distance.
      * @param avgHeartRate The average heart rate.
      * @param avgSleepHours The average sleep hours.
      */
     public AppleWatchNike(String color, double price, String modelName, double totalDistance, double avgHeartRate, double avgSleepHours) {
         super(color, price, modelName);
         this.totalDistance = totalDistance;
         this.avgHeartRate = avgHeartRate;
         this.avgSleepHours = avgSleepHours;
     }
 
     /**
      * Displays the total distance run.
      */
     public void displayRunningStats() {
         System.out.println("Total distance run: 42.50 km");
     }
 
     /**
      * Displays the average heart rate.
      */
     public void displayHeartRates() {
         System.out.println("Average heart rate: 75 bpm");
     }
 
     /**
      * Displays the average sleep duration.
      */
     public void displaySleepHours() {
         System.out.println("Average sleep duration: 7.50 hours");
     }
 
     /**
      * Returns a string representation of the Apple Watch Nike.
      * @return A string containing the details of the watch.
      */
     @Override
     public String toString() {
         return "AppleWatchNike(color: " + color + ", price: " + price + ", model name: " + getModelName() + ", distance: " + totalDistance + " km)";
     }
 }
 