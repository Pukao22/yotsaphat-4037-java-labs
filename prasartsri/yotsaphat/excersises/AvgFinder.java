package prasartsri.yotsaphat.excersises;

public class AvgFinder {public static void main(String[] args) {
    int a = 2, b = 3, c = 4;
    double i = 2.2, j = 3.3;
    System.out.println("The average of " + a + " "+ b + " = "+ avg(a, b));
    System.out.println("The average of " + a + " "+ b + " "+ c + " = "+ avg(a, b, c));
    System.out.println("The average of " + i + " "+ j + " = "+ avg(i, j));
}
static float avg(int a, int b) {
    float averagefloat = (a+b)/2.0f;
    return averagefloat;
    }
static float avg(int a, int b, int c) {
    float averagefloat2 = (a+b+c)/3.0f;
    return averagefloat2;
    }
static double avg(double i, double j) {
    double averagedouble = (i + j)/2;
    return averagedouble;
    }
    

}
