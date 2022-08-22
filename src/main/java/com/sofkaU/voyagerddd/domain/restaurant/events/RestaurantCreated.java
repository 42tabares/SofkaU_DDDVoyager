package com.sofkaU.voyagerddd.domain.restaurant.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;
import com.sofkaU.voyagerddd.domain.restaurant.values.RestaurantID;
import com.sofkaU.voyagerddd.domain.restaurant.values.RestaurantName;

public class RestaurantCreated extends DomainEvent {

    private final RestaurantID restaurantID;
    private final HotelID hotelID;
    private final RestaurantName restaurantName;

    public RestaurantCreated(HotelID hotelID, RestaurantID restaurantID, RestaurantName restaurantName) {
        super("Restaurant.RestaurantCreated");
        this.restaurantID = restaurantID;
        this.hotelID = hotelID;
        this.restaurantName = restaurantName;
    }

    public RestaurantName getRestaurantName(){
        return this.restaurantName;
    }

    public RestaurantID getRestaurantID() {
        return restaurantID;
    }

    public HotelID getHotelID() {
        return hotelID;
    }
}
