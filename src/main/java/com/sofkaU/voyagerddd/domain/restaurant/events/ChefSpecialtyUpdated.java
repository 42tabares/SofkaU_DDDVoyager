package com.sofkaU.voyagerddd.domain.restaurant.events;


import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.voyagerddd.domain.restaurant.values.ChefID;
import com.sofkaU.voyagerddd.domain.restaurant.values.ChefSpecialty;

public class ChefSpecialtyUpdated extends DomainEvent {

    private final ChefID chefID;
    private final ChefSpecialty chefSpecialty;

    public ChefSpecialtyUpdated( ChefID chefID, ChefSpecialty chefSpecialty) {
        super("restaurant.ChefSpecialtyUpdated");
        this.chefID = chefID;
        this.chefSpecialty = chefSpecialty;
    }

    public ChefID getChefID() {
        return chefID;
    }

    public ChefSpecialty getChefSpecialty() {
        return chefSpecialty;
    }
}
