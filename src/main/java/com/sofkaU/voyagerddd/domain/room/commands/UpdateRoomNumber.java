package com.sofkaU.voyagerddd.domain.room.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;
import com.sofkaU.voyagerddd.domain.room.values.RoomID;
import com.sofkaU.voyagerddd.domain.room.values.RoomNumber;

public class UpdateRoomNumber extends Command {

    private final HotelID hotelID;
    private final RoomID roomID;
    private final RoomNumber roomNumber;

    public UpdateRoomNumber(HotelID hotelID, RoomID roomID, RoomNumber roomNumber) {
        this.hotelID = hotelID;
        this.roomID = roomID;
        this.roomNumber = roomNumber;
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
}
