/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flight;

/**
 * Interface that gives the states and the FlightClass the readyCheck method
 * @author v8243060
 */
public interface FlightState {
    /**
     * A method to be overridden by the classes that implement the interface
     * Checks if the plane is ready to depart
     * @param flight instantiated FlightClass 
     */
    boolean readyCheck(FlightClass flight);
    
    /**
     * A method to be overridden by the classes that implement the interface
     * Checks if the flight has clearance to land
     * @param flight instantiated FlightClass
     */
    boolean arriving(FlightClass flight);
    
    /**
     * A method to be overridden by the classes that implement the interface
     * Checks if the flight has clearance to depart
     * @param flight instantiated FlightClass
     */
    boolean departing(FlightClass flight);
}
