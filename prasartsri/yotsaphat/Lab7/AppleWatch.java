/*
 * This class represents an Apple Watch, which is a type of mobile device. 
 * It includes attributes such as color, price, and model name, 
 * and provides methods to set and retrieve these attributes. 
 * The class also determines if the device is a watch and provides a string representation of its details.
 *
 * Author: Yotsaphat Prasartsri
 * ID: 673040403-7
 * Sec: 1
 * Last Updated: January 25, 2025
 */

 package prasartsri.yotsaphat.Lab7;

 public class AppleWatch extends MobileDevice{
     private String modelName;
 
     /**
      * Sets the model name of the Apple Watch.
      * @param newModelNameStorage The new model name to be set.
      */
     public void setModelName(String newModelNameStorage) {
         modelName = newModelNameStorage;
     }
 
     /**
      * Gets the model name of the Apple Watch.
      * @return The current model name.
      */
     public String getModelName() {
         return modelName;
     }
 
     /**
      * Constructor to initialize an Apple Watch with specified attributes.
      * @param color The color of the Apple Watch.
      * @param price The price of the Apple Watch.
      * @param modelName The model name of the Apple Watch.
      */
     public AppleWatch(String color, Double price, String modelName) {
         this.color = color;
         this.price = price;
         this.modelName = modelName;
     }
 
     /**
      * Determines if this device is a watch.
      * @return true since this device is a watch.
      */
     public boolean isWatch() {
         return true;
     } 
 
     /**
      * Provides a string representation of the Apple Watch.
      * @return A string containing the details of the Apple Watch.
      */
     @Override
     public String toString() {
         return "AppleWatch " + "[color=" + color + ", " + "price=" + price + ", " + "modelName=" + modelName + " ]";
     }
 }
 