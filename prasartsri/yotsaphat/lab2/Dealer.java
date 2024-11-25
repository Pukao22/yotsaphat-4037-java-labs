/** The Dealer Program: 
 *This program accepts three arguments then processes 
 *and displays dealer information 
 * The output should be 
 * Dealer's name : <dealer name> 
 * Number of clients : <num_clients> 
 * Gender : <dealer_gender>  
 * Author: Ytsaphat Prasartsri 
 * ID :673040403-7 
 * Sec : 1 
*/ 
package prasartsri.yotsaphat.lab2;
public class Dealer {
    public static void main(String[] args) {
        if (args.length != 3){
            System.err.print("Error: invalid number of argumemts. Please provide exactly three arguments"); 
            return;}
                String dealer_name = args[0];
                String num_clients = args[1];
                String dealer_gender = args[2];

                System.out.println("Dealer's name:" + dealer_name);
                System.out.println("Number of clients:" + num_clients );
                System.out.println("Gender:" + dealer_gender);
            }
        }
    

    


