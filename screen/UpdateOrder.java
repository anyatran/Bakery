package screen;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import bakery.*;

/**
 * Screen for updating order info
 * @author rcj, anhtran9
 * @version 06/17/14
 */
public class UpdateOrder extends Screen {
    /** The order we are concerned with */
    Order order;
    
    /**
     * Constructor to set the screen title
     */
    public UpdateOrder() {
        this.title = "*** update order ***";

    }
    
    /** Prompt the user for the new client id */
    private void updateClient() {
        System.out.print("Set the client [" + 
                this.order.getClient().getId() + "] : ");
        Client client = Screen.getValidClient();
        order.setClient(client);
    }
    
    /** Prompt the user for the new order date */
    private void updateOrderDate() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Set the order date [" + 
                this.order.getOrderDate() + "] : ");
        String orderDate = scan.next();
        if (!orderDate.equals("")) {
            order.setOrderDate(orderDate);
        }
    }
    
    /** Prompt the user for the new pickup date */
    private void updatePickupDate() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Set the pickup date [" + 
                this.order.getPickupDate() + "] : ");
        String pickupDate = scan.next();
        if (!pickupDate.equals("")) {
            order.setPickupDate(pickupDate);
        }
    }
    
    /** Take the user through the item update procedure */
    private void updateItems() {
        Set<Entry<Item, Integer>> itemSet = this.order.getItems().entrySet();
        ArrayList<Entry<Item, Integer>> orderItems = 
                new ArrayList<Entry<Item, Integer>>();
        orderItems.addAll(itemSet);
        int index = 0;
        
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Item id: " + 
                    orderItems.get(index).getKey().getId());
            System.out.println("Item name: " + 
                    orderItems.get(index).getKey().getName());
            System.out.println("Quantity: " + 
                    orderItems.get(index).getValue());
            System.out.println("u/update, n/Next Item, "
                    + "p/Previous Item, enter/quit: ");
            String key = scan.next();
            if (key.equals("u")) {
                this.updateOrderItem(orderItems.get(index));
            }
            else if (key.equals("n")) {
                if (index == orderItems.size() - 1) {
                    index = 0;
                }
                else {
                    index++;
                }
            }
            else if (key.equals("p")) {
                if (index == 0) {
                    index = orderItems.size() - 1;
                }
                else {
                    index--;
                }
            }
            else if (key.equals("")) {
                break;
            }
            else {
                throw new RuntimeException("Invalid key");
            }
        }
    }
    
    /** Prompt the user for the new item */
    private void updateOrderItem(Entry<Item, Integer> oldEntry) {
        Item item = Screen.getValidItem();
        Integer quantity = Screen.getValidInt("Enter a new quantity [" + 
                oldEntry.getValue() + "]: ");
        this.order.getItems().remove(oldEntry.getKey());
        this.order.getItems().put(item, quantity);
    }
    
    /** Prompt the user for the new paid status */
    private void updatePaidStatus() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Set the paid status y/n [" + 
                this.order.getPaid() + "] : ");
        String paid = scan.next();
        if (paid.equals("y")) {
            order.setPaid(true);
        }
        else if (paid.equals("n")) {
            order.setPaid(false);
        }
        else if (paid.equals("")) {
            return;
        }
        else {
            throw new RuntimeException("Bad key");
        }
    }
    
    /** Prompt the user for the new discount status */
    private void updateDiscountStatus() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Set the discount status y/n [" + 
                this.order.getDiscount() + "] : ");
        String discount = scan.next();
        if (discount.equals("y")) {
            order.setDiscount(true);
        }
        else if (discount.equals("n")) {
            order.setDiscount(false);
        }
        else if (discount.equals("")) {
            return;
        }
        else {
            throw new RuntimeException("Bad key");
        }
    }
    
    /** Prompt the user for the new notes */
    private void updateNotes() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Set the notes: ");
        String notes = scan.next();
        if (!notes.equals("")) {
            order.setNotes(notes);
        }
    }
    
    /**
     *  Overriding default key handler
     *  @param key
     *         The key entered by the user
     */
    public void keyHandler(String key) {
        if (key.equals("1")) {
            this.updateClient();
        }
        else if (key.equals("2")) {
            this.updateOrderDate();
        }
        else if (key.equals("3")) {
            this.updatePickupDate();
        }
        else if (key.equals("4")) {
            this.updateItems();
        }
        else if (key.equals("5")) {
            this.updatePaidStatus();
        }
        else if (key.equals("6")) {
            this.updateDiscountStatus();
        }
        else if (key.equals("7")) {
            this.updateNotes();
        }
        else if (key.equals("")) {
            return;
        }
        else {
            throw new RuntimeException("Bad key");
        }
    }

    /**
     * Prompt the user to select a field to update
     */
    void run() {
        this.order = Screen.getValidOrder();
        
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                System.out.println("1) Client");
                System.out.println("2) Order Date");
                System.out.println("3) Pickup Date");
                System.out.println("4) Items");
                System.out.println("5) Paid Status");
                System.out.println("6) Discount Status");
                System.out.println("7) Notes");
                System.out.println("Select a field to update [None]: ");
                this.keyHandler(scan.next());
                break;
            }
            catch (RuntimeException e) {
                System.out.println("Invalid key");
            }
        }
        
        System.out.print("Successfully updated order, "
                + "press any key to continue...");
        Scanner scan = new Scanner(System.in);
        scan.next();
        this.prev.run();

    }

}
