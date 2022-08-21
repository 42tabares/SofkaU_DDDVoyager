package com.sofkaU.voyagerddd.domain.hotel.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelName;

public class UpdateHotelName extends Command {

    private final HotelID hotelID;
    private final HotelName hotelName;

    public UpdateHotelName(HotelID hotelID, HotelName hotelName) {
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
