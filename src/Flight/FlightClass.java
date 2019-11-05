/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flight;

import Planes.PassengerPlane;
import Planes.Plane;
import java.util.HashMap;

/**
 * This class represents a flight in the system
 * @author v8243060
 */
public class FlightClass implements FlightState{
    
    /**
     * State of the flight as enum
     */
    private States state;
    
    /**
     * Stores the plane associated with the flight
     */
    private PassengerPlane plane;
    
    /**
     * Reference to the state class
     */
    private FlightState fs;
    
    /**
     * Identification number of the flight
     */
    private int flightNumber;
    
    /**
     * Number of passengers booked to embarked for this flight
     */
    private int bookedPassengers;
    
    /**
     * Number of passengers currently on board
     */
    private int passenegersOnboard;
    
    /**
     * The arbitrary list of passengers stored as a HashMap. 
     * Key is the seat
     * Value is the passenger name
     */
    private HashMap<String, String> passangerList;
    
    /**
     * Destination of the flight stored as a string
     */
    private String destination;
    
    /**
     * True if the flight is supplied, false otherwise
     */
    private boolean supplied;
    
    /**
     * The number of fuel currently stored in plane (in litres)
     */
    private int currentFuel;
    
    /**
     * Arbitrary minimum fuel a flight needs to take off
     */
    private int minimumFuel = 50;
    
    /**
     * True if there is crew on-board
     */
    private boolean crewed;
    
    /**
     * Whether the plane has clearance to land or takeoff
     */
    private boolean clearance;
    
    /**
     * Emergency stop that can be used by management
     */
    private boolean preventFurtherAction;
    
    /**
     * Stores bey the flight is occupying
     */
    private Integer bay;
    
    /**
     * stores which runway the plan is using
     */
    private String runway;
    
    /**
     * Creates the FlightClass object which represents the flight
     * @param flightNumber Identification of the flight
     * @param plane Plane that is associated with the flight
     * @param bookedPassengers Number of passengers booked for the flight
     * @param passenegersOnboard Number of passengers currently on-board
     * @param supplied Whether the plane has supplies 
     * @param fuel Current fuel 
     * @param crewed Whether the plane is crewed
     * @param state Current state (can be only InFlight or Parked)
     * @param destination String name of the airport thats the flight destination
     */
    public FlightClass(int flightNumber, PassengerPlane plane, int passenegersOnboard, int bookedPassengers, boolean supplied, int fuel, boolean crewed, States state, String destination){
        
        this.flightNumber = flightNumber;
        this.plane = plane;
        this.passenegersOnboard = passenegersOnboard;
        this.bookedPassengers = bookedPassengers;
        this.supplied = supplied;
        this.currentFuel = fuel;
        this.crewed = crewed;
        this.destination = destination;
        this.clearance = false;
        
        // check if the flight is in the correct state
        if (state == States.INFLIGHT){
            this.state = state;
            fs = new InFlight();
        }
        else if (state == States.PARKED){
            this.state = state;
            fs = new Parked();
        }
        // in the real system this would cause a critical error to be resolved by management/technicians
        // the flight should never be instatianted with states other than InFlight or Parked
        else {
            System.out.println("Error. Plane can only be added to the system if it's either arriving or parked.");
        }  
    }
    
    /**
     * Give clearance to the flight to land/takeoff
     */
    public void giveClearance (){
        clearance = true;
    }
    
    /**
     * Revoke clearance to the flight to land/takeoff
     */
    public void revokeClearance(){
        clearance = false;
    }
    
    /**
     * Returns the clearance of the flight
     * @return boolean
     */
    public boolean getClearance(){
        return clearance;
    }
    
    /**
     * Returns the flight number
     * @return int
     */
    public int getFlightNumber(){
        return flightNumber;
    }
    
    /**
     * Returns current fuel of the flight
     * @return int
     */
    public int getCurrentFuel(){
        return currentFuel;
    }
    
    /**
     * Returns the minimum fuel the flight needs to takeoff
     * @return int
     */
    public int getMinimumFuel(){
        return minimumFuel;
    }
    
    /**
     * Returns the maximum fuel the plane can store
     * @return int
     */
    public int getMaximumFuel(){
        return plane.getMaxFuel();
    }
    
    /**
     * Returns the destination as String
     * @return String
     */
    public String getDestination(){
        return destination;
    }

    /**
     * Sets the state to the passed state
     * @param state one of the flight States as a class
     */
    public void setState(FlightState state){
        fs = state;
    }
    
    /**
     * Returns whether the plane is supplied
     * @return boolean
     */
    public boolean isSupplied(){
        return supplied;
    }
    
    /**
     * Returns whether the plane is crewed
     * @return boolean
     */
    public boolean isCrewed(){
        return crewed;
    }
    
    /**
     * Sets crewed as false
     */
    public void crewDisembarked(){
        crewed = false;
    }
    
    /**
     * sets crewed as true
     */
    public void crewEmbarked(){
        crewed = true;
    }
    
    /**
     * Returns the number of passengers booked for the flight
     * @return int
     */
    public int getPassengersBooked(){
        return bookedPassengers;
    }
    
    /**
     * Sets the number of passengers on-board to zero
     */
    public void passengersDisembarked(){
        passenegersOnboard=0;
    }
    
    /**
     * Sets the number of passengers on-board to the number of passenger booked
     */
    public void passengersEmbarked(){
        passenegersOnboard = bookedPassengers;
    }
    
    /**
     * Returns the number of passengers on-board
     * @return int
     */
    public int getPassengersOnboard(){
        return passenegersOnboard;
    }
    
    /**
     * Sets the current fuel to the value of maximum fuel
     */
    public void refuel(){
        currentFuel = plane.getMaxFuel();
    }
    
    /**
     * Sets supplied as true
     */
    public void resupply(){
        supplied = true;
    }
    
    /**
     * Sets the bay the flight is to dock to
     * @param bay Integer
     */
    public void setBay(Integer bay){
        this.bay = bay;
    }
    
    /**
     * Gets the bay the flight is docked to
     * @return Integer
     */
    public Integer getBay(){
        return bay;
    }
    
    /**
     * Sets the runway the plane uses
     * @param runway String
     */
    public void setRunway(String runway){
        this.runway = runway;
    }
    
    /**
     * Gets the runway the plane uses
     * @return String
     */
    public String getRunway(){
        return runway;
    }
    
    /**
     * Checks if the plane is ready
     * It calls the readyCheck method of the current flight state class
     * @param flight passes itself, as the state classes need a reference to the variables stored in the flight class
     */
    @Override
    public void readyCheck(FlightClass flight) {
        //checks if there is an emergency stop activated
        if (!preventFurtherAction){
            fs.readyCheck(this);
        }
    }

    /**
     * Behaviour of the arriving plane
     * It calls the arriving method of the current flight state class
     * @param flight passes itself, as the state classes need a reference to the variables stored in the flight class
     */
    @Override
    public void arriving(FlightClass flight) {
        if (!preventFurtherAction){
            fs.arriving(this);
        }
    }

    /**
     * Behaviour of the departing plane
     * It calls the departing method of the current flight state class
     * @param flight passes itself, as the state classes need a reference to the variables stored in the flight class
     */
    @Override
    public void departing(FlightClass flight) {
        if (!preventFurtherAction){
            fs.departing(this);
        }
    }
}
