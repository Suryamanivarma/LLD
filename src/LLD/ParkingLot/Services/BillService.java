package LLD.ParkingLot.Services;

import LLD.ParkingLot.Models.Bill;
import LLD.ParkingLot.Models.ParkingSpotStatus;
import LLD.ParkingLot.Models.Ticket;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BillService {

    private static final double HOURLY_RATE = 50.0;


    public Bill generateBill(Ticket ticket){
        Bill bill=new Bill();
        Date exitTime=new Date();

        long durationMills=exitTime.getTime()-ticket.getEntryTime().getTime();
        long durationHours= TimeUnit.MILLISECONDS.toHours(durationMills);
        if(durationHours==0){
            durationHours=1;
        }


    double amount= durationHours*HOURLY_RATE;
        bill.setAmount(amount);
        bill.setTicket(ticket);
        bill.setExitTime(exitTime);

        ticket.getParkingSpot().setParkingSpotStatus(ParkingSpotStatus.AVAILBLE);
        return bill;
    }
}
