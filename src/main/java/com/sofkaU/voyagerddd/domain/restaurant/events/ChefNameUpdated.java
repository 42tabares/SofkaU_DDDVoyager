package com.sofkaU.voyagerddd.domain.restaurant.events;


import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.voyagerddd.domain.general.Name;
import com.sofkaU.voyagerddd.domain.restaurant.values.ChefID;

public class ChefNameUpdated extends DomainEvent {

    private final ChefID chefID;
    private final Name chefName;

    public ChefNameUpdated( ChefID chefID, Name chefName) {
        super("restaurant.ChefNameUpdated");
        this.chefID = chefID;
        this.chefName = chefName;
    }

    public ChefID getChefID() {
        return chefID;
    }

    public Name getChefName() {
        return chefName;
    }
}
