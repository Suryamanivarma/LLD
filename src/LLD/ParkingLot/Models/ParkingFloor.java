package LLD.ParkingLot.Models;

import java.util.List;

public class ParkingFloor extends BaseModel{

    private String floorNumber;
    private List<ParkingSpot> parkingSpotList;

    public String getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }

    public List<ParkingSpot> getParkingSpotList() {
        return parkingSpotList;
    }

    public void setParkingSpotList(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
    }
}
