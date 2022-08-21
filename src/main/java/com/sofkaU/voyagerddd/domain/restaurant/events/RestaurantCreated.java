package com.sofkaU.voyagerddd.domain.restaurant.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;
import com.sofkaU.voyagerddd.domain.restaurant.values.RestaurantName;

public class RestaurantCreated extends DomainEvent {

    private final HotelID hotelID;
    private final RestaurantName restaurantName;

    public RestaurantCreated(HotelID hotelID, RestaurantName restaurantName) {
        super("Restaurant.RestaurantCreated");
        this.hotelID = hotelID;
        this.restaurantName = restaurantName;
    }

    public RestaurantName getRestaurantName(){
        return this.restaurantName;
    }
}
