package Parking_System_design.Parking_lot;

import Parking_System_design.PaymentType.Payment;
import Parking_System_design.PriceStartegy.CostComputation;
import Parking_System_design.Ticket;

public class Exit_Gate {

    private CostComputation costComputation;

    public Exit_Gate(CostComputation costComputation) {
        this.costComputation = costComputation;
    }

    public void exit(parking_building building, Ticket ticket, Payment payment) {
        double price = costComputation.calculatePrice(ticket);

        boolean success=payment.pay(price);
        if(!success){
            throw new RuntimeException(" Payment failed !!");
        }
        building.release(ticket);
        System.out.println("Exit Successful : Gate Opened!");
    }

}
