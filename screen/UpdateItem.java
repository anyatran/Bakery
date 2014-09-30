package screen;

import java.util.Scanner;

import bakery.Item;

/**
 * Screen for updating inventory items
 * @author rcj, anhtran9
 * @version 06/17/14
 */
public class UpdateItem extends Screen {
    /** The item we are concerned with */
    Item item;
    
    /**
     * Constructor to set the screen title
     */
    public UpdateItem() {
        this.title = "*** update item ***";
    }
    
    /** Prompt the user for the new name */
    private void updateName() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Set the name [" + this.item.getName() + "] : ");
        String name = scan.next();
        if (!name.equals("")) {
            item.setName(name);
        }
    }
    
    /** Prompt the user for the new category */
    private void updateCategory() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Set the category [" + 
                this.item.getCategory() + "] : ");
        String category = scan.next();
        if (!category.equals("")) {
            item.setCategory(category);
        }
    }
    
    /** Prompt the user for the new price */
    private void updatePrice() {
        Double price = Screen.getValidDouble("Set the price [" + 
                this.item.getPrice() + "] :");
        item.setPrice(price);
    }
    
    /** Prompt the user for the new quantity */
    private void updateQuantity() {
        Integer quantity = Screen.getValidInt("Set the quantity [" + 
                this.item.getQuantity() + "] :");
        item.setQuantity(quantity);
    }
    
    /**
     *  Overriding default key handler
     *  @param key
     *         The key entered by the user
     */
    public void keyHandler(String key) {
        if (key.equals("1")) {
            this.updateName();
        }
        else if (key.equals("2")) {
            this.updateCategory();
        }
        else if (key.equals("3")) {
            this.updatePrice();
        }
        else if (key.equals("4")) {
            this.updateQuantity();
        }
        else {
            throw new RuntimeException("Bad key");
        }
    }

    /**
     * Prompt the user to select a field to update
     */
    void run() {
        this.item = Screen.getValidItem();
        
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                System.out.println("1) Name");
                System.out.println("2) Category");
                System.out.println("3) Price");
                System.out.println("4) Quantity");
                System.out.println("Select a field to update [None]: ");
                this.keyHandler(scan.next());
                break;
            }
            catch (RuntimeException e) {
                System.out.println("Invalid menu item");
            }
        }
        
        System.out.print("Successfully updated item, "
                + "press any key to continue...");
        Scanner scan = new Scanner(System.in);
        scan.next();
        this.prev.run();

    }

}
