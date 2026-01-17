package Parking_System_design.Parking_lot;

import Parking_System_design.Entity.Vehicle;
import Parking_System_design.Ticket;

public class Entrance_Gate {

    public Ticket enter(parking_building building, Vehicle vehicle) {
        return building.allocate(vehicle);
    }


}
