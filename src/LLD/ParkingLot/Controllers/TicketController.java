package LLD.ParkingLot.Controllers;

import LLD.ParkingLot.DTO.GenerateTicketRequestDto;
import LLD.ParkingLot.DTO.GenerateTicketResponseDto;
import LLD.ParkingLot.DTO.ResponseStatus;
import LLD.ParkingLot.Models.ParkingSpotAssignmentStrategyType;
import LLD.ParkingLot.Models.Ticket;
import LLD.ParkingLot.Models.VehicleType;
import LLD.ParkingLot.Services.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService=ticketService;
    }

    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto generateTicketRequestDto){

        String vehicleNumber=generateTicketRequestDto.getVehicleNumber();
        String owerName=generateTicketRequestDto.getOwnerName();
        long gateId=generateTicketRequestDto.getGateId();
        VehicleType vehicleType=generateTicketRequestDto.getVehicleType();
        ParkingSpotAssignmentStrategyType parkingSpotAssignmentStrategyType=generateTicketRequestDto.getParkingSpotAssignmentStrategyType();

        GenerateTicketResponseDto generateTicketResponseDto=new GenerateTicketResponseDto();
        try{
            Ticket ticket=ticketService.
                    generateTicket(gateId,vehicleNumber,owerName,vehicleType,
                            parkingSpotAssignmentStrategyType);

            generateTicketResponseDto.setTicket(ticket);
            generateTicketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            generateTicketResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }

        return generateTicketResponseDto;

    }
}
