package screen;

import java.util.HashMap;
import java.util.Scanner;

import bakery.*;

/**
 * Screen for adding new a new order
 * @author rcj, anhtran9
 * @version 06/17/14
 *
 */
public class AddOrder extends Screen {
    /**
     * Constructor to set the screen title
     */
    public AddOrder() {
        this.title = "*** add order ***";
    }

    /**
     * Display menu and prompt the user for order information
     */
    void run() {
        System.out.println(this.toString());
        Scanner scan;

        Client client = Screen.getValidClient();
        HashMap<Item, Integer> items = new HashMap<Item, Integer>();
        while (true) {
            Item item = Screen.getValidItem();
            Integer qty;

            qty = Screen.getValidInt("How many [1]?");
            items.put(item, qty);
            System.out.print("Add more items? [y/n]");
            scan = new Scanner(System.in);
            if (scan.next().equalsIgnoreCase("y")) {
                continue;
            } 
            else {
                break;
            }
        }
        // order date
        System.out.println("Enter order date []: ");
        scan = new Scanner(System.in);
        String orderDate = scan.next();

        // pickup date
        System.out.println("Enter pickup date []: ");
        scan = new Scanner(System.in);
        String pickupDate = scan.next();

        // paid
        System.out.println("Has the client paid for the order? [y/n]: ");
        scan = new Scanner(System.in);
        String paidString = scan.next();
        Boolean paid;
        if (paidString.toLowerCase().toString().equals("y")) {
            paid = true;
        } 
        else {
            paid = false;
        }

        // discount
        System.out.println("Is discount applied? [y/n]: ");
        scan = new Scanner(System.in);
        String discountString = scan.next();
        Boolean discount;
        if (discountString.toLowerCase().toString().equals("y")) {
            discount = true;
        } 
        else {
            discount = false;
        }

        // notes
        System.out.println("Notes: ");
        scan = new Scanner(System.in);
        String notes = scan.next();

        // add
        Order o = new Order(client, Screen.state.generateOrderId(), orderDate,
                pickupDate, items, paid, discount, notes);
        Screen.state.addOrder(o);
        System.out.println(o.toString());
        System.out.print("\n \n Successfully added customer, "
                + "press any key to continue...");
        scan = new Scanner(System.in);
        scan.next();
        this.prev.run();
    }

}
