package com.sofkaU.voyagerddd.domain.restaurant.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.voyagerddd.domain.general.Name;
import com.sofkaU.voyagerddd.domain.restaurant.values.ChefID;
import com.sofkaU.voyagerddd.domain.restaurant.values.ChefSpecialty;

public class ChefAdded extends DomainEvent {

    private final ChefID chefID;
    private final Name chefName;
    private final ChefSpecialty chefSpecialty;

    public ChefAdded(ChefID chefID, Name chefName, ChefSpecialty chefSpecialty) {
        super("restaurant.ChefAdded");
        this.chefID = chefID;
        this.chefName = chefName;
        this.chefSpecialty = chefSpecialty;
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
