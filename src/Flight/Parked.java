/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flight;
import airportroutingcontroller.Location;
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
                flight.setState(new PassangersOnboard());
                flight.readyCheck(flight);
            }
            
            //if there is crew on-board, the method will change it to false
            // and then will change the state of the flight to NoCrewOnboard
            else if (flight.isCrewed()){
                System.out.println("Crew Disembarking");
                flight.crewDisembarked();
                flight.setState(new NoCrewOnboard());
            }
            
            //if the current fuel is lower than minimum fuel the method will 
            //change the state of the flight to PassengersOnboard
            else if (flight.getCurrentFuel() < flight.getMinimumFuel()){
                flight.setState(new LowFuel());
            }
            
            //if the flight is not supplied the method will 
            //change the state of the flight to LowSupplies
            else if (!flight.isSupplied()){
                flight.setState(new LowSupplies());
            }
        }
        
        //case for false
        else if (!flight.getDestination().equals(Location.Location)){
            
            //if there are passangers booked for the flight the method will 
            //change the state of the flight to NoPassangersOnboard
            if (flight.getPassengersBooked() > 0){
                flight.setState(new NoPassangersOnboard());
            }
            
            //if the current fuel is lower than minimum fuel the method will 
            //change the state of the flight to PassengersOnboard
            else if (flight.getCurrentFuel() < flight.getMinimumFuel()){
                flight.setState(new LowFuel());
            
             //if the flight is not supplied the method will 
            //change the state of the flight to LowSupplies   
            }
            else if (!flight.isSupplied()){
                flight.setState(new LowSupplies());
            }
        }
    }
    
}
