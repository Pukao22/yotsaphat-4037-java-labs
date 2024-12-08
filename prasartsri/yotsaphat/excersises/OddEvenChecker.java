package prasartsri.yotsaphat.excersises;

public class OddEvenChecker {
    public static void main(String[] args) {
        String selectNumber = args[0];
        int number = Integer.parseInt(selectNumber);

        if (number % 2 == 0) {
            System.out.println(number + " is even");
        } else {
            System.out.println(number + "is odd");
        }

    }

}
