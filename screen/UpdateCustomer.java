package screen;

import java.util.Scanner;

import bakery.Client;

/**
 * Screen for updating customer data
 * @author rcj, anhtran9
 * @version 06/17/14
 */
public class UpdateCustomer extends Screen {
    /** The client we are concerned with */
    Client client;
    
    /**
     * Constructor to set the screen title
     */
    public UpdateCustomer() {
        this.title = "*** update customer ***";

    }
    
    /** Prompt the user for the new last name */
    private void updateLastName() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Set the last name [" + 
                this.client.getLastName() + "] : ");
        String lastName = scan.next();
        if (!lastName.equals("")) {
            client.setLastName(lastName);
        }
    }
    
    /** Prompt the user for the new address */
    private void updateAddress() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Set the address [" + client.getAddress() + "] : ");
        String address = scan.next();
        if (!address.equals("")) {
            client.setAddress(address);
        }
    }
    
    /** Prompt the user for the new city */
    private void updateCity() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Set the city [" + client.getCity() + "] : ");
        String city = scan.next();
        if (!city.equals("")) {
            client.setCity(city);
        }
    }
    
    /** Prompt the user for the new state */
    private void updateState() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Set the state [" + client.getState() + "] : ");
        String state = scan.next();
        if (!state.equals("")) {
            client.setState(state);
        }
    }
    
    /** Prompt the user for the new zip code */
    private void updateZip() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Set the zipcode [" + client.getZipcode() + "] : ");
        String zipcode = scan.next();
        if (!zipcode.equals("")) {
            client.setZipcode(zipcode);
        }
    }
    
    /**
     *  Overriding default key handler
     *  @param key
     *         The key entered by the user
     */
    public void keyHandler(String key) {
        if (key.equals("1")) {
            this.updateLastName();
        }
        else if (key.equals("2")) {
            this.updateAddress();
        }
        else if (key.equals("3")) {
            this.updateCity();
        }
        else if (key.equals("4")) {
            this.updateState();
        }
        else if (key.equals("5")) {
            this.updateZip();
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
        this.client = Screen.getValidClient();
        
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                System.out.println("1) Last Name");
                System.out.println("2) Address");
                System.out.println("3) City");
                System.out.println("4) State");
                System.out.println("5) Zip");
                System.out.println("Select a field to update [None]: ");
                this.keyHandler(scan.next());
                break;
            }
            catch (RuntimeException e) {
                System.out.println("Invalid menu item");
            }
        }
        
        System.out.print("Successfully updated customer, "
                + "press any key to continue...");
        Scanner scan = new Scanner(System.in);
        scan.next();
        this.prev.run();

    }

}
