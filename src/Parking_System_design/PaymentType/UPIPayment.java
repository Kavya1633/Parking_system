package Parking_System_design.PaymentType;

public class UPIPayment implements Payment {

    public boolean pay(double price){
        System.out.println("UPI Payment: "+ price);
        return true;
    }
}
