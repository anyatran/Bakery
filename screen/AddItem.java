package screen;

import java.util.Scanner;

import bakery.Item;

/**
 * Screen for adding new a new item
 * @author rcj, anhtran9
 * @version 06/17/14
 *
 */
public class AddItem extends Screen {

    /**
     * Constructor to set the screen title
     */
    public AddItem() {
        this.title = "*** add item ***";
    }
    
    /**
     * Display menu and prompt the user for item information
     */
    void run() {
        System.out.println(this.toString());
        System.out.println("Enter item name: ");
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        System.out.println("Enter item category: ");
        scan = new Scanner(System.in);
        String category = scan.next();
        Double price = Screen.getValidDouble("Enter item price: ");
        Integer quantity = Screen.getValidInt("Enter item quantity: ");
        Screen.state.addItem(new Item(Screen.state.generateItemId(), name,
                category, price, quantity));
        System.out.print("Successfully added item, "
                + "press any key to continue...");
        scan = new Scanner(System.in);
        scan.next();
        this.prev.run();
    }

}
