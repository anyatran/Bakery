package screen;

import java.util.Scanner;

import bakery.Client;

/**
 * Screen for viewing client contact info
 * @author rcj, anhtran9
 * @version 06/17/14
 *
 */
public class ContactInfo extends Screen {
    /**
     * Constructor to set the screen title
     */
    public ContactInfo() {
        this.title = "*** Contact Info ***";
    }

    /**
     * Display menu and prompt the user for client info
     */
    void run() {
        System.out.println(this.toString());
        Integer id = null;
        Scanner scan = new Scanner(System.in);
        while (id == null) {
            try {
                System.out.print("Enter client's ID: ");
                scan = new Scanner(System.in);
                id = Integer.parseInt(scan.next());
            }
            catch (NumberFormatException e) {
                System.out.println("wrong ID format. It must be an integer.");
            }   
        }

        Client client = Screen.state.getClient(id);
        if (client == null) {
            System.out.println("the client is not found");

        }
        else {
            System.out.println(client.toString());
        }
        System.out.println("Press any key to continue...");
        scan.next();
        this.prev.run();
    }
}
