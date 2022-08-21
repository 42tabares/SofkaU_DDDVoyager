package com.sofkaU.voyagerddd.domain.hotel.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.voyagerddd.domain.general.Cost;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;
import com.sofkaU.voyagerddd.domain.hotel.values.ServiceID;

public class UpdateServiceCost extends Command {

    private final HotelID hotelID;
    private final ServiceID serviceID;
    private final Cost cost;

    public UpdateServiceCost(HotelID hotelID, ServiceID serviceID, Cost cost) {
        this.hotelID = hotelID;
        this.serviceID = serviceID;
        this.cost = cost;
    }

    public HotelID getHotelID() {
        return hotelID;
    }

    public ServiceID getServiceID() {
        return serviceID;
    }

    public Cost getCost() {
        return cost;
    }
}
