package com.sofkaU.voyagerddd.domain.hotel.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;
import com.sofkaU.voyagerddd.domain.hotel.values.ServiceID;
import com.sofkaU.voyagerddd.domain.hotel.values.ServiceName;

public class UpdateServiceName extends Command {

    private final HotelID hotelID;
    private final ServiceID serviceID;
    private final ServiceName serviceName;

    public UpdateServiceName(HotelID hotelID, ServiceID serviceID, ServiceName serviceName) {
        this.hotelID = hotelID;
        this.serviceID = serviceID;
        this.serviceName = serviceName;
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
}
