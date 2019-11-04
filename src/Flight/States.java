/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flight;

/**
 * This enum stores all the states the plane can go through. 
 * @author v8243060
 */
public enum States {
    INFLIGHT,
    WAITING,
    PARKED,
    LOWFUEL,
    LOWSUPPLIES,
    NOCREWONBOARD,
    NOPASSENGERSONBOARD,
    PASSENGERSONBOARD
}
