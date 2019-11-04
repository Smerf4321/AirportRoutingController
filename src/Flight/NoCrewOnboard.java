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
public class NoCrewOnboard implements FlightState {

    @Override
    public void readyCheck(FlightClass flight) {
        System.out.println("Crew Embarking");
        flight.crewEmbarked();
        flight.setState(new Parked());
        flight.readyCheck(flight);
    }
    
}