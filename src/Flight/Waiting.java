/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flight;

import airportroutingcontroller.Bays;
import java.util.Map;

/**
 * This class represents the behaviour of the flight while waiting
 * @author v8243060
 */
public class Waiting implements FlightState {

    /**
     * readyCheck override specific for the Waiting class
     * checks for an empty bay and then displays the instructions to guide the
     * flight into that bay
     * @param flight instantiated FlightClass
     */
    @Override
    public void readyCheck(FlightClass flight) {
        
        //checks for an empty bay
        boolean bayFound = false;
        for (Map.Entry r : Bays.bays.entrySet()){
            if (!((Boolean)r.getValue()).booleanValue()){
                taxingGuidance((Integer)r.getKey());
                bayFound = true;
                r.setValue(new Boolean(true));
                flight.setState(new Parked());
                break;
            }
        }
        //in case the bay was not found the error is displayed
        if (bayFound = false){
            System.out.println("ERROR - NO EMPTY BAYS FOUND");
        }
    }
    
    /**
     * This method displays the taxing instructions for the plane
     * @param bay int, bay that the plane will dock at
     */
    private void taxingGuidance(Integer bay){
        System.out.println("Proceed to bay "+ bay);
    }
}
