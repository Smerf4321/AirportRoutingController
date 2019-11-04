/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flight;
import airportroutingcontroller.Location;
/**
 *
 * @author v8243060
 */
public class Parked implements FlightState {

    @Override
    public void readyCheck(FlightClass flight) {
        
        flight.revokeClearance();
        
        if (flight.getDestination().equals(Location.Location)){
            
            if(flight.getPassengersOnboard() > 0){
                flight.setState(new PassangersOnboard());
                flight.readyCheck(flight);
            }
            
            else if (flight.isCrewed()){
                System.out.println("Crew Disembarking");
                flight.crewDisembarked();
                flight.setState(new NoCrewOnboard());
            }
            
            else if (flight.getCurrentFuel() < flight.getMinimumFuel()){
                flight.setState(new LowFuel());
            
            }
            else if (!flight.isSupplied()){
                flight.setState(new LowSupplies());
            }
        }
        
        else if (!flight.getDestination().equals(Location.Location)){
            
            if (flight.getPassengersBooked() > 0){
                flight.setState(new NoPassangersOnboard());
            }
            
            else if (flight.isCrewed()){
                System.out.println("Crew Disembarking");
                flight.crewDisembarked();
                flight.setState(new NoCrewOnboard());
            }
            
            else if (flight.getCurrentFuel() < flight.getMinimumFuel()){
                flight.setState(new LowFuel());
            
            }
            else if (!flight.isSupplied()){
                flight.setState(new LowSupplies());
            }
        }
    }
    
}
