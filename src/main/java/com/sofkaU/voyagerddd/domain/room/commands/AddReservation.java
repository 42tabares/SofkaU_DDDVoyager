package com.sofkaU.voyagerddd.domain.room.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.voyagerddd.domain.room.values.EndDate;
import com.sofkaU.voyagerddd.domain.room.values.ReservationID;
import com.sofkaU.voyagerddd.domain.room.values.RoomID;
import com.sofkaU.voyagerddd.domain.room.values.StartDate;

public class AddReservation extends Command {
    private final RoomID roomID;
    private final ReservationID reservationID;
    private final StartDate startDate;
    private final EndDate endDate;

    public AddReservation(RoomID roomID, ReservationID reservationID, StartDate startDate, EndDate endDate) {
        this.roomID = roomID;
        this.reservationID = reservationID;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public EndDate getEndDate() {
        return endDate;
    }
}
