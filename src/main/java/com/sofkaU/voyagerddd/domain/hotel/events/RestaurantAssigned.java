package com.sofkaU.voyagerddd.domain.hotel.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.voyagerddd.domain.restaurant.values.RestaurantID;
import com.sofkaU.voyagerddd.domain.room.values.RoomID;

public class RestaurantAssigned extends DomainEvent {

    private final RestaurantID restaurantID;
    public RestaurantAssigned(RestaurantID restaurantID) {
        super("Hotel.RestaurantAssigned");
        this.restaurantID = restaurantID;
    }

    public RestaurantID getRestaurantID() {
        return restaurantID;
    }
}
