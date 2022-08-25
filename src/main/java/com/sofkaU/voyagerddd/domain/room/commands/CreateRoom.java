package com.sofkaU.voyagerddd.domain.room.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.voyagerddd.domain.general.Cost;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;
import com.sofkaU.voyagerddd.domain.room.values.RoomID;
import com.sofkaU.voyagerddd.domain.room.values.RoomNumber;

public class CreateRoom extends Command {

    private  final HotelID hotelID;
    private final RoomID roomID;
    private final RoomNumber roomNumber;
    private final Cost cost;

    public CreateRoom(RoomID roomID, HotelID hotelID, RoomNumber roomNumber, Cost cost) {
        this.hotelID = hotelID;
        this.roomID = roomID;
        this.roomNumber = roomNumber;
        this.cost = cost;
    }

    public HotelID getHotelID() {
        return hotelID;
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
