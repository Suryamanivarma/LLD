package LLD.ParkingLot.Controllers;

import LLD.ParkingLot.Models.Bill;
import LLD.ParkingLot.Models.Ticket;
import LLD.ParkingLot.Services.BillService;
import LLD.ParkingLot.Services.TicketService;

import java.util.Optional;

public class ExitController {

    private final TicketService ticketService;
    private final BillService billService;

    public ExitController(TicketService ticketService, BillService billService) {
        this.ticketService = ticketService;
        this.billService = billService;
    }

    public Optional<Bill> processExit(Long ticketId) {
        Optional<Ticket> optionalTicket = ticketService.getTicketById(ticketId);
        if (optionalTicket.isEmpty()) {
            System.out.println("Ticket not found for ID: " + ticketId);
            return Optional.empty();
        }

        Ticket ticket = optionalTicket.get();
        Bill bill = billService.generateBill(ticket);

        // Optionally: Save bill to a BillRepository if persistence is needed

        return Optional.of(bill);
    }
}
