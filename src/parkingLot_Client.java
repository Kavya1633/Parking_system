import Parking_System_design.Entity.Parking_spot;
import Parking_System_design.Entity.Vehicle;
import Parking_System_design.Enums.vehicleType;
import Parking_System_design.LookUpStrategy.ParkingStrategy;
import Parking_System_design.LookUpStrategy.RandomSpot_Selection;
import Parking_System_design.Parking_lot.*;
import Parking_System_design.Parking_manager.ParkingSpotManager;
import Parking_System_design.Parking_manager.four_WheelerManager;
import Parking_System_design.Parking_manager.two_WheelerManager;
import Parking_System_design.PaymentType.CashPayment;
import Parking_System_design.PaymentType.UPIPayment;
import Parking_System_design.PriceStartegy.FixedPrice;
import Parking_System_design.PriceStartegy.hourlyBasis;
import Parking_System_design.Ticket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class parkingLot_Client {
    public static void main(String[] args) {

        // ParkingStrategy -Random
        ParkingStrategy parkingStrategy=new RandomSpot_Selection();

        Map<vehicleType, ParkingSpotManager> level1_manager=new HashMap<vehicleType, ParkingSpotManager>();

        level1_manager.put(vehicleType.Two_Wheeler,
                new two_WheelerManager(List.of(new Parking_spot("l1-01")
                , new Parking_spot("l1-02")),parkingStrategy));

        level1_manager.put(vehicleType.Four_Wheeler,
                new four_WheelerManager(List.of(new Parking_spot("l1-101"))
                ,parkingStrategy));

        parking_levels level1=new parking_levels(1,level1_manager);

        Map<vehicleType, ParkingSpotManager> level2_manager=new HashMap<>();

        level2_manager.put(vehicleType.Four_Wheeler,
                new four_WheelerManager(
                        List.of(new Parking_spot("l2-201")
                                ,new Parking_spot("l2-202")
                                ,new Parking_spot("l2-203")),parkingStrategy));

        parking_levels level2=new parking_levels(2,level2_manager);

        parking_building building=
                new parking_building(List.of(level1,level2));

        /*Entrance_Gate entranceGate=new Entrance_Gate();
        Exit_Gate exitGate=new Exit_Gate(new hourlyBasis());*/

        parking_lot parkingLot=
                new parking_lot(building,
                        new Entrance_Gate()
                        ,new Exit_Gate(new FixedPrice()));


        // Initialising Vehicles
        Vehicle vehicle1=new Vehicle("DL-9201",vehicleType.Four_Wheeler);
        Vehicle vehicle2=new Vehicle("HR-9932",vehicleType.Two_Wheeler);
        Vehicle vehicle3=new Vehicle("DL-1111",vehicleType.Four_Wheeler);
        Vehicle vehicle4=new Vehicle("RJ-8623",vehicleType.Two_Wheeler);
        Vehicle vehicle5=new Vehicle("DL-2222",vehicleType.Two_Wheeler);

        // Entry and Exit of vehicles
        Ticket t1=parkingLot.vehicleArrives(vehicle1);
        parkingLot.exitVehicle(t1,new UPIPayment());

        Ticket t2=parkingLot.vehicleArrives(vehicle2);

        Ticket t4=parkingLot.vehicleArrives(vehicle4);


        parkingLot.exitVehicle(t2,new CashPayment());


        Ticket t5=parkingLot.vehicleArrives(vehicle5);
        Ticket t3=parkingLot.vehicleArrives(vehicle3);


        parkingLot.exitVehicle(t4,new CashPayment());
        parkingLot.exitVehicle(t5,new UPIPayment());
        parkingLot.exitVehicle(t3,new UPIPayment());



    }



}