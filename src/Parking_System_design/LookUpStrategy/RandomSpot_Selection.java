package Parking_System_design.LookUpStrategy;

import Parking_System_design.Entity.Parking_spot;

import java.util.List;
import java.util.Random;

public class RandomSpot_Selection implements ParkingStrategy {
    @Override
    public Parking_spot searchSpot(List<Parking_spot> parkingSpots) {
        Random random = new Random();
        int attempts=parkingSpots.size();

        while(attempts-->0){
            Parking_spot spot=parkingSpots.get(random.nextInt(parkingSpots.size()));
            if(spot.isSpotFree()){
                return spot;
            }
        }
        return null;
    }
}
