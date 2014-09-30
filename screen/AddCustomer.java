package screen;

import java.util.Scanner;

import bakery.*;

/**
 * Screen for adding new a new client
 * @author rcj, anhtran9
 * @version 06/17/14
 *
 */
public class AddCustomer extends Screen {
    /**
     * Constructor to set the screen title
     */
    public AddCustomer() {
        this.title = "*** add customer ***";
    }

    /**
     * Display menu and prompt the user for customer information
     */
    void run() {
        System.out.println(this.toString());
        System.out.print("Enter client's last name: ");
        Scanner scan = new Scanner(System.in);
        String lastName = scan.next();
        System.out.print("Enter client's address: ");
        scan = new Scanner(System.in);
        String address = scan.next();
        System.out.print("Enter client's city: ");
        scan = new Scanner(System.in);
        String city = scan.next();
        System.out.print("Enter client's state: ");
        scan = new Scanner(System.in);
        String state = scan.next();
        System.out.print("Enter client's zipcode: ");
        scan = new Scanner(System.in);
        String zip = scan.next();
        Screen.state.addClient(new Client(Screen.state.generateClientId(),
                lastName, address, city, state, zip));
        System.out.print("Successfully added customer, "
                + "press any key to continue...");
        scan = new Scanner(System.in);
        scan.next();
        this.prev.run();
    }

}
