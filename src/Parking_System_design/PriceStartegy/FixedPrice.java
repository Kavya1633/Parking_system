package Parking_System_design.PriceStartegy;

import Parking_System_design.Ticket;

public class FixedPrice implements CostComputation {
    private double price=200.00;
    public double calculatePrice(Ticket ticket) {
        return price;
    }
}
