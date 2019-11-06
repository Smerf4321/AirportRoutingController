/**
 * This package stores the arbitrary values that imitate other parts of the future system.
 */
package airportroutingcontroller;

import java.util.HashMap;

/**
 *Stores the arbitrary values for the runways the airport would have
 * @author v8243060
 */
public class Runways {
    
    /**
     * A static HashMap accessible from any part of the system.
     * Stores runway name as String and whether it's busy or not as boolean
     */
    public static HashMap<String, Boolean> runways;
    static {
        runways = new HashMap<>();
        runways.put("8L", false);
    }
    
    public static void changeRunwayTest(){
        runways.remove("8L");
        runways.put("8L", true);
    }
}
