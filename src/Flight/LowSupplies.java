/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flight;

/**
 * This class represents the behaviour of the flight while low on supplies
 * @author v8243060
 */
public class LowSupplies implements FlightState {

    /**
     * readyCheck override specific for the LowSupplies class
     * calls the resupply method of the flight
     * @param flight instantiated FlightClass
     */
    @Override
    public void readyCheck(FlightClass flight) {
        System.out.println("Resuppling");
        flight.resupply();
        flight.setState(new Parked());
        
        //the method will automatically call the readyCheck 
        //to automate the process
        flight.readyCheck(flight);
    }
    
}
