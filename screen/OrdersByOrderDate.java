package screen;

import java.util.*;

import bakery.*;

/**
 * Screen for listing orders by order date
 * 
 * @author rcj, anhtran9
 * @version 06/17/14
 * 
 */
public class OrdersByOrderDate extends Screen {
    /**
     * Constructor to set the screen title
     */
    public OrdersByOrderDate() {
        this.title = "*** View Orders by order date ***";
    }

    /**
     * Prompt the user for order date
     */
    void run() {
        System.out.println("Enter a date (MM/DD/YY): ");
        Scanner scan = new Scanner(System.in);
        String date = scan.next();
        ArrayList<Order> orders = Screen.state.getOrdersByOrderDate(date);
        int index = 0;
        if (orders.size() != 0) {
            while (true) {
                System.out.print(orders.get(index).toString());
                System.out.println("Press n for Next, p for Previous");
                scan = new Scanner(System.in);
                String key = scan.next();
                if (key.equalsIgnoreCase("n")) {
                    if (index == orders.size() - 1) {
                        index = 0;
                    } 
                    else {
                        index++;
                    }
                } 
                else if (key.equalsIgnoreCase("p")) {
                    if (index == 0) {
                        index = orders.size() - 1;
                    } 
                    else {
                        index--;
                    }
                } 
                else {
                    break;
                }
            }
        } 
        else {
            System.out.println("No such order");
            System.out.println("Press any key to continue");
            scan = new Scanner(System.in);
            scan.next();
        }
        this.prev.run();
    }
}
