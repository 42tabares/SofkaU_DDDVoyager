package com.sofkaU.voyagerddd.domain.room.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.voyagerddd.domain.room.values.ReservationID;
import com.sofkaU.voyagerddd.domain.room.values.RoomID;
import com.sofkaU.voyagerddd.domain.room.values.StartDate;

public class UpdateReservationStartDate extends Command {

    private final RoomID roomID;
    private final ReservationID reservationID;
    private final StartDate startDate;

    public UpdateReservationStartDate(RoomID roomID, ReservationID reservationID, StartDate startDate) {
        this.roomID = roomID;
        this.reservationID = reservationID;
        this.startDate = startDate;
    }

    public RoomID getRoomID() {
        return roomID;
    }

    public ReservationID getReservationID() {
        return reservationID;
    }

    public StartDate getStartDate() {
        return startDate;
    }
}
