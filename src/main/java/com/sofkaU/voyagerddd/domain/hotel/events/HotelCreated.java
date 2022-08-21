package com.sofkaU.voyagerddd.domain.hotel.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelName;

public class HotelCreated extends DomainEvent {

    private final HotelName hotelName;

    public HotelCreated(HotelName hotelName) {
        super("hotel.HotelCreated");
        this.hotelName = hotelName;
    }

    public HotelName getHotelName() {
        return hotelName;
    }
}
