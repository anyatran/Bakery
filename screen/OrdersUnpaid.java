package screen;

import java.util.*;

import bakery.*;

/**
 * Screen for listing unpaid orders
 * 
 * @author rcj, anhtran9
 * @version 06/17/14
 * 
 */
public class OrdersUnpaid extends Screen {
    /**
     * Constructor to set the screen title
     */
    public OrdersUnpaid() {
        this.title = "*** View unpaid orders ***";
    }

    /**
     * Display unpaid orders
     */
    void run() {
        ArrayList<Order> orders = Screen.state.getUnpaidOrders();
        if (orders.size() != 0) {
            int index = 0;
            while (true) {
                System.out.print(orders.get(index).toString());
                System.out.println("Press n for Next, p for Previous");
                Scanner scan = new Scanner(System.in);
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
            Scanner scan = new Scanner(System.in);
            scan.next();
        }
        this.prev.run();
    }
}
