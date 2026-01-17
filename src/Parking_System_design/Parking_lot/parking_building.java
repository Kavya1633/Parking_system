package Parking_System_design.Parking_lot;

import Parking_System_design.Entity.Parking_spot;
import Parking_System_design.Entity.Vehicle;
import Parking_System_design.Ticket;


import java.util.List;

public class parking_building {
    private List<parking_levels> levels;

    public parking_building(List<parking_levels> levels) {
        this.levels = levels;
    }

    Ticket allocate(Vehicle vehicle) {
        for(parking_levels level : levels) {
            if(level.hasAvailability(vehicle.getVehicleType())){
               Parking_spot spot= level.park(vehicle.getVehicleType());
               if(spot!=null) {
                   Ticket ticket = new Ticket(vehicle, level, spot);
                   System.out.println("Parking allocated at level " +
                           level.getLevelNo() + " at spot " +
                           spot.getSpotId());

                   return ticket;
               }
            }
        }

        throw new RuntimeException("Parking is Full!!");
    }

    void release(Ticket ticket) {
        ticket.getLevel()
                .unpark(ticket.getSpot(),
                        ticket.getVehicle().getVehicleType());

    }
}
