/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flight;

import Planes.PassengerPlane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author v8243060
 */
public class PassangersOnboardTest {
    
    public PassangersOnboardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of readyCheck method, of class PassengersOnboard.
     */
    @Test
    public void testReadyCheck() {
        System.out.println("readyCheck");
        FlightClass flight = new FlightClass(23446, (PassengerPlane)new PassengerPlane("ACQ110", false, "Boeing 747", "Ryanair", 50, 100), 0, 20, false, 40, true, States.INFLIGHT, "London");
        PassengersOnboard instance = new PassengersOnboard();
        assertTrue(instance.readyCheck(flight));
    }
    
    
    /**
     * Test of departing method, which should return error
     */
    @Test
    public void testDeparting() {
        System.out.println("departing");
        FlightClass flight = new FlightClass(23446, (PassengerPlane)new PassengerPlane("ACQ110", false, "Boeing 747", "Ryanair", 50, 100), 0, 20, false, 40, true, States.INFLIGHT, "London");
        PassengersOnboard instance = new PassengersOnboard();
        assertFalse(instance.departing(flight));
    }
    
    
    /**
     * Test of arriving method, which should return error
     */
    @Test
    public void testArriving() {
        System.out.println("arriving");
        FlightClass flight = new FlightClass(23446, (PassengerPlane)new PassengerPlane("ACQ110", false, "Boeing 747", "Ryanair", 50, 100), 0, 20, false, 40, true, States.INFLIGHT, "London");
        PassengersOnboard instance = new PassengersOnboard();
        assertFalse(instance.arriving(flight));
    }
}
