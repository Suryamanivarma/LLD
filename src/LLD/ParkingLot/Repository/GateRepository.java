package LLD.ParkingLot.Repository;

import LLD.ParkingLot.Models.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {

    Map<Long, Gate> gateMap=new HashMap<>();
    private Long gateId=0L;


    public Gate save(Gate gate){
            if(gate.getId()== null){
                gateId+=1;
                gate.setId(gateId);
                gateMap.put(gateId,gate);
            }else{
                gateMap.put(gate.getId(),gate);
            }

            return gate;
    }

    public Optional<Gate> findById(Long gateId){
    if(gateMap.containsKey(gateId)){
        return Optional.of(gateMap.get(gateId));
    }

        return Optional.empty();
    }
}
