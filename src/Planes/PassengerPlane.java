package Planes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This is a class for the passenger plane
 * @author v8243060
 */
public class PassengerPlane extends Plane{
    
    /**
     * Maximum number of passengers the plane can fit
     */
    private int maximumPassengers;
    
    /**
     * Maximum amount of fuel the plane can carry (in litres)
     */
    private int maximumFuel;

    /**
     * Returns the maximum fuel the plane can carry 
     * @return Fuel in litres
     */
    public int getMaxFuel(){
        return maximumFuel;
    }
    
    public PassengerPlane(String serialNumber, boolean priority, String model, String company, int maxPass, int maxFuel){
        this.serialNumber = serialNumber;
        this.priority = priority;
        this.model = model;
        this.company = company;
        this.maximumPassengers = maxPass;
        this.maximumFuel = maxFuel;
    }
}