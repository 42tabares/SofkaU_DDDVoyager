package com.sofkaU.voyagerddd.domain.restaurant.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.voyagerddd.domain.general.Name;
import com.sofkaU.voyagerddd.domain.restaurant.values.ChefID;
import com.sofkaU.voyagerddd.domain.restaurant.values.ChefSpecialty;
import com.sofkaU.voyagerddd.domain.restaurant.values.RestaurantID;

public class AddChef extends Command {

    private final RestaurantID restaurantID;
    private final ChefID chefID;
    private final Name chefName;
    private final ChefSpecialty chefSpecialty;

    public AddChef(RestaurantID restaurantID, ChefID chefID, Name chefName, ChefSpecialty chefSpecialty) {
        this.restaurantID = restaurantID;
        this.chefID = chefID;
        this.chefName = chefName;
        this.chefSpecialty = chefSpecialty;
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

    public ChefSpecialty getChefSpecialty() {
        return chefSpecialty;
    }
}
