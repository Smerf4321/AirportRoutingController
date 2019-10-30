/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flight;

import airportroutingcontroller.Runways;
import java.util.Iterator;
import java.util.Map;
/**
 *
 * @author v8243060
 */
public class InFlight implements FlightState {
    
    boolean runwayOpen = false;
    
    public void cleranceCheck(FlightClass flight) {
        if (runwayOpen){
            flight.giveClearance();
            System.out.println("You have clearance flight " + flight.getFlightNumber());
        }
        else {
            System.out.println("You don't have clearance flight "+ flight.getFlightNumber());
        }
    }

    @Override
    public void readyCheck(FlightClass flight) {
        cleranceCheck(flight);
        
        
        for (Map.Entry r : Runways.runways.entrySet()){
            if (!((Boolean)r.getValue()).booleanValue()){
                System.out.println("Runway "+ r.getKey() + " is clear");
                runwayOpen = true;
                r.setValue(new Boolean(true));
                break;
            }
        }
        
        if (flight.getClearance()){
            System.out.println("Flight " + flight.getFlightNumber() + " landing");
            flight.setState(new Waiting());
        }
    }
}
