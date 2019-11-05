/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportroutingcontroller;

import Flight.FlightClass;
import Flight.States;
import Planes.PassengerPlane;
import Planes.Plane;
import java.util.Scanner;

/**
 *
 * @author v8243060
 */
public class AirportRoutingController {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Plane p = new PassengerPlane("ACQ110", false, "Boeing 747", "Ryanair", 50, 100);
       FlightClass f = new FlightClass(23446, (PassengerPlane) p, 0, 20, false, 40, true, States.INFLIGHT, "London");
       
       Scanner k = new Scanner(System.in);
       
       while (true){
           String s = k.nextLine();
           if (s.equals("1")){
               f.arriving(f);
           }
           else if (s.equals("2")){
               f.departing(f);
           }
           else if (s.equals("3")){
               f.readyCheck(f);
           }
       }
    }
    
}
