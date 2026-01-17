package Parking_System_design.PriceStartegy;

import Parking_System_design.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

public class hourlyBasis implements CostComputation {
    private double fixedCharge=50.0;
    private double perhourCost=30.0;

    public double calculatePrice(Ticket ticket) {

        LocalDateTime entryTime=ticket.getEntrytime();
        LocalDateTime exitTime=LocalDateTime.now();

        long hours= Duration.between(entryTime,exitTime).toHours();

        double finalPrice=fixedCharge+hours*perhourCost;
        return finalPrice;
    }
}
