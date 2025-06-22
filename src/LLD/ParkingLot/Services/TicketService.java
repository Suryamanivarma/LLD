package LLD.ParkingLot.Services;

import LLD.ParkingLot.Factory.ParkingSpotAssignmentStrategyFactory;
import LLD.ParkingLot.Models.*;
import LLD.ParkingLot.Repository.GateRepository;
import LLD.ParkingLot.Repository.TicketRepository;
import LLD.ParkingLot.Repository.VehicleRepository;

import java.util.Date;
import java.util.Optional;
import java.util.PrimitiveIterator;

public class TicketService {

    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private TicketRepository ticketRepository;

    public TicketService(GateRepository gateRepository,VehicleRepository vehicleRepository,TicketRepository ticketRepository){
        this.gateRepository=gateRepository;
        this.vehicleRepository=vehicleRepository;
        this.ticketRepository=ticketRepository;
    }

    public Ticket generateTicket(Long gateId, String vehicleNumber, String ownerName, VehicleType vehicleType, ParkingSpotAssignmentStrategyType parkingSpotAssignmentStrategyType){
        Optional<Gate> optionalGate=gateRepository.findById(gateId);
        if(optionalGate.isEmpty()){
            throw new RuntimeException("Invalid gateId  "+gateId);
        }
        Gate gate=optionalGate.get();

        Optional<Vehicle> optionalVehicle=vehicleRepository.findByVehiclNumber(vehicleNumber);
        Vehicle vehicle=null;
        if(optionalVehicle.isEmpty()){
            vehicle=new Vehicle();
            vehicle.setOwnerName(ownerName);
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            vehicleRepository.save(vehicle);
        }else{
            vehicle=optionalVehicle.get();
        }

        ParkingSpot parkingSpot= ParkingSpotAssignmentStrategyFactory.getParkingSpotAssignmentStrategy(parkingSpotAssignmentStrategyType)
                .assParkingSpot(vehicle);
        Ticket ticket=new Ticket();
        ticket.setParkingSpot(parkingSpot);
        ticket.setEntryTime(new Date());
        ticket.setGate(gate);
        ticket.setVehicle(vehicle);

        return ticketRepository.save(ticket);


    }

    public Optional<Ticket> getTicketById(Long ticketId) {
        return ticketRepository.findById(ticketId);
    }

}
