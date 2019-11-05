/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flight;
import airportroutingcontroller.Location;
import airportroutingcontroller.Runways;
import java.util.Map;
/**
 * This class represents the behaviour of the flight while parked
 * @author v8243060
 */
public class Parked implements FlightState {

    /**
     * readyCheck override specific for the Parked class
     * checks whether the flight is at it's destination, is crewed, has enough
     * fuel to depart and has enough supplies and changes the states accordingly
     * @param flight instantiated FlightClass
     */
    @Override
    public void readyCheck(FlightClass flight) {
        // takes away the clearance as the plane has alreayd landed and parked
        flight.revokeClearance();
        
        //checks if the airport is the flight destiantion
        //case for true
        if (flight.getDestination().equals(Location.Location)){
            
            //if there are passenegers on-board the method will change the state
            //of the flight to PassengersOnboard
            if(flight.getPassengersOnboard() > 0){
                System.out.println("Passengers onboard");
                flight.testOutput += ("PO");
                flight.setState(new PassengersOnboard());
            }
            
            //if the current fuel is lower than minimum fuel the method will 
            //change the state of the flight to PassengersOnboard
            else if (flight.getCurrentFuel() < flight.getMinimumFuel()){
                System.out.println("Low Fuel");
                flight.testOutput += ("F");
                flight.setState(new LowFuel());
            }
            
            //if the flight is not supplied the method will 
            //change the state of the flight to LowSupplies
            else if (!flight.isSupplied()){
                System.out.println("Low Supplies");
                flight.testOutput += ("S");
                flight.setState(new LowSupplies());
            }
            
            //should fire only when the plane is ready to depart e.g. 
            //is full on fuel, is supplied, crewed and passengers and onboard
            else {
                System.out.println("Ready");
                flight.testOutput += ("1");
                flight.departing(flight);
            }
        }
        
        //case for false
        else if (!flight.getDestination().equals(Location.Location)){
            flight.revokeClearance();
            
            //if there are passangers booked for the flight the method will 
            //change the state of the flight to NoPassengersOnboard
            if (flight.getPassengersBooked() > 0){
                System.out.println("Passengere ready to board");
                flight.testOutput += ("PB");
                flight.setState(new NoPassengersOnboard());
            }
            
            //if the current fuel is lower than minimum fuel the method will 
            //change the state of the flight to PassengersOnboard
            else if (flight.getCurrentFuel() < flight.getMinimumFuel()){
                System.out.println("Low Fuel");
                flight.testOutput += ("F");
                flight.setState(new LowFuel());
            
             //if the flight is not supplied the method will 
            //change the state of the flight to LowSupplies   
            }
            else if (!flight.isSupplied()){
                System.out.println("Low Supplies");
                flight.testOutput += ("S");
                flight.setState(new LowSupplies());
            }
            
            //should fire only when the plane is ready to depart e.g. 
            //is full on fuel, is supplied, crewed and passengers and onboard
            else {
                System.out.println("Ready");
                flight.testOutput += ("1");
                flight.departing(flight);
            }
        }
    }

    /**
     * Empty arriving method
     * @param flight instantiated FlightClass
     */
    @Override
    public void arriving(FlightClass flight) {}

    /**
     * Checks of there are any available runways for the flight
     * @param flight 
     */
    @Override
    public void departing(FlightClass flight) {
        boolean runwayOpen = false;
        //Checks for a free runway and gives taxing guidance to the flight
        for (Map.Entry r : Runways.runways.entrySet()){
            if (!((Boolean)r.getValue()).booleanValue()){
                System.out.println("Proceed to " + r.getKey() + " runway");
                flight.testOutput += ("1");
                runwayOpen = true;
                r.setValue(new Boolean(true));
                flight.setRunway((String)r.getKey());
                flight.setState(new Waiting());
                break;
            }
        }
        //in case there are no empty runways
        if (!runwayOpen){
            System.out.println("There aren't any empty runways flight  " + flight.getFlightNumber());
            flight.testOutput += ("0");
        }
    }
    
}
