package prasartsri.yotsaphat.excersises.exception;

public class Adder {
    public static void main(String[] args) {
        try {
            int a = Integer.parseInt(args[0]) ;
            int b = Integer.parseInt(args[1]) ;
            int c = a + b;
            System.out.println(a+" + "+ b+" = "+c);

        } catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println("Please provide two arguments");
           
        } catch (NumberFormatException ex) {
            System.err.println("Please provide two integers");}
        
        
    
}
    
}
