package LLD.ParkingLot.Strategy;

import LLD.ParkingLot.Models.ParkingSpot;
import LLD.ParkingLot.Models.Vehicle;

public interface ParkingSpotAssignmentStrategy {

    ParkingSpot assParkingSpot(Vehicle vehicle);

}
