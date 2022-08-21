package com.sofkaU.voyagerddd.domain.room.values;

import co.com.sofka.domain.generic.Identity;

public class RoomID extends Identity {
    public RoomID() {}
    private RoomID(String id){
        super(id);
    }
    public static RoomID of(String id) {
        return new RoomID(id);
    }
}
