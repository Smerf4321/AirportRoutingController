/**
 * This package stores the arbitrary values that imitate other parts of the future system.
 */
package airportroutingcontroller;

import java.util.HashMap;

/**
 *
 * @author v8243060
 */
public class Bays { 
   public static HashMap<Integer,Boolean> bays;
   static {
       bays = new HashMap<>();
       bays.put(1, false);
   }
}

