package com.sofkaU.voyagerddd.domain.hotel.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.voyagerddd.domain.hotel.Employee;
import com.sofkaU.voyagerddd.domain.hotel.Service;
import com.sofkaU.voyagerddd.domain.hotel.values.Restaurants;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelName;
import com.sofkaU.voyagerddd.domain.hotel.values.Rooms;

import java.util.Set;

public class CreateHotel extends Command {

    private final HotelID hotelID;
    private final HotelName hotelName;

    public CreateHotel(HotelID hotelID, HotelName hotelName) {
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
