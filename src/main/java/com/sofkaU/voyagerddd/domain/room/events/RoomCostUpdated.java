package com.sofkaU.voyagerddd.domain.room.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.voyagerddd.domain.general.Cost;
import com.sofkaU.voyagerddd.domain.room.values.RoomID;

public class RoomCostUpdated extends DomainEvent {

    private final RoomID roomID;
    private final Cost cost;

    public RoomCostUpdated( RoomID roomID, Cost cost) {
        super("room.RoomCostUpdated");
        this.roomID = roomID;
        this.cost = cost;
    }

    public RoomID getRoomID() {
        return roomID;
    }

    public Cost getCost() {
        return cost;
    }
}
