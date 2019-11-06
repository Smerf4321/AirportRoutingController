/**
 * This package stores the arbitrary values that imitate other parts of the future system.
 */
package airportroutingcontroller;

import java.util.HashMap;

/**
 * Stores the arbitrary values for the bays the airport would have
 * @author v8243060
 */
public class Bays { 
    
    /**
     * A static HashMap accessible from any part of the system.
     * Stores bay number as integer and whether it's occupied or not as boolean
     */
   public static HashMap<Integer,Boolean> bays;
   static {
       bays = new HashMap<>();
       bays.put(1, false);
   }
   
   public static void changeBayTest(){
       bays.remove(1); 
       bays.put(1, true);
    }
}


