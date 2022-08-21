package com.sofkaU.voyagerddd.domain.room.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.voyagerddd.domain.room.values.RoomID;
import com.sofkaU.voyagerddd.domain.room.values.RoomNumber;

public class RoomNumberUpdated extends DomainEvent {

    private final RoomID roomID;
    private final RoomNumber roomNumber;

    public RoomNumberUpdated(RoomID roomID, RoomNumber roomNumber) {
        super("room.RoomNumberUpdated");
        this.roomID = roomID;
        this.roomNumber = roomNumber;
    }

    public RoomID getRoomID() {
        return roomID;
    }

    public RoomNumber getRoomNumber() {
        return roomNumber;
    }
}
