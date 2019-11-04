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
public class NoPassangersOnboard implements FlightState {

    @Override
    public void readyCheck(FlightClass flight) {
        System.out.println("Passengers embarking");
        flight.passengersEmbarked();
        flight.setState(new Parked());
        flight.readyCheck(flight);
    }
    
}
