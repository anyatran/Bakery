package screen;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import bakery.*;

/**
 * Screen for exporting store data
 * @author rcj, anhtran9
 * @version 06/17/14
 *
 */
public class ExportData extends Screen {
    /**
     * Constructor to set the screen title
     */
    public ExportData() {
        this.title = "*** export data ***";
    }


    /**
     * Export store data to files
     */
    @SuppressWarnings("unused")
    void run() {      
        System.out.println(this.toString());
        try {
            File file = new File("bakeryItems1.txt");
            PrintStream output = new PrintStream(file);


            output.println("BakeryItemID\tBakeryItemName\t"
                    + "Category\tPrice\tQuantity");
            for (Entry<Integer, Item> i : 
                Screen.state.getInventories().entrySet()) {
                output.println(i.getValue().getId().toString() + "\t" + 
                        i.getValue().getName() + "\t" + 
                        i.getValue().getCategory() + "\t" +
                        i.getValue().getPrice().toString() + "\t" + 
                        i.getValue().getQuantity().toString());
            }
            output.close();

            file = new File("orders1.txt");
            output = new PrintStream(file);
            output.println("CustomerID\tLastName\tAddress\tCity\tState\t"
                    + "ZipCode\tOrderID\tPaid?\tOrderDate\tPickupDate\t"
                    + "BakeryItemID\tBakeryItemName\tBakeryItemCategory\t"
                    + "Quantity\tPrice\tTotal\tDiscountUsedOnOrder\t"
                    + "TotalDue\tAvailableDiscount\tCurrentLoyalty");
            for (Entry<Integer, Order> ie : Screen.state.getOrders()
                    .entrySet()) {
                Order order = ie.getValue();
                Client client = order.getClient();
                for (Entry<Item, Integer> allItems : order.getItems()
                        .entrySet()) {
                    Item item = allItems.getKey();

                    output.println(client.getId().toString()
                            + "\t"
                            + client.getLastName()
                            + "\t"
                            + client.getAddress()
                            + "\t"
                            + client.getCity()
                            + "\t"
                            + client.getState()
                            + "\t"
                            + client.getZipcode()
                            + "\t"
                            + order.getId().toString()
                            + "\t"
                            + Store.convertToString(order.getPaid())
                            + "\t"
                            + order.getOrderDate()
                            + "\t"
                            + order.getPickupDate()
                            + "\t"
                            + item.getId().toString()
                            + "\t"
                            + item.getName()
                            + "\t"
                            + item.getCategory()
                            + "\t"
                            + allItems.getValue()
                            + "\t"
                            + item.getPrice().toString()
                            + "\t"
                            + order.total().toString()
                            + "\t"
                            + ((Double) (order.total() - 
                                    order.totalDue())).toString()
                            + "\t"
                            + order.totalDue().toString()
                            + "\t"
                            + order.rewardToString()
                            + "\t"
                            + order.pointsToString());
                }

            }
        }


        catch (IOException io) {
            System.out.println("error");
        }

        System.out.println("Press any key to go back ");
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        this.prev.run();

    }

}
