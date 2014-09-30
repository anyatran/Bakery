package bakery;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import tester.Tester;

/**
 * Test methods for Bakery class
 * 
 * @author rcj, anhtran9
 * @version 17/06/2014
 */
public class ExamplesBakery {

    /** An empty store */
    Store store1;
    /** A store loaded from a file */
    Store store2;

    /** A loyalty card */
    LoyaltyCard card1;
    /** Another loyalty card */
    LoyaltyCard card2;
    /** Yet another loyalty card */
    LoyaltyCard card3;

    /** A client */
    Client rob;
    /** Another client */
    Client bear;
    /** Yet another client */
    Client jamel;
    /** And another client */
    Client basil;

    /** An item representing cannolis */
    Item cannoli;
    /** An item representing cheesecakes */
    Item cheesecake;
    /** An item representing triamisu */
    Item tiramisu;
    /** An item representing snickerdoodles */
    Item snickerdoodle;
    /** An item representing key lime pies */
    Item keylime;
    /** An item representing german cake */
    Item german;
    /** An item representing cranberry pie */
    Item cranberry;
    /** An item representing french vanilla */
    Item french;
    /** An item representing brownies */
    Item brownies;

    /** An order */
    Order order1;
    /** Another order */
    Order order2;
    /** Yet another order */
    Order order3;
    /** And another order */
    Order order4;
    /** ...another order */
    Order order5;


    /** The store inventory */
    HashMap<Item, Integer> inventories;
    /** The store inventory */
    //HashMap<Item, Integer> inventories1;

    /** Initialize test date */
    void init() {
        File inv = new File("bakeryItems.txt");
        File orders = new File("orders.txt");
        store1 = new Store();
        store2 = new Store(inv, orders);
        card1 = new LoyaltyCard(true, 80.0, 10.0);
        card2 = new LoyaltyCard(false, 0.0, 0.0);
        card3 = new LoyaltyCard(true, 0.0, 20.0);

        rob = new Client(1, "Jensen", "Moon", "Galaxy", "Space", "00000", 
                card1);
        bear = new Client(2, "Bear", "Huntington st", "Boston", "MA", "02115",
                card2);
        jamel = new Client(3, "Jamel", "Lincoln st", "Haverhill", "MA",
                "01834", card3);
        basil = new Client(4, "Basil", "Boylston st", "Brookline", "MA",
                "02112");

        cannoli = new Item(15, "Cannoli", "Chocolate Chip  Pastries", 2.75, 6);
        cheesecake = new Item(20, "Cheesecake", "Cakes", 20.5, 3);
        tiramisu = new Item(84, "Tiramisu", "Pastries", 4.0, 7);
        snickerdoodle = new Item(78, "Snickerdoodle", "Cookies", 2.00, 3);
        keylime = new Item(52, "Key Lime", "Pies", 12.0, 2);
        german = new Item(47, "German Chocolate", "Cakes", 10.0, 7);
        cranberry = new Item(34, "Cranberry Orange", "Cookies", 3.0, 10);
        french = new Item(41, "French Silk", "Pies", 12.00, 1);
        brownies = new Item(23, "Brownies", "Cookies", 2.00, 10);

        order1 = new Order(rob, 101, "01/01/2011", "03/01/2011",
                new HashMap<Item, Integer>(), false, false, "pay later");
        order2 = new Order(bear, 103, "10/01/2011", "15/01/2011",
                new HashMap<Item, Integer>(), true, false, "");
        order3 = new Order(jamel, 104, "11/01/2011", "14/01/2011",
                new HashMap<Item, Integer>(), true, true, "more cream");
        order4 = new Order(basil, 105, "11/01/2011", "14/01/2011",
                new HashMap<Item, Integer>(), true, false, "more cocoa");
        order5 = new Order(rob, 108, "20/01/2011", "26/01/2011",
                new HashMap<Item, Integer>(), false, true, "");

        order1.getItems().put(cheesecake, 1);
        order1.getItems().put(snickerdoodle, 2);

        order2.getItems().put(tiramisu, 1);

        order3.getItems().put(german, 1);
        order3.getItems().put(cranberry, 2);

        order4.getItems().put(french, 1);
        order4.getItems().put(cranberry, 3);

        order5.getItems().put(keylime, 1);
        order5.getItems().put(cannoli, 3);

        store1.addItem(cannoli);
        store1.addItem(cheesecake);
        store1.addItem(tiramisu);
        store1.addItem(snickerdoodle);
        store1.addItem(keylime);
        store1.addItem(german);
        store1.addItem(cranberry);
        store1.addItem(french);

        //        inventories1.put(cannoli, 6);        
        //        inventories1.put(cheesecake, 3);     
        //        inventories1.put(tiramisu, 7);       
        //        inventories1.put(snickerdoodle, 3);  
        //        inventories1.put(keylime, 2);        
        //        inventories1.put(german, 7);         
        //        inventories1.put(cranberry, 3);      
        //        inventories1.put(french, 1);         

        store1.addClient(rob);
        store1.addClient(bear);
        store1.addClient(basil);
        // store1.addClient(jamel);

        store1.addOrder(order1);
        store1.addOrder(order2);
        store1.addOrder(order3);
        // store1.addOrder(order4);
        store1.addOrder(order5);
    }

    /**
     * Test get methods in all classes
     * 
     * @param t
     *            An instance of Tester object
     */
    void testGet(Tester t) {
        init();
        t.checkExpect(rob.getId(), 1);
        t.checkExpect(german.getId(), 47);
        t.checkExpect(order2.getId(), 103);
        t.checkExpect(basil.getAddress(), "Boylston st");
        t.checkExpect(basil.getLastName(), "Basil");
        t.checkExpect(basil.getCity(), "Brookline");
        t.checkExpect(basil.getState(), "MA");
        t.checkExpect(basil.getZipcode(), "02112");
        t.checkExpect(jamel.getCard(), card3);
        t.checkExpect(order1.getDiscount(), false);
        t.checkExpect(order1.getPaid(), false);
        t.checkExpect(order1.getClient(), rob);
        t.checkExpect(order1.getOrderDate(), "01/01/2011");
        t.checkExpect(order1.getPickupDate(), "03/01/2011");
        t.checkExpect(order1.getItems().size(), 2); // how to test this?
        t.checkExpect(order1.getNotes(), "pay later");
        t.checkExpect(order1.getReward(), 10.0);
        t.checkExpect(card1.getPoints(), 80.0);
        t.checkExpect(card1.getReward(), 10.0);
        t.checkExpect(german.getCategory(), "Cakes");
        t.checkExpect(german.getId(), 47);
        t.checkExpect(german.getName(), "German Chocolate");
        t.checkExpect(german.getPrice(), 10.0);
        t.checkExpect(german.getQuantity(), 7);
        t.checkExpect(store1.getInventories().size(), 8);

    }

    /**
     * Test set methods in all classes
     * 
     * @param t
     *            An instance of Tester object
     */
    void testSet(Tester t) {
        init();
        rob.setAddress("Boylston st");
        rob.setCity("Brookline");
        rob.setState("MA");
        rob.setLastName("Basil");
        rob.setZipcode("02112");

        order1.setClient(basil);
        order1.setDiscount(true);
        order1.setPaid(true);
        order1.setId(1009);
        order1.setNotes("hello");
        order1.setOrderDate("2/2/2022");
        order1.setPickupDate("3/2/2022");
        HashMap<Item, Integer> items = new HashMap<Item, Integer>();
        items.put(german, 2);
        order1.setItems(items);

        german.setCategory("Pie");
        german.setId(10);
        german.setName("Zwetschgenkuchen");
        german.setPrice(8.0);
        german.setQuantity(9);

        t.checkExpect(rob.getAddress(), "Boylston st");
        t.checkExpect(rob.getLastName(), "Basil");
        t.checkExpect(rob.getCity(), "Brookline");
        t.checkExpect(rob.getState(), "MA");
        t.checkExpect(rob.getZipcode(), "02112");
        t.checkExpect(order1.getDiscount(), true);
        t.checkExpect(order1.getPaid(), true);
        t.checkExpect(order1.getClient(), basil);
        t.checkExpect(order1.getOrderDate(), "2/2/2022");
        t.checkExpect(order1.getPickupDate(), "3/2/2022");
        t.checkExpect(order1.getNotes(), "hello");
        t.checkExpect(order1.getId(), 1009);
        t.checkExpect(order1.getItems(), items);
        t.checkExpect(german.getCategory(), "Pie");
        t.checkExpect(german.getId(), 10);
        t.checkExpect(german.getName(), "Zwetschgenkuchen");
        t.checkExpect(german.getPrice(), 8.0);
        t.checkExpect(german.getQuantity(), 9);
    }

    /**
     * Test LoyaltyCard methods
     * 
     * @param t
     *            An instance of Tester object
     */
    void testLoyaltyCardMethods(Tester t) {
        init();
        card1.deductReward(5.0);
        card3.clearReward();
        card2.updateCard(110.0);
        t.checkExpect(card1.getReward(), 5.0);
        t.checkExpect(card3.getReward(), 0.0);
        t.checkExpect(card2.getPoints(), 10.0);
        t.checkExpect(card2.getReward(), 10.0);
        t.checkExpect(card2.toString(), "the card is not activated");
        t.checkExpect(card1.toString(), "Status: activated" + "\n" + "Points: "
                + "80.0" + "\n" + "Reward: " + "5.0");
    }

    /**
     * Test methods in Client
     * 
     * @param t
     *            An instance of Tester object
     */
    void testClientsMethods(Tester t) {
        init();
        t.checkExpect(rob.toString(), "Client's ID: " + "1" + "\n"
                + "Last Name: " + "Jensen" + "\n" + "Address: " + "Moon" + "\n"
                + "State: " + "Space" + "\n" + "Zipcode: " + "00000" + "\n"
                + "Status: activated" + "\n" + "Points: " + "80.0" + "\n"
                + "Reward: " + "10.0");
    }

    /**
     * Test methods in Order
     * 
     * @param t
     *            An instance of Tester object
     */
    void testOrdersMethods(Tester t) {
        init();
        t.checkExpect(order1.total(), 24.5);
        t.checkExpect(order1.totalDue(), 24.5);
        t.checkExpect(order3.total(), 16.0);
        t.checkExpect(order4.applyDiscount(22.0), 22.0);
        t.checkExpect(order3.totalDue(), 0.0);
        t.checkExpect(order5.total(), 20.25);
        t.checkExpect(order5.totalDue(), 10.25);
        t.checkExpect(order2.toString(), "Client: " + "Bear" + "\n"
                + "Order ID: " + "103" + "\n" + "Items Ordered: \n" + "   "
                + "Tiramisu" + " ........................ " + "1" + " * $"
                + "4.0" + "   \n" + "\n" + "Order Date: " + "10/01/2011" + "\n"
                + "Pickup Date: " + "15/01/2011" + "\n" + "Paid?: " + "true"
                + "\n" + "Total: $" + "4.0" + "\n" + "Discount Applied?: "
                + "false" + "\n" + "Total Due: $" + "4.0" + "\n" + "Notes: "
                + "" + "\n");
        t.checkExpect(order2.printOrderedItems(), "   " + "Tiramisu"
                + " ........................ " + "1" + " * $" + "4.0" + 
                "   \n");
        t.checkExpect(order3.rewardToString(), "4.0");
        t.checkExpect(order3.pointsToString(), "0.0");
    }

    /**
     * Test methods in Store
     * 
     * @param t
     *            An instance of Tester object
     */
    void testStoresMethods(Tester t) {
        store1.addClient(jamel);
        store1.addOrder(order4);
        store1.addItem(brownies);
        t.checkExpect(Store.convertDiscount("-1"), true);
        t.checkExpect(Store.convertDiscount("0"), false);
        t.checkExpect(Store.convertPaid("YES"), true);
        t.checkExpect(Store.convertPaid("nO"), false);
        t.checkExpect(store1.getCustomers().size(), 4);
        t.checkExpect(store1.getOrders().size(), 5);
        t.checkExpect(store1.getItem(23), brownies);
        t.checkExpect(store1.getItem(2333), null);
        t.checkExpect(store1.getOrder(101), order1);
        t.checkExpect(store1.getOrder(666), null);
        t.checkExpect(store1.getClient(3), jamel);
        t.checkExpect(store1.generateOrderId(), 109);
        t.checkExpect(store1.generateClientId(), 5);
        t.checkExpect(store1.generateItemId(), 85);
        t.checkExpect(store1.getClient(9), null);
        t.checkExpect(store1.getOrdersByClient(1),
                new ArrayList<Order>(Arrays.asList(order1, order5)));
        t.checkExpect(store1.getOrdersByItem(34),
                new ArrayList<Order>(Arrays.asList(order3, order4)));
        t.checkExpect(store1.getOrdersByOrderDate("01/01/2011"),
                new ArrayList<Order>(Arrays.asList(order1)));
        t.checkExpect(store1.getOrdersByPickupDate("15/01/2011"),
                new ArrayList<Order>(Arrays.asList(order2)));
        t.checkExpect(store1.getOrdersByClient(8), new ArrayList<Order>());
        t.checkExpect(store1.getOrdersByItem(8), new ArrayList<Order>());
        t.checkExpect(store1.getOrdersByOrderDate("11/11/2011"),
                new ArrayList<Order>());
        t.checkExpect(store1.getOrdersByPickupDate("11/11/2011"),
                new ArrayList<Order>());
        t.checkExpect(store1.getUnpaidOrders(),
                new ArrayList<Order>(Arrays.asList(order1, order5)));
        t.checkExpect(store1.getMenu(), "Cookies: \nCranberry Orange"
                + "\nBrownies\nSnickerdoodle\n\nCakes: \nCheesecake"
                + "\nGerman Chocolate\n\nChocolate Chip  Pastries: "
                + "\nCannoli\n\nPies: \nKey Lime\nFrench Silk\n\nPastries: "
                + "\nTiramisu\n\n");
        t.checkExpect(Store.convertToString(true), "yes");
        t.checkExpect(Store.convertToString(false), "no");
    }
}
