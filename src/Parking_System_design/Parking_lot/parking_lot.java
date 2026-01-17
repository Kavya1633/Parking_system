package Parking_System_design.Parking_lot;

import Parking_System_design.Entity.Vehicle;
import Parking_System_design.PaymentType.Payment;
import Parking_System_design.Ticket;

public class parking_lot {

    private parking_building building;
    private Entrance_Gate entrance_gate;
    private Exit_Gate exit_gate;

    public parking_lot(parking_building building, Entrance_Gate entrance_gate, Exit_Gate exit_gate) {
        this.building = building;
        this.entrance_gate = entrance_gate;
        this.exit_gate = exit_gate;
    }

    public Ticket vehicleArrives(Vehicle vehicle){
        return entrance_gate.enter(building, vehicle);
    }

    public void exitVehicle(Ticket ticket, Payment payment){
         exit_gate.exit(building,ticket,payment);
    }

}


