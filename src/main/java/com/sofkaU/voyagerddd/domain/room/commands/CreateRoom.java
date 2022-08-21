package com.sofkaU.voyagerddd.domain.room.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.voyagerddd.domain.general.Cost;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;
import com.sofkaU.voyagerddd.domain.room.values.RoomID;
import com.sofkaU.voyagerddd.domain.room.values.RoomNumber;

public class CreateRoom extends Command {

    private final RoomID roomID;
    private final RoomNumber roomNumber;
    private final Cost cost;

    public CreateRoom( RoomID roomID, RoomNumber roomNumber, Cost cost) {
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
