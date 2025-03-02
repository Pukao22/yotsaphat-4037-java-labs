package prasartsri.yotsaphat.excersises.io;

import java.io.*;

public class WriteReadFile {
    public static void main(String[] args) {
        Writefile(args);
        Readfile(args);

    }

    public static void Writefile(String[] args) {
        try {
            String filename = args[0];
            String name = "ยศภัทร ปราสาทศรี";
            String id = "673040403-7 ";
            PrintWriter p = new PrintWriter(filename);
            p.print(id);
            p.print(name);
            System.out.println("Writing "+ id +name+" to file "+ filename);
            p.close();
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println("Provide filename in the program argrument");
        } catch (IOException ex) {
            System.err.println("Error in writing file");
            ex.printStackTrace(System.err);
        }
    }

    public static void Readfile(String[] args) {
        try {
            String filename = args[0];
            FileReader fr = new FileReader(filename);
            BufferedReader r = new BufferedReader(fr);
            System.out.println("The read data from the file is");
            String line;
            while ((line = r.readLine()) != null) {
                System.out.println(line);
            }
            r.close();
            fr.close();
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println("Provide file name in the program argument");
        } catch (IOException ex) {
            System.err.println("Error in reading file");
            ex.printStackTrace(System.err);
        }
    }
}
