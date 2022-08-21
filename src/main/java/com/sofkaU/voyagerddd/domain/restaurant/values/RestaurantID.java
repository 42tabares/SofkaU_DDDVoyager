package com.sofkaU.voyagerddd.domain.restaurant.values;

import co.com.sofka.domain.generic.Identity;

public class RestaurantID extends Identity {
    public RestaurantID() {}
    private RestaurantID(String id){
        super(id);
    }

    public static RestaurantID of(String id) {
        return new RestaurantID(id);
    }
}
