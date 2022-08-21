package com.sofkaU.voyagerddd.domain.hotel.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelName;

public class HotelNameUpdated extends DomainEvent {

    private final HotelID hotelID;
    private final HotelName hotelName;

    public HotelNameUpdated(HotelID hotelID, HotelName hotelName) {
        super("hotel.HotelNameUpdated");
        this.hotelID = hotelID;
        this.hotelName = hotelName;
    }

    public HotelID getHotelID() {
        return hotelID;
    }

    public HotelName getHotelName() {
        return hotelName;
    }
}
