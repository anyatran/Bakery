package screen;

import java.util.Scanner;

/**
 * Screen for managing store inventory
 * @author rcj, anhtran9
 * @version 06/17/14
 *
 */
public class ManageInventories extends Screen {
    /**
     * Constructor to set the screen title
     */
    public ManageInventories() {
        this.title = "*** manage inventories ***";
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
