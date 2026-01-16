package Parking_System_design.Parking_manager;

import Parking_System_design.Entity.Parking_spot;
import Parking_System_design.LookUpStrategy.ParkingStrategy;

import java.util.List;

public class two_WheelerManager extends ParkingSpotManager {
    public two_WheelerManager(List<Parking_spot> spots, ParkingStrategy parkingStrategy) {
        super(spots, parkingStrategy);
    }
}
