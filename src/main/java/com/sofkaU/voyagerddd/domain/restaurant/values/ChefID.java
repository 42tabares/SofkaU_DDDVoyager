package com.sofkaU.voyagerddd.domain.restaurant.values;

import co.com.sofka.domain.generic.Identity;

public class ChefID extends Identity {
    public ChefID() {}
    private ChefID(String id){
        super(id);
    }

    public static ChefID of(String id) {
        return new ChefID(id);
    }
}
