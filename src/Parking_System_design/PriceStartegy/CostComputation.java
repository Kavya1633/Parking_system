package Parking_System_design.PriceStartegy;

import Parking_System_design.Ticket;

public interface CostComputation {

    public double calculatePrice(Ticket ticket);
}
