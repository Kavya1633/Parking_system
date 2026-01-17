package Parking_System_design;

import Parking_System_design.Entity.Parking_spot;
import Parking_System_design.Entity.Vehicle;
import Parking_System_design.Parking_lot.parking_levels;

import java.time.LocalDateTime;

public class Ticket {
    private final Vehicle vehicle;
    private final parking_levels level;
    private final Parking_spot spot;
    private final LocalDateTime entrytime;

    public Ticket(Vehicle vehicle, parking_levels level, Parking_spot spot) {
        this.vehicle = vehicle;
        this.level = level;
        this.spot = spot;
        this.entrytime = LocalDateTime.now();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getEntrytime() {
        return entrytime;
    }

    public parking_levels getLevel() {
        return level;
    }

    public Parking_spot getSpot() {
        return spot;
    }
}
