package prasartsri.yotsaphat.excersises;

public class KKUStudent {
    private String name;
    private double GPA;
    static private String uniname = "Khonkean university";
    static private int numStudent = 0;

    public KKUStudent(){
        this.numStudent++;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setGPA(double GPA){
        this.GPA = GPA;
    }
    public String getName(){
        return name;
    }
    public double getGPA(){
        return GPA;
    }
    public static int getNumStudents(){
        return numStudent;


    }
    public static String getUniName(){
        return uniname;
    



    
}}
