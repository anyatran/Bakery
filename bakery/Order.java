package bakery;
import java.util.*;
import java.util.Map.Entry;

/**
 * Manages orders
 * @author rcj, anhtran9
 * @version 06/17/14
 */
public class Order {
    /** The client who placed this order */
    private Client client;
    /** A unique id representing this order */
    private Integer id;
    /** The date the order was placed */
    private String orderDate;
    /** The date the order was scheduled for pickup/delivery */
    private String pickupDate;
    /** The items in this order */
    private HashMap<Item, Integer> items;
    /** Whether or not the customer has paid */
    private Boolean paid;
    /** Whether or not this customer is applying a discount */
    private Boolean discount;
    /** Notes associated with this order */
    private String notes;

    /**
     * Constructor for updating an existing order
     * @param client
     *        The client who placed this order
     * @param id
     *        A unique id representing this order
     * @param orderDate
     *        The date the order was placed
     * @param pickupDate
     *        The date the order was scheduled for pickup/delivery
     * @param items
     *        The items in this order
     * @param paid
     *        Whether or not the customer has paid
     * @param discount
     *        Whether or not this customer is applying a discount
     * @param notes
     *        Notes associated with this order
     */
    public Order(Client client, Integer id, String orderDate,
            String pickupDate, HashMap<Item, Integer> items, 
            Boolean paid, Boolean discount, String notes) {
        this.client = client;
        this.id = id;
        this.orderDate = orderDate;
        this.pickupDate = pickupDate;
        this.items = items;
        this.paid = paid;
        this.discount = discount;
        this.notes = notes;
    }

    /**
     * Get this order's id
     * @return This order's id
     */
    public Integer getId() {
        return this.id;
    }

    /** 
     * Set this order's id
     * @param id
     *        The order's new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get the client who placed this order
     * @return An instance of Client
     */
    public Client getClient() {
        return this.client;
    }

    /**
     * Set the client who placed this order
     * @param client
     *        The new client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Get the date the order was placed
     * @return The date the order was placed
     */
    public String getOrderDate() {
        return this.orderDate;
    }

    /**
     * Set the date the order was placed
     * @param date
     *        The new date the order was placed
     */
    public void setOrderDate(String date) {
        this.orderDate = date;
    }

    /**
     * Get the date the order is scheduled for pickup/delivery
     * @return The date the order is scheduled for pickup/delivery
     */
    public String getPickupDate() {
        return this.pickupDate;
    }

    /**
     * Set the date the order is scheduled for pickup/delivery
     * @param date
     *        The date the order is scheduled for pickup/delivery
     */
    public void setPickupDate(String date) {
        this.pickupDate = date;
    }

    /**
     * Get the items associated with this order
     * @return The items in this order
     */
    public HashMap<Item, Integer> getItems() {
        return this.items;
    }

    /**
     * Set the items in this order
     * @param items
     *        The new set of items in this order
     */
    public void setItems(HashMap<Item, Integer> items) {
        this.items = items;
    }

    /**
     * Determine whether or not this order was paid for
     * @return True if the order was paid for, false otherwise
     */
    public boolean getPaid() {
        return this.paid;
    }

    /**
     * Update the order's payment status
     * @param paid
     *        Whether or not the order was paid
     */
    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    /**
     * Determine whether or not this order applied a discount
     * @return True if the order applied a discount, false otherwise
     */
    public boolean getDiscount() {
        return this.discount;
    }

    /**
     * Update the discount status of the order
     * @param discount
     *        Whether or not this order applied a discount
     */
    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    /**
     * Get notes associated with this order
     * @return Notes associated with this order
     */
    public String getNotes() {
        return this.notes;
    }

    /**
     * Set notes associated with this order
     * @param notes
     *        New note associated with this order
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * Get the available discount on the client's card
     * @return The client's total available discount
     */
    public double getReward() {
        return this.client.getCard().getReward();
    }

    /**
     * Get the order total without applying a discount
     * @return The order total in dollars and cents
     */
    public Double total() {
        double total = 0;
        for (Entry<Item, Integer> entry: this.items.entrySet()) {
            total += entry.getValue() * entry.getKey().getPrice();
        }
        return total;   
    }

    /**
     * Get the order total after discounts have been applied
     * @return The order total in dollars and cents
     */
    public Double totalDue() {
        if (this.discount) {
            return this.applyDiscount(this.total());
        }
        else {
            return this.total();
        }
    }

    /**
     * Apply a discount to this order
     * @param total
     *        The total before applying the discount
     * @return The new total after applying the discount
     */
    public Double applyDiscount(Double total) {
        if (total <= this.getReward()) {
            this.client.getCard().deductReward(total);
            total = 0.0;
            return total;
        }
        else {
            total -= this.client.getCard().getReward();
            this.client.getCard().clearReward();
            return total;
        }
    }

    /**
     * Return a string representation of this order
     * @return A string representation of this order
     */
    public String toString() {
        return "Client: " + client.getLastName() + "\n" + 
                "Order ID: " + this.id.toString() + "\n" + 
                "Items Ordered: \n" + this.printOrderedItems() + "\n" +
                "Order Date: " + this.orderDate.toString() + "\n" + 
                "Pickup Date: " + this.pickupDate.toString() + "\n" + 
                "Paid?: " + this.paid.toString() + "\n" + 
                "Total: $" + this.total().toString() + "\n" +
                "Discount Applied?: " + this.discount.toString() + "\n" + 
                "Total Due: $" + this.totalDue().toString() + "\n" +
                "Notes: " + this.notes + "\n";
    }
    
    /**
     * Print all the items ordered
     * @return A string representation of all the items ordered
     */
    String printOrderedItems() {
        String result = "";
        for (Entry<Item, Integer> e: this.items.entrySet()) {
            result = result + "   " + e.getKey().getName() + 
                    " ........................ " + 
                    e.getValue().toString() + " * $" + 
                    e.getKey().getPrice().toString() +  "   \n";   
        }
        return result;
    }

    /**
     * convert rewards to string
     * @return string representation of the reward amount
     */
    public String rewardToString() {
        return this.getClient().getCard().getReward().toString();
    }
    
    /**
     * convert points to string
     * @return string representation of points 
     */
    public String pointsToString() {
        return this.getClient().getCard().getPoints().toString();
    }
}
