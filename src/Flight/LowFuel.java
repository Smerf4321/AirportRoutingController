/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flight;

/**
 *
 * @author v8243060
 */
public class LowFuel implements FlightState {

    @Override
    public void readyCheck(FlightClass flight) {
        System.out.println("Refueling");
        flight.refuel();
        flight.setState(new Parked());
        flight.readyCheck(flight);
    }
    
}