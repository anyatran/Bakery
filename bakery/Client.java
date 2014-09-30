package bakery;

/**
 * Manages customer data 
 * @author rcj, anhtran9
 * @version 06/17/14
 *
 */
public class Client {
    /** A unique integer representing this client */
    private Integer id;
    /** The client's last name */
    private String lastName;
    /** The client's address */
    private String address;
    /** The client's city */
    private String city;
    /** The client's state */
    private String state;
    /** The client's zip code */
    private String zip;
    /** The client's loyalty card */
    private LoyaltyCard card;
    
    /**
     * Constructor for a new client (no loyalty card) 
     * @param id
     *        The client's id
     * @param lastName
     *        The client's last name
     * @param address
     *        The client's address
     * @param city
     *        The client's city
     * @param state
     *        The client's state
     * @param zip
     *        The client's zip code
     */
    public Client(Integer id, String lastName, String address, String city,
            String state, String zip) {
        this.id = id;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.card = new LoyaltyCard();
    }
    
    /**
     * Constructor for updating an existing client
     * @param id
     *        The client's id
     * @param lastName
     *        The client's last name
     * @param address
     *        The client's address
     * @param city
     *        The client's city
     * @param state
     *        The client's state
     * @param zip
     *        The client's zip code
     * @param card
     *        This client's loyalty card
     */
    public Client(Integer id, String lastName, String address, String city,
            String state, String zip, LoyaltyCard card) {
        this.id = id;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.card = card;
    }

    /**
     * Get this customer's loyalty card
     * @return A loyalty card instance
     */
    public LoyaltyCard getCard() {
        return this.card;
    }

    /**
     * Get this customer's id
     * @return A unique integer representing this customer
     */
    public Integer getId() {
        return this.id;
    }
    
    /**
     * Get this customer's last name
     * @return The customer's last name
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Get this customer's city
     * @return The customer's city
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Get this customer's state
     * @return The customer's state
     */
    public String getState() {
        return this.state;
    }

    /**
     * Get this customer's address
     * @return The customer's address
     */
    public String getAddress() {
        return this.address;
    }
    
    /**
     * Get this customer's zip code
     * @return The customer's zip code
     */
    public String getZipcode() {
        return this.zip;
    }

    /**
     * Set this customer's last name
     * @param newName
     *        The customer's new last name
     */
    public void setLastName(String newName) {
        this.lastName = newName;
    }

    /**
     * Set this customer's address
     * @param newAddress
     *        The customer's new address
     */
    public void setAddress(String newAddress) {
        this.address = newAddress;
    }

    /**
     * Set this customer's state
     * @param newState
     *        The customer's new state
     */
    public void setState(String newState) {
        this.state = newState;
    }

    /**
     * Set this customer's zip code
     * @param newZipcode
     *        The customer's new zip code
     */
    public void setZipcode(String newZipcode) {
        this.zip = newZipcode;
    }
    
    /**
     * Set this customer's city
     * @param newCity
     *        The customer's new city
     */
    public void setCity(String newCity) {
        this.city = newCity;
    }

    /**
     * Creates a string representation of the client
     * @return A string representation of the client
     */
    public String toString() {
        return "Client's ID: " + this.id.toString() + "\n" +
                "Last Name: " + this.lastName + "\n" +
                "Address: " + this.address + "\n" +
                "State: " + this.state + "\n" +
                "Zipcode: " + this.zip + "\n" +
                this.card.toString();
    }


}
