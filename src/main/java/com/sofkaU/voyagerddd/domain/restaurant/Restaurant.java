package com.sofkaU.voyagerddd.domain.restaurant;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;
import com.sofkaU.voyagerddd.domain.restaurant.events.RestaurantCreated;
import com.sofkaU.voyagerddd.domain.restaurant.values.RestaurantID;
import com.sofkaU.voyagerddd.domain.restaurant.values.RestaurantName;
import java.util.List;
import java.util.Set;

public class Restaurant extends AggregateEvent<RestaurantID> {

    protected HotelID hotelID;
    protected RestaurantName restaurantName;
    protected Set<Chef> chefs;
    protected Set<Product> products;

    public Restaurant(RestaurantID entityId, HotelID hotelID, RestaurantName restaurantName) {
        super(entityId);
        appendChange(new RestaurantCreated(hotelID,restaurantName)).apply();
    }

    private Restaurant(RestaurantID restaurantID){
        super(restaurantID);
        subscribe(new RestaurantChange(this));
    }

    public static Restaurant from(RestaurantID restaurantID, List<DomainEvent> events){
        var restaurant = new Restaurant(restaurantID);
        events.forEach(restaurant::applyEvent);
        return restaurant;
    }
}
