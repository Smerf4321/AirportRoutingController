/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flight;

import airportroutingcontroller.Bays;
import java.util.Map;

/**
 *
 * @author v8243060
 */
public class Waiting implements FlightState {

    @Override
    public void readyCheck(FlightClass flight) {
        
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
        if (bayFound = false){
            System.out.println("ERROR - NO EMPTY BAYS FOUND");
        }
    }
    
    private void taxingGuidance(Integer bay){
        System.out.println("Proceed to bay "+ bay);
    }
}
