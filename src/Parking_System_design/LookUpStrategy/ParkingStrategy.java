package Parking_System_design.LookUpStrategy;

import Parking_System_design.Entity.Parking_spot;

import java.util.List;

public interface ParkingStrategy {
    Parking_spot searchSpot(List<Parking_spot> parkingSpots);
}
