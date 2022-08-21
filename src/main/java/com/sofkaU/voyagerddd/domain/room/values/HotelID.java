package com.sofkaU.voyagerddd.domain.room.values;

import co.com.sofka.domain.generic.Identity;

public class HotelID extends Identity {
    public HotelID() {}
    private HotelID(String id){
        super(id);
    }
    public static HotelID of(String id) {
        return new HotelID(id);
    }
}
