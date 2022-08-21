package com.sofkaU.voyagerddd.domain.room.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.voyagerddd.domain.general.Cost;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;
import com.sofkaU.voyagerddd.domain.room.values.RoomID;
import com.sofkaU.voyagerddd.domain.room.values.RoomNumber;

public class RoomCreated extends DomainEvent {

    private final RoomID roomID;
    private final RoomNumber roomNumber;
    private final Cost cost;

    public RoomCreated(RoomID roomID, RoomNumber roomNumber, Cost cost) {
        super("room.RoomCreated");
        this.roomID = roomID;
        this.roomNumber = roomNumber;
        this.cost = cost;
    }

    public RoomID getRoomID() {
        return roomID;
    }

    public RoomNumber getRoomNumber() {
        return roomNumber;
    }

    public Cost getCost() {
        return cost;
    }
}
