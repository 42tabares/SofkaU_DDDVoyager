package com.sofkaU.voyagerddd.domain.restaurant.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.voyagerddd.domain.restaurant.values.ChefID;
import com.sofkaU.voyagerddd.domain.restaurant.values.ChefSpecialty;
import com.sofkaU.voyagerddd.domain.restaurant.values.RestaurantID;

public class UpdateChefSpecialty extends Command {
    private final RestaurantID restaurantID;
    private final ChefID chefID;
    private final ChefSpecialty chefSpecialty;

    public UpdateChefSpecialty(RestaurantID restaurantID, ChefID chefID, ChefSpecialty chefSpecialty) {
        this.restaurantID = restaurantID;
        this.chefID = chefID;
        this.chefSpecialty = chefSpecialty;
    }

    public RestaurantID getRestaurantID() {
        return restaurantID;
    }

    public ChefID getChefID() {
        return chefID;
    }

    public ChefSpecialty getChefSpecialty() {
        return chefSpecialty;
    }
}
