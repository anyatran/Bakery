package screen;

import java.util.*;

/**
 * Screen for viewing inventory
 * @author rcj, anhtran9
 * @version 06/17/14
 */
public class ViewMenu extends Screen {
    /**
     * Constructor to set the screen title
     */
    public ViewMenu() {
        this.title = "*** View menu ***";
    }

    /**
     * Display the store inventory
     */
    @SuppressWarnings("unused")
    void run() {
        System.out.println(Screen.state.getMenu());
        System.out.println("Press any key to go back");
        Scanner scan = new Scanner(System.in);
        String keyString = scan.next();
        this.prev.run();
    }
}
