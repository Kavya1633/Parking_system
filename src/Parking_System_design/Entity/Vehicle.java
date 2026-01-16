package Parking_System_design.Entity;

import Parking_System_design.Enums.vehicleType;

public class Vehicle {
    String vehicle_no;
    vehicleType vehicleType;

    public Vehicle(String vehicle_no, vehicleType vehicleType) {
        this.vehicle_no = vehicle_no;
        this.vehicleType = vehicleType;
    }

    public String getVehicle_no() {
        return vehicle_no;
    }

    public vehicleType getVehicleType() {
        return vehicleType;
    }
}
