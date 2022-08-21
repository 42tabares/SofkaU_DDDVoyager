package com.sofkaU.voyagerddd.domain.room.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.voyagerddd.domain.general.Cost;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;
import com.sofkaU.voyagerddd.domain.room.values.RoomID;

public class UpdateRoomCost extends Command {
    private final HotelID hotelID;
    private final RoomID roomID;
    private final Cost cost;

    public UpdateRoomCost(HotelID hotelID, RoomID roomID, Cost cost) {
        this.hotelID = hotelID;
        this.roomID = roomID;
        this.cost = cost;
    }

    public HotelID getHotelID() {
        return hotelID;
    }

    public RoomID getRoomID() {
        return roomID;
    }

    public Cost getCost() {
        return cost;
    }
}
