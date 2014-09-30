package screen;

import java.util.Scanner;

/**
 * Screen for managing store inventory
 * @author rcj, anhtran9
 * @version 06/17/14
 *
 */
public class ManageOrders extends Screen {
    /**
     * Constructor to set the screen title
     */
    public ManageOrders() {
        this.title = "*** manage orders ***";
    }


    /**
     * Display menu options
     */
    void run() {
        System.out.print(this.toString());
        System.out.println("Select menu item: ");
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        this.keyHandler(input);
    }

}
