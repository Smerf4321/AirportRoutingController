/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportroutingcontroller;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author v8243060
 */
public class Runways {
    public static HashMap<String, Boolean> runways;
    static {
        runways = new HashMap<>();
        runways.put("8L", false);
    }
}
