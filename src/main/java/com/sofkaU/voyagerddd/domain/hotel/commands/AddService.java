package com.sofkaU.voyagerddd.domain.hotel.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.voyagerddd.domain.general.Cost;
import com.sofkaU.voyagerddd.domain.hotel.Service;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;
import com.sofkaU.voyagerddd.domain.hotel.values.ServiceID;
import com.sofkaU.voyagerddd.domain.hotel.values.ServiceName;

public class AddService extends Command {

    private final HotelID hotelID;
    private final ServiceID serviceID;
    private final ServiceName serviceName;
    private final Cost cost;

    public AddService(HotelID hotelID, ServiceID serviceID, ServiceName serviceName, Cost cost) {
        this.hotelID = hotelID;
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.cost = cost;
    }

    public HotelID getHotelID() {
        return hotelID;
    }

    public ServiceID getServiceID() {
        return serviceID;
    }

    public ServiceName getServiceName() {
        return serviceName;
    }

    public Cost getCost() {
        return cost;
    }
}
