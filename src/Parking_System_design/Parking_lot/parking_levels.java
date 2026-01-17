package Parking_System_design.Parking_lot;

import Parking_System_design.Entity.Parking_spot;
import Parking_System_design.Enums.vehicleType;
import Parking_System_design.Parking_manager.ParkingSpotManager;

import java.util.HashMap;
import java.util.Map;

public class parking_levels {
    private int levelNo;
    private Map<vehicleType, ParkingSpotManager> managers;

    public parking_levels(int levelNo, Map<vehicleType, ParkingSpotManager> managers) {
        this.levelNo = levelNo;
        this.managers = managers;
    }

    public int getLevelNo() {
        return levelNo;
    }
    boolean hasAvailability(vehicleType type){
        ParkingSpotManager manager=managers.get(type);
        if(manager != null){
            return manager.hasFreeSpot();
        }
        return false;
    }
     Parking_spot park(vehicleType type){
        ParkingSpotManager manager=managers.get(type);
        if(manager==null){
            throw new IllegalArgumentException(
                    "No Manager Appointed for type "+ type.toString()
            );
        }
        return manager.park();
    }

    void unpark(Parking_spot spot, vehicleType type){
        ParkingSpotManager manager=managers.get(type);
        if(manager!=null) manager.unPark(spot);
    }



}
