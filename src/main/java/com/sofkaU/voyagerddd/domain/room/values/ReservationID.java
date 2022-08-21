package com.sofkaU.voyagerddd.domain.room.values;

import co.com.sofka.domain.generic.Identity;

public class ReservationID extends Identity {
    public ReservationID() {}
    private ReservationID(String id){
        super(id);
    }
    public static ReservationID of(String id) {
        return new ReservationID(id);
    }
}
