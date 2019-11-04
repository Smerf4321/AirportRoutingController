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
 * This state class represents the behaviour of the flight while it is in the air
 * @author v8243060
 */
public class InFlight implements FlightState {
    
    private boolean runwayOpen = false;
    
    /**
     * This method checks whether the flight has clearance to land/depart
     * @param flight instantiated FlightClass, should be passed automatically by readyCheck of this class
     */
    private void cleranceCheck(FlightClass flight) {
        if (runwayOpen){
            flight.giveClearance();
            System.out.println("You have clearance flight " + flight.getFlightNumber());
        }
        else {
            System.out.println("You don't have clearance flight "+ flight.getFlightNumber());
        }
    }

    /**
     * readyCheck override specific for the InFlight class
     * It checks if there is a free runway and if the flight has the clearance to land/depart
     * @param flight instantiated FlightClass
     */
    @Override
    public void readyCheck(FlightClass flight) {
        cleranceCheck(flight);
        
        //Checks for a free runway
        for (Map.Entry r : Runways.runways.entrySet()){
            if (!((Boolean)r.getValue()).booleanValue()){
                System.out.println("Runway "+ r.getKey() + " is clear");
                runwayOpen = true;
                r.setValue(new Boolean(true));
                break;
            }
        }
        
        //Gets the clearance to land/depart
        if (flight.getClearance()){
            System.out.println("Flight " + flight.getFlightNumber() + " landing");
            flight.setState(new Waiting());
        }
    }
}
