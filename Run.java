import java.io.*;

import screen.*;
import bakery.Store;

/**
 * Wrapper class for main function
 * @author rcj, anhtran9
 * @version 06/17/14
 */
public class Run {
    
    /**
     * Program entry point
     * @param args
     *        Command-line arguments
     */
    public static void main(String[] args) {
        File orders = new File("orders.txt");
        File bakeryItems = new File("bakeryItems.txt");
        Store store = new Store(bakeryItems, orders);

        Screen addCustomer = new AddCustomer();
        Screen addItem = new AddItem();
        Screen addOrder = new AddOrder();
        Screen contactInfo = new ContactInfo();
        Screen exportData = new ExportData();
        Screen loyaltyStatus = new LoyaltyStatus();
        MainMenu mainMenu = new MainMenu();
        Screen manageCustomers = new ManageCustomers();
        Screen manageInventories = new ManageInventories();
        Screen manageOrders = new ManageOrders();
        Screen ordersByCustomers = new OrdersByCustomers();
        Screen ordersByItem = new OrdersByItem();
        Screen ordersByOrderDate = new OrdersByOrderDate();
        Screen ordersByPickupDate = new OrdersByPickupDate();
        Screen ordersUnpaid = new OrdersUnpaid();
        Screen updateCustomer = new UpdateCustomer();
        Screen updateItem = new UpdateItem();
        Screen updateOrder = new UpdateOrder();
        Screen viewMenu = new ViewMenu();


        mainMenu.addMenuItem(manageCustomers);
        mainMenu.addMenuItem(manageOrders);
        mainMenu.addMenuItem(manageInventories);
        mainMenu.addMenuItem(exportData);

        manageCustomers.setPrev(mainMenu);
        manageCustomers.addMenuItem(addCustomer);
        manageCustomers.addMenuItem(updateCustomer);
        manageCustomers.addMenuItem(loyaltyStatus);
        manageCustomers.addMenuItem(contactInfo);
        manageCustomers.addMenuItem(mainMenu);

        addCustomer.setPrev(manageCustomers);
        updateCustomer.setPrev(manageCustomers);
        loyaltyStatus.setPrev(manageCustomers);
        contactInfo.setPrev(manageCustomers);

        manageOrders.setPrev(mainMenu);
        manageOrders.addMenuItem(addOrder);
        manageOrders.addMenuItem(updateOrder);
        manageOrders.addMenuItem(ordersByCustomers);
        manageOrders.addMenuItem(ordersByItem);
        manageOrders.addMenuItem(ordersByOrderDate);
        manageOrders.addMenuItem(ordersByPickupDate);
        manageOrders.addMenuItem(ordersUnpaid);
        manageOrders.addMenuItem(mainMenu);

        addOrder.setPrev(manageOrders);
        updateOrder.setPrev(manageOrders);
        ordersByCustomers.setPrev(manageOrders);
        ordersByItem.setPrev(manageOrders);
        ordersByOrderDate.setPrev(manageOrders);
        ordersByPickupDate.setPrev(manageOrders);
        ordersUnpaid.setPrev(manageOrders);
        
        manageInventories.setPrev(mainMenu);
        manageInventories.addMenuItem(addItem);
        manageInventories.addMenuItem(updateItem);
        manageInventories.addMenuItem(viewMenu);
        manageInventories.addMenuItem(mainMenu);
        
        addItem.setPrev(manageInventories);
        updateItem.setPrev(manageInventories);
        viewMenu.setPrev(manageInventories);
        
        exportData.setPrev(mainMenu);
        Screen.state = store;
        mainMenu.run();
    }
}












