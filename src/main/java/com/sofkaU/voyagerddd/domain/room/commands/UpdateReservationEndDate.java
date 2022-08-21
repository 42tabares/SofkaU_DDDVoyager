package com.sofkaU.voyagerddd.domain.room.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.voyagerddd.domain.room.values.EndDate;
import com.sofkaU.voyagerddd.domain.room.values.ReservationID;
import com.sofkaU.voyagerddd.domain.room.values.RoomID;

public class UpdateReservationEndDate extends Command {
    private final RoomID roomID;
    private final ReservationID reservationID;
    private final EndDate endDate;

    public UpdateReservationEndDate(RoomID roomID, ReservationID reservationID, EndDate endDate) {
        this.roomID = roomID;
        this.reservationID = reservationID;
        this.endDate = endDate;
    }

    public RoomID getRoomID() {
        return roomID;
    }

    public ReservationID getReservationID() {
        return reservationID;
    }

    public EndDate getEndDate() {
        return endDate;
    }
}
