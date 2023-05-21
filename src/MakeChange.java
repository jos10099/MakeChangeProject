// I used the decimal format to take off the extra decimal positions see line 113//
import java.util.Scanner;
import java.text.DecimalFormat;

public class MakeChange {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to 'if Codes for Cheap!'");
        // prompts the user for the asking price//

        System.out.println("Please enter the price of your item: ");
        double itemPrice = sc.nextDouble();
        //The user is then prompted asking how much money was tendered by the customer.//

        System.out.println("Please enter the amount you are paying: ");
        double amountPaid = sc.nextDouble();

        double change = amountPaid - itemPrice;

        if (amountPaid < itemPrice) {
//           an appropriate message if the customer provided too little money or the exact amount.
        	
        	double remaining = itemPrice - amountPaid;
            while (remaining > 0) {
                System.out.println("This is not a charity, please pay the remaining: $" + formatCurrency(remaining));
            
                
                double payment = sc.nextDouble();
                //If the amount tendered is more than the cost of the item, display the number of bills and coins that should be given to the customer.//
                
                if (payment > remaining) {
                    System.out.println("Payment amount is greater than the remaining owed. Returning change of $" + formatCurrency(payment - remaining));
                    calculateChange(change);
               
                    break;
                }
                remaining -= payment;
                change -= payment;
                
            }
            System.out.println("Thank you for your payment, you have paid the full amount!");
            
        } else if (itemPrice == amountPaid) {
            System.out.println("Thank you for your payment, have a nice day.");
            
        } else {
        	
            if (amountPaid < itemPrice) {
            	
                System.out.println("Please give the cashier $" + formatCurrency(-change));
                
            } else if (amountPaid > itemPrice) {
            	
                System.out.println("Your change is: $" + formatCurrency(change));
                calculateChange(change);
                
            } else {
                System.out.println("You have exact change");
                
            }
        }

        sc.close();
    }

    public static void calculateChange(double change) {
        int twenties = (int) (change / 20);
        change = change % 20;
      
        int tens = (int) (change / 10);
        change = change % 10;
      
        int fives = (int) (change / 5);
        change = change % 5;

        int dollars = (int) change;
        double remaining = change - dollars;

        int quarters = (int) (remaining / 0.25);
        remaining = remaining % 0.25;

        int dimes = (int) (remaining / 0.1);
        remaining = remaining % 0.1;

        int nickels = (int) (remaining / 0.05);
        remaining = remaining % 0.05;

        int pennies = (int) Math.round(remaining / 0.01);

        if (twenties > 0) {
            System.out.println(twenties + " twenty-dollar " + (twenties > 1 ? "bills" : "bill"));
        }
        if (tens > 0) {
            System.out.println(tens + " ten-dollar " + (tens > 1 ? "bills" : "bill"));
        }
        if (fives > 0) {
            System.out.println(fives + " five-dollar " + (fives > 1 ? "bills" : "bill"));
        }
        if (dollars > 0) {
            System.out.println(dollars + " dollar " + (dollars > 1 ? "bills" : "bill"));
        }
        if (quarters > 0) {
            System.out.println(quarters + (quarters > 1 ? " quarters" : " quarter"));
        }
        if (dimes > 0) {
            System.out.println(dimes + (dimes > 1 ? " dimes" : " dime"));
        }
        if (nickels > 0) {
            System.out.println(nickels + (nickels > 1 ? " nickels" : " nickel"));
        }
        if (pennies > 0) {
            System.out.println(pennies + (pennies > 1 ? " pennies" : " penny"));
        }
    }


    public static String formatCurrency(double amount) {
        DecimalFormat formatter = new DecimalFormat("0.00");
        return formatter.format(amount);
    }
}

	
	


