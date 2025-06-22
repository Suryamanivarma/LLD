package LLD.ParkingLot.Repository;

import LLD.ParkingLot.Models.Ticket;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TicketRepository {
    private Map<Long, Ticket> ticketMap=new HashMap<>();

    private Long id=0l;


    public Ticket save(Ticket ticket){
    return null;
    }

    public Optional<Ticket> findById(Long id) {
        return Optional.ofNullable(ticketMap.get(id));
    }

}
