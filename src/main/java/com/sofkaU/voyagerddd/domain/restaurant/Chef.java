package com.sofkaU.voyagerddd.domain.restaurant;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.voyagerddd.domain.general.Name;
import com.sofkaU.voyagerddd.domain.restaurant.values.ChefID;
import com.sofkaU.voyagerddd.domain.restaurant.values.ChefSpecialty;
import com.sofkaU.voyagerddd.domain.restaurant.values.RestaurantID;


public class Chef extends Entity<ChefID> {

    private RestaurantID restaurantID;
    private Name chefName;
    private ChefSpecialty chefSpecialty;

    public Chef(ChefID entityId, RestaurantID restaurantIDM, Name chefName, ChefSpecialty chefSpecialty) {
        super(entityId);
        this.restaurantID = restaurantIDM;
        this.chefName = chefName;
        this.chefSpecialty = chefSpecialty;
    }

    public RestaurantID getRestaurantIDM() {
        return restaurantID;
    }

    public void setRestaurantIDM(RestaurantID restaurantIDM) {
        this.restaurantID = restaurantIDM;
    }

    public Name getChefName() {
        return chefName;
    }

    public void setChefName(Name chefName) {
        this.chefName = chefName;
    }

    public ChefSpecialty getChefSpecialty() {
        return chefSpecialty;
    }

    public void setChefSpecialty(ChefSpecialty chefSpecialty) {
        this.chefSpecialty = chefSpecialty;
    }
}
