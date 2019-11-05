/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flight;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author v8243060
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({Flight.NoCrewOnboardTest.class, Flight.ParkedTest.class, Flight.FlightClassTest.class, Flight.WaitingTest.class, Flight.PassangersOnboardTest.class, Flight.InFlightTest.class, Flight.NoPassangersOnboardTest.class, Flight.LowSuppliesTest.class, Flight.LowFuelTest.class})
public class FlightSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
