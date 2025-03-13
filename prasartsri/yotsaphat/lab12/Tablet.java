package prasartsri.yotsaphat.lab12;

import prasartsri.yotsaphat.Lab7.MobileDevice;

public class Tablet extends MobileDevice {
    protected String name;
    protected String brand;
    Tablet(String name, String brand, double price){
        this.name = name;
        this.brand = brand;
        this.price = price;
    }
    Tablet(String name, String brand, double price, String color){
        this.name = name;
        this.brand = brand;
        this.price = price;
    }
    
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
     public void setName(String newName){
        name = newName;
    }
    public String getName(){
        return name;
    }
    public void setBrand(String newBrand){
        name = newBrand;
    }
    public String getBrand(){
        return brand;
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
     @Override
     public boolean isWatch() {
         return true;
     }
     public String toString() {
        // TODO Auto-generated method stub
        return "Tablet: "+name+" "+" ("+brand+") "+" "+price+" Baht";
    }
    
}
