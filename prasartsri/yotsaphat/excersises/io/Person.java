package prasartsri.yotsaphat.excersises.io;

import java.io.*;

public class Person implements Serializable {
    protected String name;
    public Person(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Person [name = "+name+ "]";
    }
    public static void writeToFile(Person person){
        try {
            FileOutputStream fos = new FileOutputStream("Person.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(person);
            oos.close();
            fos.close();
            System.out.println("Writng a Person object to a file");
        } catch (IOException e) {
            System.out.println("Error : "+e.getMessage()+e.getStackTrace()); 
           
        }

    }
    public static Person readFromFile(){
        Person readPerson = null;
        try {
            FileInputStream fis = new FileInputStream("Person.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            readPerson = (Person) ois.readObject();
            ois.close();
            fis.close();
            System.out.println("Reading a Person object to the file");
        } catch (IOException| ClassNotFoundException e) {
          System.out.println("Error : "+e.getMessage()+e.getStackTrace()); 
           
        }
        return readPerson;
    }
    public static void main(String[] args) {
        // Create a Person object
        Person person = new Person("Yotsaphat Prasartsri");
 
        // Display the person
        System.out.println(person);
        // Write the person to a file
        writeToFile(person);
 
        // Read the person from the file
        Person readPerson = readFromFile();
 
        // Display the person read from file
        System.out.println(readPerson);
 }
 
 }
 