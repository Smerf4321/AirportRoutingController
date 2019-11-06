/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flight;

import Planes.PassengerPlane;
import Planes.Plane;
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
public class FlightClassTest {
    
    public FlightClassTest() {
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
     * Test of the constructor validation with Parked
     */
    @Test
    public void testConstructorParked() {
        System.out.println("giveClearance");
        FlightClass instance = new FlightClass(23446, (PassengerPlane)new PassengerPlane("ACQ110", false, "Boeing 747", "Ryanair", 50, 100), 0, 20, false, 40, true, States.PARKED, "London");
        assertEquals("P", instance.testOutput);
    }
    
    /**
     * Test of the constructor validation with an invalid state
     */
    @Test
    public void testConstructorAnyOther() {
        System.out.println("giveClearance");
        FlightClass instance = new FlightClass(23446, (PassengerPlane)new PassengerPlane("ACQ110", false, "Boeing 747", "Ryanair", 50, 100), 0, 20, false, 40, true, States.LOWFUEL, "London");
        assertEquals("E", instance.testOutput);
    }

    
    /**
     * Test of giveClearance method, of class FlightClass.
     */
    @Test
    public void testGiveClearance() {
        System.out.println("giveClearance");
        FlightClass instance = new FlightClass(23446, (PassengerPlane)new PassengerPlane("ACQ110", false, "Boeing 747", "Ryanair", 50, 100), 0, 20, false, 40, true, States.INFLIGHT, "London");
        instance.giveClearance();
        boolean result = instance.getClearance();
        assertTrue(result);
    }

    /**
     * Test of revokeClearance method, of class FlightClass.
     */
    @Test
    public void testRevokeClearance() {
        System.out.println("giveClearance");
        FlightClass instance = new FlightClass(23446, (PassengerPlane)new PassengerPlane("ACQ110", false, "Boeing 747", "Ryanair", 50, 100), 0, 20, false, 40, true, States.INFLIGHT, "London");
        instance.revokeClearance();
        boolean result = instance.getClearance();
        assertFalse(result);
    }

    /**
     * Test of refuel method, of class FlightClass.
     */
    @Test
    public void testRefuel() {
        System.out.println("refuel");
        FlightClass instance = new FlightClass(23446, (PassengerPlane)new PassengerPlane("ACQ110", false, "Boeing 747", "Ryanair", 50, 100), 0, 20, false, 40, true, States.INFLIGHT, "London");
        instance.refuel();
        assertEquals(100, instance.getCurrentFuel());
    }

    /**
     * Test of resupply method, of class FlightClass.
     */
    @Test
    public void testResupply() {
        System.out.println("resupply");
        FlightClass instance = new FlightClass(23446, (PassengerPlane)new PassengerPlane("ACQ110", false, "Boeing 747", "Ryanair", 50, 100), 0, 20, false, 40, true, States.INFLIGHT, "London");
        instance.resupply();
        assertTrue(instance.isSupplied());
    }

    /**
     * Test of setBay method, of class FlightClass.
     */
    @Test
    public void testSetBay() {
        System.out.println("setBay");
        Integer bay = 1;
        FlightClass instance = new FlightClass(23446, (PassengerPlane)new PassengerPlane("ACQ110", false, "Boeing 747", "Ryanair", 50, 100), 0, 20, false, 40, true, States.INFLIGHT, "London");
        instance.setBay(bay);
        assertEquals(bay, instance.getBay());
    }

    /**
     * Test of setRunway method, of class FlightClass.
     */
    @Test
    public void testSetRunway() {
        System.out.println("setRunway");
        String runway = "9R";
        FlightClass instance = new FlightClass(23446, (PassengerPlane)new PassengerPlane("ACQ110", false, "Boeing 747", "Ryanair", 50, 100), 0, 20, false, 40, true, States.INFLIGHT, "London");
        instance.setRunway(runway);
        assertEquals(runway, instance.getRunway());
    }

    /**
     * Test prevent further action for readyCheck
     */
    @Test
    public void testReadyCheckPrevent() {
        System.out.println("readyCheckPrevent");
        FlightClass instance = new FlightClass(23446, (PassengerPlane)new PassengerPlane("ACQ110", false, "Boeing 747", "Ryanair", 50, 100), 0, 20, false, 40, true, States.INFLIGHT, "London");
        instance.preventFurtherActionTest();
        instance.readyCheck(instance);
        assertEquals("0", instance.testOutput);
    }

    /**
     * Test prevent further action for arriving
     */
    @Test
    public void testArrivingPrevent() {
        System.out.println("arrivingPrevent");
        FlightClass instance = new FlightClass(23446, (PassengerPlane)new PassengerPlane("ACQ110", false, "Boeing 747", "Ryanair", 50, 100), 0, 20, false, 40, true, States.INFLIGHT, "London");
        instance.preventFurtherActionTest();
        instance.arriving(instance);
        assertEquals("0", instance.testOutput);
    }

    /**
     * Test prevent further action for departing
     */
    @Test
    public void testDepartingPrevent() {
        System.out.println("departingPrevent");
        FlightClass instance = new FlightClass(23446, (PassengerPlane)new PassengerPlane("ACQ110", false, "Boeing 747", "Ryanair", 50, 100), 0, 20, false, 40, true, States.INFLIGHT, "London");
        instance.preventFurtherActionTest();
        instance.departing(instance);
        assertEquals("0", instance.testOutput);
    }
    
    
    /**
     * Test checks action for readyCheck
     */
    @Test
    public void testReadyCheck() {
        System.out.println("readyCheck");
        FlightClass instance = new FlightClass(23446, (PassengerPlane)new PassengerPlane("ACQ110", false, "Boeing 747", "Ryanair", 50, 100), 0, 20, false, 40, true, States.INFLIGHT, "London");
        instance.readyCheck(instance);
        assertEquals("1", instance.testOutput);
    }

    /**
     * Test prevent further action for arriving
     */
    @Test
    public void testArriving() {
        System.out.println("arriving");
        FlightClass instance = new FlightClass(23446, (PassengerPlane)new PassengerPlane("ACQ110", false, "Boeing 747", "Ryanair", 50, 100), 0, 20, false, 40, true, States.INFLIGHT, "London");
        instance.arriving(instance);
        assertEquals("1", instance.testOutput);
    }

    /**
     * Test prevent further action for departing
     */
    @Test
    public void testDeparting() {
        System.out.println("departing");
        FlightClass instance = new FlightClass(23446, (PassengerPlane)new PassengerPlane("ACQ110", false, "Boeing 747", "Ryanair", 50, 100), 0, 20, false, 40, true, States.INFLIGHT, "London");
        instance.departing(instance);
        assertEquals("1", instance.testOutput);
    }
}
