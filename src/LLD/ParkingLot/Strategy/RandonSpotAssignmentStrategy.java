package LLD.ParkingLot.Strategy;

import LLD.ParkingLot.Models.ParkingSpot;
import LLD.ParkingLot.Models.Vehicle;

public class RandonSpotAssignmentStrategy implements ParkingSpotAssignmentStrategy{


    @Override
    public ParkingSpot assParkingSpot(Vehicle vehicle) {
        return new ParkingSpot();
    }
}
