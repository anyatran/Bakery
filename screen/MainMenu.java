package screen;

import java.util.Scanner;

/**
 * The parent screen
 * @author rcj, anhtran9
 * @version 06/17/14
 *
 */
public class MainMenu extends Screen {
    /**
     * Constructor to set the screen title
     */
    public MainMenu() {
        this.title = "*** Main Menu ***";
    }

   
    /**
     * Display menu options
     */
    public void run() {
        System.out.println(this.toString());
        
        while (true) {
            try {
                System.out.println("Select menu item: ");
                Scanner scan = new Scanner(System.in);
                String input = scan.next();
                System.out.println(input);
                this.keyHandler(input);
                break;
            }
            catch (RuntimeException e) {
                System.out.println("Invalid menu item");
            }
        }
    }

}
