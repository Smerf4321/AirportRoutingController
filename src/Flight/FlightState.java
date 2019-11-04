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
     * @param flight instantiated FlightClass 
     */
    void readyCheck(FlightClass flight);
}
