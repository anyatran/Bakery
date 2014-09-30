package bakery;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Map.Entry;

/**
 * High level store operations and data storage
 * 
 * @author rcj, anhtran9
 * @version 06/17/14
 * 
 */
public class Store {
    /** The store inventory, indexed by id */
    private HashMap<Integer, Item> inventory = new HashMap<Integer, Item>();
    /** Client orders, indexed by id */
    private HashMap<Integer, Order> orders = new HashMap<Integer, Order>();
    /** Customer records, indexed by id */
    private HashMap<Integer, Client> customers = new HashMap<Integer, Client>();

    /**
     * Default constructor
     */
    Store() {
        // Empty constructor
    }

    /**
     * Constructor for loading from file
     * 
     * @param inventoryData
     *            File containing inventory data
     * @param orderData
     *            File containing order data
     */
    public Store(File inventoryData, File orderData) {
        this.parseInventory(inventoryData);
        this.parseOrder(orderData);
    }

    /**
     * Read in the inventory file
     * 
     * @param data
     *            The inventory file
     */
    private void parseInventory(File data) {
        try {
            Scanner scan = new Scanner(data);
            scan.nextLine();
            while (scan.hasNextLine()) {
                String s = scan.nextLine();
                String[] fields = s.split("\t");
                Item inputItem = new Item(Integer.parseInt(fields[0]),
                        fields[1], fields[2], Double.parseDouble(fields[3]), 1);
                this.addItem(inputItem);
            }
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * Read in the order file
     * 
     * @param data
     *            The order file
     */
    private void parseOrder(File data) {
        try {
            Scanner scan = new Scanner(data);
            scan.nextLine();
            while (scan.hasNextLine()) {
                String s = scan.nextLine();
                String[] fields = s.split("\t");
                LoyaltyCard cardInput = new LoyaltyCard(true,
                        Double.parseDouble(fields[19]),
                        Double.parseDouble(fields[18]));
                Client clientInput = new Client(Integer.parseInt(fields[0]),
                        fields[1], fields[2], fields[3], fields[4], fields[5],
                        cardInput);
                if (this.getClient(clientInput.getId()) == null) {
                    this.addClient(clientInput);
                }
                HashMap<Item, Integer> itemInput = new HashMap<Item, Integer>();
                Order orderInput = new Order(clientInput,
                        Integer.parseInt(fields[6]), fields[8], fields[9],
                        itemInput, Store.convertPaid(fields[7]),
                        Store.convertDiscount(fields[16]), "");
                if (this.getOrder(orderInput.getId()) == null) {
                    this.addOrder(orderInput);
                }
                Integer id = Integer.parseInt(fields[10]);
                Item item = this.getItem(id);
                Order realOrder = this.getOrder(Integer.parseInt(fields[6]));
                itemInput = realOrder.getItems();
                itemInput.put(item, Integer.parseInt(fields[13]));
            }
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * Convert a yes/no string to boolean true/false
     * 
     * @param s
     *            The string "yes" or the string "no"
     * @return True if the string was "yes", false if it was "no"
     */
    public static boolean convertPaid(String s) {
        return s.equalsIgnoreCase("yes");
    }

    /**
     * Convert a discount to a boolean
     * 
     * @param s
     *            A discount amount
     * @return False if the discount equals "0", true otherwise
     */
    public static boolean convertDiscount(String s) {
        return !s.equals("0");
    }

    /**
     * Add a client to the customer records
     * 
     * @param c
     *            The client to add
     */
    public void addClient(Client c) {
        this.customers.put(c.getId(), c);
    }

    /**
     * Add an order to the order records
     * 
     * @param o
     *            The order to add
     */
    public void addOrder(Order o) {
        this.orders.put(o.getId(), o);
    }

    /**
     * Add an item to the inventory
     * 
     * @param i
     *            The item to add
     */
    public void addItem(Item i) {
        this.inventory.put(i.getId(), i);

    }

    /**
     * Get client by id
     * 
     * @param id
     *            The client id to look up
     * @return The client with this id or null if the client does not exist
     */
    public Client getClient(int id) {
        return this.customers.get(id);
    }

    /**
     * Get order by id
     * 
     * @param id
     *            The order id to look up
     * @return The order with this id or null if the order does not exist
     */
    public Order getOrder(int id) {
        return this.orders.get(id);
    }

    /**
     * Get item by id
     * 
     * @param id
     *            The item id to look up
     * @return The item with this id or null if the item does not exist
     */
    public Item getItem(int id) {
        return this.inventory.get(id);
    }

    /**
     * Get orders by client id
     * 
     * @param id
     *            A client id
     * @return Orders placed by the client represented by the given id
     */
    public ArrayList<Order> getOrdersByClient(int id) {
        ArrayList<Order> clientOrders = new ArrayList<Order>();

        for (Entry<Integer, Order> entry : this.orders.entrySet()) {
            if (entry.getValue().getClient().getId() == id) {
                clientOrders.add(entry.getValue());
            }
        }

        return clientOrders;
    }

    /**
     * Get orders by order date
     * 
     * @param date
     *            The date we are concerned with
     * @return Orders placed on the given date
     */
    public ArrayList<Order> getOrdersByOrderDate(String date) {
        ArrayList<Order> clientOrders = new ArrayList<Order>();

        for (Entry<Integer, Order> entry : this.orders.entrySet()) {
            if (entry.getValue().getOrderDate().equals(date)) {
                clientOrders.add(entry.getValue());
            }
        }

        return clientOrders;
    }

    /**
     * Get orders by pickup date
     * 
     * @param date
     *            The date we are concerned with
     * @return Orders to be picked up on the given date
     */
    public ArrayList<Order> getOrdersByPickupDate(String date) {
        ArrayList<Order> clientOrders = new ArrayList<Order>();

        for (Entry<Integer, Order> entry : this.orders.entrySet()) {
            if (entry.getValue().getPickupDate().equals(date)) {
                clientOrders.add(entry.getValue());
            }
        }

        return clientOrders;
    }

    /**
     * Get orders by item id
     * 
     * @param id
     *            An item id
     * @return Orders containing the given item
     */
    public ArrayList<Order> getOrdersByItem(int id) {
        ArrayList<Order> clientOrders = new ArrayList<Order>();

        for (Entry<Integer, Order> entry : this.orders.entrySet()) {
            for (Entry<Item, Integer> itemEntry : entry.getValue().getItems()
                    .entrySet()) {
                if (itemEntry.getKey().getId() == id) {
                    clientOrders.add(entry.getValue());
                    break;
                }
            }
        }

        return clientOrders;
    }

    /**
     * Get orders that have not been paid for
     * 
     * @return List of orders that have not been paid for
     */
    public ArrayList<Order> getUnpaidOrders() {
        ArrayList<Order> clientOrders = new ArrayList<Order>();

        for (Entry<Integer, Order> entry : this.orders.entrySet()) {
            if (!entry.getValue().getPaid()) {
                clientOrders.add(entry.getValue());
            }
        }

        return clientOrders;
    }

    /**
     * Get a string representation of available items
     * 
     * @return A string representation of available items
     */
    public String getMenu() {
        HashMap<String, ArrayList<Item>> menu = 
                new HashMap<String, ArrayList<Item>>();
        String output = "";

        for (Entry<Integer, Item> entry : this.inventory.entrySet()) {
            String cat = entry.getValue().getCategory();

            if (menu.containsKey(entry.getValue().getCategory())) {
                ArrayList<Item> newList = menu.get(cat);

                newList.add(entry.getValue());
                menu.put(cat, newList);
            }

            else {
                ArrayList<Item> newList = new ArrayList<Item>();
                newList.add(entry.getValue());
                menu.put(cat, newList);
            }
        }

        for (String cat : menu.keySet()) {
            output += cat + ": \n";
            for (Item i : menu.get(cat)) {
                output += i.getName() + "\n";
            }
            output += "\n";
        }

        return output;
    }

    /**
     * Generate the next available client id
     * 
     * @return A new valid client id
     */
    public Integer generateClientId() {
        ArrayList<Integer> ids = new ArrayList<Integer>();
        for (Entry<Integer, Client> e : this.customers.entrySet()) {
            ids.add(e.getKey());
        }

        Collections.sort(ids);

        return ids.get(ids.size() - 1) + 1;
    }

    /**
     * Generate the next available item id
     * 
     * @return A new valid item id
     */
    public Integer generateItemId() {
        ArrayList<Integer> ids = new ArrayList<Integer>();
        for (Entry<Integer, Item> e : this.inventory.entrySet()) {
            ids.add(e.getKey());
        }

        Collections.sort(ids);

        return ids.get(ids.size() - 1) + 1;
    }

    /**
     * Generate the next available order id
     * 
     * @return A new valid order id
     */
    public Integer generateOrderId() {
        ArrayList<Integer> ids = new ArrayList<Integer>();
        for (Entry<Integer, Order> e : this.orders.entrySet()) {
            ids.add(e.getKey());
        }

        Collections.sort(ids);

        return ids.get(ids.size() - 1) + 1;
    }

    /**
     * Get the inventory
     * 
     * @return The hashmap containing the inventory
     */
    public HashMap<Integer, Item> getInventories() {
        return this.inventory;
    }

    /**
     * Get the order records
     * 
     * @return The hashmap containing order records
     */
    public HashMap<Integer, Order> getOrders() {
        return this.orders;
    }
    
    /**
     * Get the client records
     * 
     * @return The hashmap containing order records
     */
    public HashMap<Integer, Client> getCustomers() {
        return this.customers;
    }

    /**
     * Convert a boolean into a "yes" or a "no"
     * 
     * @param b
     *            A boolean
     * @return "Yes" if b is true, "No" if b is false
     */
    public static String convertToString(Boolean b) {
        if (b) {
            return "yes";
        } 
        else {
            return "no";
        }
    }
}
