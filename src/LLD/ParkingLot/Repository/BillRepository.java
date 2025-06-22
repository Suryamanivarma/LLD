package LLD.ParkingLot.Repository;

import LLD.ParkingLot.Models.Bill;

import java.util.HashMap;
import java.util.Map;

public class BillRepository {

    private Map<Long, Bill> longBillMap=new HashMap<>();

    private Long id=0L;

    public Bill save(Bill bill){
        if(bill.getId()==null){
            id+=1;
            bill.setId(id);
            longBillMap.put(id,bill);
        }else{
            longBillMap.put(bill.getId(),bill);
        }

        return bill;
    }

}
