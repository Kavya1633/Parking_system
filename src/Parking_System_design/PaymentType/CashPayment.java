package Parking_System_design.PaymentType;

public class CashPayment implements Payment{
    @Override
    public boolean pay(double price) {
        System.out.println("Cash Payment: "+price);
        return true;
    }
}
