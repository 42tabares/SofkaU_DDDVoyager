package com.sofkaU.voyagerddd.domain.hotel;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.voyagerddd.domain.general.Cost;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;
import com.sofkaU.voyagerddd.domain.hotel.values.ServiceID;
import com.sofkaU.voyagerddd.domain.hotel.values.ServiceName;

public class Service extends Entity<ServiceID> {

    private HotelID hotelID;
    private ServiceName serviceName;
    private Cost cost;

    public Service(ServiceID entityId, HotelID hotelID, ServiceName serviceName, Cost cost) {
        super(entityId);
        this.hotelID = hotelID;
        this.serviceName = serviceName;
        this.cost = cost;
    }

    public HotelID getHotelID() {
        return hotelID;
    }

    public void setHotelID(HotelID hotelID) {
        this.hotelID = hotelID;
    }

    public ServiceName getServiceName() {
        return serviceName;
    }

    public void setServiceName(ServiceName serviceName) {
        this.serviceName = serviceName;
    }

    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }
}
