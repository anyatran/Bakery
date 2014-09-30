package screen;

import java.util.*;

import bakery.*;

/**
 * Represents a screen in the console UI
 * @author rcj, anhtran9
 * @version 06/17/14
 */
public abstract class Screen {
    /** The title of this screen */
    String title;
    /** A list of screens we can travel to from this screen */
    ArrayList<Screen> menu;
    /** The previous screen */
    Screen prev;
    /** The store data */
    public static Store state;
    
    /**
     * Default constructor
     */
    Screen() {
        this.title = "";
        this.menu = new ArrayList<Screen>();
        this.prev = null;

    }
    
    /**
     * Prompt the user until they enter a valid integer
     * @param prompt
     *        Prompt to display to the user
     * @return An Integer
     */
    static Integer getValidInt(String prompt) {
        Scanner scan;
        Integer result;
        while (true) {
            try {
                System.out.print(prompt);
                scan = new Scanner(System.in);
                result = Integer.parseInt(scan.next());
                return result;
            }
            catch (NumberFormatException e) {
                System.out.println("wrong format. It must be an integer.");
                continue;
            }  
        }
    }
    
    /**
     * Prompt the user until they enter a valid double
     * @param prompt
     *        Prompt to display to the user
     * @return A Double
     */
    static Double getValidDouble(String prompt) {
        Scanner scan;
        Double result;
        while (true) {
            try {
                System.out.print(prompt);
                scan = new Scanner(System.in);
                result = Double.parseDouble(scan.next());
                return result;
            }
            catch (NumberFormatException e) {
                System.out.println("wrong format. It must be a double.");
                continue;
            }  
        }
    }
    
    /**
     * Prompt the user until they enter a valid client id
     * @return A Client
     */
    static Client getValidClient() {
        Client client;
        while (true) {
            Integer id = Screen.getValidInt("Enter a client id");
            client = Screen.state.getClient(id);
            if (client == null) {
                System.out.println("Client does not exist");
                continue;
            }
            else {
                break;
            }
        }
        return client;
    }
    
    /**
     * Prompt the user until they enter a valid order id
     * @return An Order
     */
    static Order getValidOrder() {
        Order order;
        while (true) {
            Integer id = Screen.getValidInt("Enter an order id");
            order = Screen.state.getOrder(id);
            if (order == null) {
                System.out.println("Order does not exist");
                continue;
            }
            else {
                break;
            }
        }
        return order;
    }
    
    /**
     * Prompt the user until they enter a valid item id
     * @return An Item
     */
    static Item getValidItem() {
        Item item;
        while (true) {
            Integer id = Screen.getValidInt("Enter an item id");
            item = Screen.state.getItem(id);
            if (item == null) {
                System.out.println("Item does not exist");
                continue;
            }
            else {
                break;
            }
        }
        return item;
    }
    
    /**
     * Screen implementation
     */
    abstract void run();
    
    /**
     * Determine next state based on key entered
     * @param key
     *        The key entered by the user
     */
    public void keyHandler(String key) {
        Integer menuNumber = 0;
        try {
            menuNumber = Integer.parseInt(key);
        }
        catch (NumberFormatException e) {
            //throw new RuntimeException("Bad key");
            System.out.println("Invalid Menu Item");
            this.run();
            return;
        }
        if (menuNumber < 1 || menuNumber > this.menu.size()) {
            System.out.println("Invalid Menu Item");
            this.run();
            return;
        }
        this.menu.get(menuNumber - 1).run();
    }

    /**
     * Return the screen header
     * @return The screen title and menus
     */
    public String toString() {
        String result = this.title.toUpperCase() + "\n\n";
        for (Screen s: this.menu) {
            result = result + (menu.indexOf(s) + 1) + ") " + s.title + "\n";
        }
        result = result + "\n";
        return result;
    }

    /**
     * Get the previous screen
     * @return A Screen instance
     */
    public Screen getPrev() {
        return this.prev;
    }
    
    /**
     * Set the previous screen
     * @param prev
     *        A screen instance
     */
    public void setPrev(Screen prev) {
        this.prev = prev;
    }
    
    /**
     * Get Screens in this Screen's menu
     * @return A list of Screen
     */
    public ArrayList<Screen> getMenu() {
        return this.menu;
    }
    
    /**
     * Add a menu item to this screens
     * @param item
     *        A Screen instance to add
     */
    public void addMenuItem(Screen item) {
        this.menu.add(item);
    }

}




















