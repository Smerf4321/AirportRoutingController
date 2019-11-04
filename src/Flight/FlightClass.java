/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flight;

import Planes.PassangerPlane;
import Planes.Plane;
import java.util.HashMap;

/**
 *
 * @author v8243060
 */
public class FlightClass implements FlightState{
    
    private States state;
    protected PassangerPlane plane;
    private FlightState fs = new InFlight();
    
    private int flightNumber;
    private int bookedPassengers;
    private int passenegersOnboard;
    private HashMap<String, String> passangerList;
    private String destination;
    
    private boolean supplied;
    private int currentFuel;
    private int minimumFuel = 50;
    private boolean crewed;
    private boolean clearance;
    private boolean preventFurtherAction;
    
    
    FlightClass(PassangerPlane plane, int passengers, boolean supplied, int fuel, boolean crewed, States state, String destination, boolean clearance){
        
        this.plane = plane;
        this.bookedPassengers = passengers;
        this.supplied = supplied;
        this.currentFuel = fuel;
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
    
    public void giveClearance (){
        clearance = true;
    }
    
    public void revokeClearance(){
        clearance = false;
    }
    
    public boolean getClearance(){
        return clearance;
    }
    
    public int getFlightNumber(){
        return flightNumber;
    }
    
    public int getCurrentFuel(){
        return currentFuel;
    }
    
    public int getMinimumFuel(){
        return minimumFuel;
    }
    
    public int getMaximumFuel(){
        return plane.getMaxFuel();
    }
    
    public String getDestination(){
        return destination;
    }

    public void setState(FlightState state){
        fs = state;
    }
    
    public boolean isSupplied(){
        return supplied;
    }
    
    public boolean isCrewed(){
        return crewed;
    }
    
    public void crewDisembarked(){
        crewed = false;
    }
    
    public void crewEmbarked(){
        crewed = true;
    }
    
    public int getPassengersBooked(){
        return bookedPassengers;
    }
    
    public void passengersDisembarked(){
        passenegersOnboard=0;
    }
    
    public void passengersEmbarked(){
        passenegersOnboard = bookedPassengers;
    }
    
    public int getPassengersOnboard(){
        return passenegersOnboard;
    }
    
    public void refuel(){
        currentFuel = plane.getMaxFuel();
    }
    
    public void resupply(){
        supplied = true;
    }
    
    @Override
    public void readyCheck(FlightClass flight) {
        if (!preventFurtherAction){
            fs.readyCheck(this);
        }
    }
}
