package bakery;

/**
 * Manages store items and inventory
 * @author rcj, anhtran9
 * @version 06/17/14
 */
public class Item {
    /** A unique integer representing this item */
    private Integer id;
    /** The name of the item */
    private String name;
    /** The item's category */
    private String category;
    /** The item's price */
    private Double price;
    /** The number of items available */
    private Integer quantity;
    
    /**
     * Constructor for adding a new item
     * @param id
     *        A unique integer representing this item
     * @param name
     *        The name of the item
     * @param category
     *        The item's category
     * @param price
     *        The item's price
     * @param quantity
     *        The number of items available
     */
    public Item(Integer id, String name, String category, Double price, 
            Integer quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Get this item's id
     * @return This item's id
     */
    public Integer getId() {
        return this.id;
    }
    
    /**
     * Set this item's id
     * @param id
     *        The item's new id
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * Get this item's price
     * @return This item's price
     */
    public Double getPrice() {
        return this.price;
    }
    
    /**
     * Set this item's price
     * @param price
     *        The item's new price
     */
    public void setPrice(Double price) {
        this.price = price;
    }
    
    /**
     * Get this item's category
     * @return The item's category
     */
    public String getCategory() {
        return this.category;
    }
    
    /**
     * Set this item's category
     * @param category
     *        The item's new category
     */
    public void setCategory(String category) {
        this.category = category;
    }
    
    /**
     * Get the name of this item
     * @return The name of this item
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Set the name of this item
     * @param name
     *        The item's new name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Get the amount of this item that is available
     * @return The amount of this item in stock
     */
    public Integer getQuantity() {
        return this.quantity;
    }
    
    /**
     * Set the amount of this item that is available
     * @param quantity
     *        The new amount of the item in stock
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
