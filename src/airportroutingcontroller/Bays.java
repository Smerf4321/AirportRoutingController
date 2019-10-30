/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

