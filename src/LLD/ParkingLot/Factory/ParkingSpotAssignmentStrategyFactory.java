package LLD.ParkingLot.Factory;

import LLD.ParkingLot.Models.ParkingSpotAssignmentStrategyType;
import LLD.ParkingLot.Strategy.NearestSpotAssignmentStrategy;
import LLD.ParkingLot.Strategy.ParkingSpotAssignmentStrategy;
import LLD.ParkingLot.Strategy.RandonSpotAssignmentStrategy;

public class ParkingSpotAssignmentStrategyFactory {

    public static ParkingSpotAssignmentStrategy getParkingSpotAssignmentStrategy(ParkingSpotAssignmentStrategyType StrategyType){
        if(StrategyType.equals(ParkingSpotAssignmentStrategyType.NEAREST)){
            return new NearestSpotAssignmentStrategy();
        }else if(StrategyType.equals(ParkingSpotAssignmentStrategyType.RANDOM)){
            return new RandonSpotAssignmentStrategy();

        }

        return null;

    }
}
