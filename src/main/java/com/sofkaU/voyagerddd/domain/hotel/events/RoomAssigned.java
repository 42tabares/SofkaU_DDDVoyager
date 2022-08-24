package com.sofkaU.voyagerddd.domain.hotel.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.voyagerddd.domain.room.values.RoomID;

public class RoomAssigned extends DomainEvent {

    private final RoomID roomID;

    public RoomAssigned(RoomID roomID) {
        super("hotel.RoomAssigned");
        this.roomID = roomID;
    }

    public RoomID getRoomID() {
        return roomID;
    }
}
