/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flight;

/**
 * This class represents the behaviour of the flight while low on fuel
 * @author v8243060
 */
public class LowFuel implements FlightState {

    /**
     * readyCheck override specific for the LowFuel class
     * calls the refuel method in flight
     * @param flight instantiated FlightClass
     */
    @Override
    public boolean readyCheck(FlightClass flight) {
        System.out.println("Refueling");
        flight.refuel();
        flight.setState(new Parked());
        return true;
        
        //commented out for presentation purposes!
        //the method will automatically call the readyCheck 
        //to automate the proces
        //flight.readyCheck(flight);
    }

    @Override
    public boolean arriving(FlightClass flight) {
        System.out.println("Error. Wrong method called.");
        return false;
    }

    @Override
    public boolean departing(FlightClass flight) {
        System.out.println("Error. Wrong method called.");
        return false;
    }
    
}
