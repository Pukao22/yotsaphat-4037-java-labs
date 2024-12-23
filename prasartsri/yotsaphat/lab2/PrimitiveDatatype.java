package prasartsri.yotsaphat.lab2;

/*
 * The PrimitiveDatatype Program :
 * This program demonstrates the usage of primitive data types in Java.
 * It assigns values to variables of different data types, performs simple operations,
 * and displays the results on the console.
 * 
 * The outpu should be
 * Student ID : <studentNumber>
 *First Name: <firstName>
 *Byte Value: <myByte>
 *Short Value: <myShort>
 *Int Value: <myInt>
 *Long Value: <myLong>
 *Float Value: <myFloat>
 *Double Value: <myDouble>
 *Char Value: <myChar>
 *Boolean Value: <myBoolean>
 * 
 * Author: Yotsaphat Prasartsri 
 * ID :673040403-7 
 * Sec : 1 
 * Last Updated: December 1, 2024
 */

public class PrimitiveDataType { 
    public static void main(String[] args) {
        
            
        String studentNumber = "673040403-7";
        String firstName = "Yotsaphat";
        byte myByte = (byte)firstName.length();
        short myShort = (short)(myByte*21);
        int myInt = 404037;
        long myLong = 6730404037L;
        float myFloat = 0.09f;
        double myDouble = 0.4037;
        char myChar = 'Y';
        boolean myBoolean = true;

            

        System.out.println("Student ID :" + studentNumber);
        System.out.println("First Name: " + firstName);
        System.out.println("Byte Value: " + myByte);
        System.out.println("Short Value: " + myShort);
        System.out.println("Int Value: " + myInt);
        System.out.println("Long Value: " +myLong);
        System.out.println("Float Value: " +myFloat);
        System.out.println("Double Value: " +myDouble);
        System.out.println("Char Value: " +myChar);
        System.out.println("Boolean Value: " +myBoolean);
        
        

    
}
    
}
