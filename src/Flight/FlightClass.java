/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flight;

import Planes.Plane;

/**
 *
 * @author v8243060
 */
public class FlightClass implements FlightState{
    
    Plane plane;
    int passengers;
    boolean supplied;
    int fuel;
    boolean crewed;
    States state;
    FlightState fs = new InFlight();
    String destination;
    boolean clearance;
    
    
    FlightClass(Plane plane, int passengers, boolean supplied, int fuel, boolean crewed, States state, String destination, boolean clearance){
        
        this.plane = plane;
        this.passengers = passengers;
        this.supplied = supplied;
        this.fuel = fuel;
        this.crewed = crewed;
        this.destination = destination;
        this.clearance = clearance;
        
        if (state == States.INFLIGHT){
            this.state = state;
        }
        else if (state == States.PARKED){
            this.state = state;
            fs = new Parked();
        }
        else {
            System.out.println("Error. Plane can only be added to the system if it's either arriving or parked.");
        }  
    }
    
    public void giveclearance (){
        clearance = true;
    }
    
    public void revokeclearance(){
        clearance = false;
    }

    @Override
    public void checkClearance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void taxingGuidance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void readyCheck() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
