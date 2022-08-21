package com.sofkaU.voyagerddd.domain.restaurant.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.voyagerddd.domain.general.Name;
import com.sofkaU.voyagerddd.domain.restaurant.values.ChefID;
import com.sofkaU.voyagerddd.domain.restaurant.values.RestaurantID;

public class UpdateChefName extends Command {

    private final RestaurantID restaurantID;
    private final ChefID chefID;
    private final Name chefName;

    public UpdateChefName(RestaurantID restaurantID, ChefID chefID, Name chefName) {
        this.restaurantID = restaurantID;
        this.chefID = chefID;
        this.chefName = chefName;
    }

    public RestaurantID getRestaurantID() {
        return restaurantID;
    }

    public ChefID getChefID() {
        return chefID;
    }

    public Name getChefName() {
        return chefName;
    }
}
