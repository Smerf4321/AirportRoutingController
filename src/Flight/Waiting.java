/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flight;

import airportroutingcontroller.Bays;
import airportroutingcontroller.Runways;
import java.util.Map;

/**
 * This class represents the behaviour of the flight while waiting
 * @author v8243060
 */
public class Waiting implements FlightState {

    /**
     * Empty readyCheck method
     * @param flight instantiated FlightClass
     */
    @Override
    public void readyCheck(FlightClass flight) {}
    
    /**
     * This method displays the taxing instructions for the arriving flight
     * @param bay Integer, bay the flight is taxing to
     */
    private void taxingGuidance(FlightClass flight, Integer bay){
        System.out.println("Proceed to bay "+ bay);
        flight.testOutput = ("1");
    }

    /**
     * arriving override specific for the Waiting class
     * checks for an empty bay and then displays the instructions to guide the
     * flight into that bay
     * @param flight instantiated FlightClass
     */
    @Override
    public void arriving(FlightClass flight) {
        //checks for an empty bay and gives taxing guidance to the flight
        boolean bayFound = false;
        for (Map.Entry r : Bays.bays.entrySet()){
            if (!(boolean)r.getValue()){
                taxingGuidance(flight, (Integer)r.getKey());
                bayFound = true;
                System.out.println(r.getValue());
                flight.setBay((Integer)r.getKey());
                flight.setState(new Parked());
                break;
            }
        }
        
        //in case the bay was not found the error is displayed
        if (bayFound == false){
            System.out.println("ERROR - NO EMPTY BAYS FOUND");
            flight.testOutput = ("0");
        }
        else {
            Bays.bays.replace(flight.getBay(), (new Boolean (false)));
        }
    }

    /**
     * departing override specific for the Waiting class
     * checks for clearance of the flight
     * @param flight instantiated FlightClass
     */
    @Override
    public void departing(FlightClass flight) {
        
        //presentation sake UNCOMMENT FOR PRESENTATION!
        //flight.giveClearance();
        
        if (flight.getClearance()){
            System.out.println("You can depart");
            flight.testOutput += ("1");
            flight.setState(new InFlight());
        }
        else {
            System.out.println("You don't have clearance to depart yet");
            flight.testOutput += ("0");
        }
    }
}
