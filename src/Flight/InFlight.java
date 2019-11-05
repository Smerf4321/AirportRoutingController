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
    private void clearanceCheck(FlightClass flight) {
        if (!flight.getRunway().isEmpty()){
            flight.giveClearance();
            System.out.println("You have clearance flight " + flight.getFlightNumber());
            Runways.runways.replace(flight.getRunway(), new Boolean (false));
            flight.setState(new Waiting());
        }
        else {
            System.out.println("You don't have clearance flight "+ flight.getFlightNumber());
        }
    }

    /**
     * Empty readyCheck method
     * @param flight instantiated FlightClass
     */
    @Override
    public void readyCheck(FlightClass flight) {}
    
    /**
     * arriving method override specific for the InFlight class
     * It checks if there is a free runway and if the flight has the clearance 
     * to land
     * @param flight instantiated FlightClass
     */
    @Override
    public void arriving(FlightClass flight) {
        //Checks for a free runway
        for (Map.Entry r : Runways.runways.entrySet()){
            if (!((Boolean)r.getValue()).booleanValue()){
                flight.setRunway((String)r.getKey());
                r.setValue(new Boolean(true));
                break;
            }
        }
        clearanceCheck(flight);
    }

    /**
     * Empty departing method
     * @param flight instantiated FlightClass
     */
    @Override
    public void departing(FlightClass flight) {
    }
}
