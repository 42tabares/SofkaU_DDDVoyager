package com.sofkaU.voyagerddd.domain.hotel;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.voyagerddd.domain.hotel.events.HotelCreated;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelName;
import com.sofkaU.voyagerddd.domain.restaurant.Restaurant;
import com.sofkaU.voyagerddd.domain.restaurant.RestaurantChange;
import com.sofkaU.voyagerddd.domain.restaurant.events.RestaurantCreated;
import com.sofkaU.voyagerddd.domain.restaurant.values.RestaurantID;
import com.sofkaU.voyagerddd.domain.restaurant.values.RestaurantName;
import com.sofkaU.voyagerddd.domain.room.values.RoomID;

import java.util.List;
import java.util.Set;

public class Hotel extends AggregateEvent<HotelID> {

    protected HotelName hotelName;
    protected Set<Service> services;
    protected Set<Employee> employees;
    protected Set<RoomID> rooms;
    protected Set<RestaurantID> restaurants;

    public Hotel(HotelID entityId, HotelName hotelName) {
        super(entityId);
        appendChange(new HotelCreated(hotelName)).apply();
    }

    private Hotel(HotelID hotelID){
        super(hotelID);
        subscribe(new HotelChange(this));
    }

    public static Hotel from(HotelID hotelID, List<DomainEvent> events){
        var hotel = new Hotel(hotelID);
        events.forEach(hotel::applyEvent);
        return hotel;
    }


}
