package com.sofkaU.voyagerddd.domain.restaurant;

import co.com.sofka.domain.generic.EventChange;
import com.sofkaU.voyagerddd.domain.restaurant.events.RestaurantCreated;

public class RestaurantChange extends EventChange {

    public RestaurantChange(Restaurant restaurant){

        apply((RestaurantCreated event) -> {

        });

    }
}
