package Parking_System_design.Parking_manager;

import Parking_System_design.Entity.Parking_spot;
import Parking_System_design.Entity.Vehicle;
import Parking_System_design.LookUpStrategy.ParkingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public abstract class ParkingSpotManager {

    protected final List<Parking_spot> parkingSpots;
    protected final ParkingStrategy parkingStrategy;
    private final ReentrantLock lock=new ReentrantLock(true);

    public ParkingSpotManager(List<Parking_spot> spots,ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
        this.parkingSpots=spots;
    }

    public boolean hasFreeSpot(){
        lock.lock();
        try{
            return parkingSpots.stream().anyMatch(Parking_spot::isSpotFree);
        }
        finally{
            lock.unlock();
        }
    }

    public Parking_spot park(){
        lock.lock();
        try{
            Parking_spot spot=parkingStrategy.searchSpot(parkingSpots);
            if(spot==null){
                return null;
            }
            spot.occupySpot();
            return spot;
        }
        finally {
            lock.unlock();
        }
    }

    public void unPark(Parking_spot spot){
        // using try-finally block to avoid deadlock condition.
        // incase the exception occurs at releasing the spot, the spot is not completely locked
        lock.lock();
        try{
            spot.releaseSpot();
        }
        finally {
            lock.unlock();
        }
    }









}
