package com.sofkaU.voyagerddd.domain.hotel;

import co.com.sofka.domain.generic.EventChange;
import com.sofkaU.voyagerddd.domain.hotel.events.HotelCreated;
import com.sofkaU.voyagerddd.domain.room.events.RoomCreated;

import java.util.HashSet;

public class HotelChange extends EventChange {

    public HotelChange(Hotel hotel){

        apply((HotelCreated event) -> {
            hotel.hotelName = event.getHotelName();
            hotel.services = new HashSet<>();
            hotel.employees = new HashSet<>();
            hotel.rooms = new HashSet<>();
            hotel.restaurants = new HashSet<>();
        });



    }
}
