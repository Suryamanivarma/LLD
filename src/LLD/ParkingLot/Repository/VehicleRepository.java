package LLD.ParkingLot.Repository;

import LLD.ParkingLot.Models.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VehicleRepository {
    private Map<Long, Vehicle> vehicleMap=new HashMap<>();

    private Long id=0L;

    public Vehicle save(Vehicle vehicle){
        if(vehicle.getId()==null){
            id+=1;
            vehicle.setId(id);
            vehicleMap.put(id,vehicle);
        }else{
            vehicleMap.put(vehicle.getId(),vehicle);
        }

        return vehicle;

    }

    public Optional<Vehicle> findById(Long vehicleId){
        if(vehicleMap.containsKey(vehicleId)){
            return Optional.of(vehicleMap.get(vehicleId));
        }

        return Optional.empty();
    }

    public Optional<Vehicle> findByVehiclNumber(String vehicleNumber){
        for (Vehicle vehicle : vehicleMap.values()) {
            if (vehicle.getVehicleNumber().equals(vehicleNumber)) {
                return Optional.of(vehicle);
            }
        }
        return Optional.empty();

    }
}
