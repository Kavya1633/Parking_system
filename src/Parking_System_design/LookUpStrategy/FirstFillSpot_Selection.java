package Parking_System_design.LookUpStrategy;

import Parking_System_design.Entity.Parking_spot;

import java.util.List;

public class FirstFillSpot_Selection implements ParkingStrategy {


    @Override
    public Parking_spot searchSpot(List<Parking_spot> parkingSpots) {

        for(Parking_spot spot : parkingSpots){
            if(spot.isSpotFree()){
                return spot;
            }
        }
        return null;
    }
}
