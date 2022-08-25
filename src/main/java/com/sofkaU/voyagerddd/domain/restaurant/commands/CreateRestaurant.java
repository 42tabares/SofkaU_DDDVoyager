package com.sofkaU.voyagerddd.domain.restaurant.commands;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.Command;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;
import com.sofkaU.voyagerddd.domain.restaurant.Chef;
import com.sofkaU.voyagerddd.domain.restaurant.Product;
import com.sofkaU.voyagerddd.domain.restaurant.events.RestaurantCreated;
import com.sofkaU.voyagerddd.domain.restaurant.values.RestaurantID;
import com.sofkaU.voyagerddd.domain.restaurant.values.RestaurantName;

import java.util.Set;

public class CreateRestaurant extends Command {

    private final HotelID hotelID;
    private final RestaurantName restaurantName;
    private final RestaurantID restaurantID;

    public CreateRestaurant(RestaurantID restaurantID, HotelID hotelID, RestaurantName restaurantName) {
        this.hotelID = hotelID;
        this.restaurantID = restaurantID;
        this.restaurantName = restaurantName;
    }

    public HotelID getHotelID() {
        return hotelID;
    }

    public RestaurantName getRestaurantName() {
        return restaurantName;
    }

    public RestaurantID getRestaurantID() {
        return restaurantID;
    }
}
