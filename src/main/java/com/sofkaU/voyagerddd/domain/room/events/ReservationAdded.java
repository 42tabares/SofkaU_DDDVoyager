package com.sofkaU.voyagerddd.domain.room.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.voyagerddd.domain.room.values.EndDate;
import com.sofkaU.voyagerddd.domain.room.values.ReservationID;
import com.sofkaU.voyagerddd.domain.room.values.RoomID;
import com.sofkaU.voyagerddd.domain.room.values.StartDate;

public class ReservationAdded extends DomainEvent {

    private final ReservationID reservationID;
    private final StartDate startDate;
    private final EndDate endDate;

    public ReservationAdded(ReservationID reservationID, StartDate startDate, EndDate endDate) {
        super("room.ReservationAdded");
        this.reservationID = reservationID;
        this.startDate = startDate;
        this.endDate = endDate;
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
