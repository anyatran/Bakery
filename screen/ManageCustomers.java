package screen;

import java.util.Scanner;

/**
 * Screen for managing customer data
 * @author rcj, anhtran9
 * @version 06/17/14
 *
 */
public class ManageCustomers extends Screen {
    /**
     * Constructor to set the screen title
     */
    public ManageCustomers() {
        this.title = "*** manage customers ***";
    }
    
    /**
     * Display menu options
     */
    void run() {
        System.out.println(this.toString());
        System.out.println("Select menu item: ");
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        this.keyHandler(input);
    }

}
