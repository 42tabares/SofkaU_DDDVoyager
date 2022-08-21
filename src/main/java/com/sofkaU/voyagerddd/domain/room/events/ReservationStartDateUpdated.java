package com.sofkaU.voyagerddd.domain.room.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.voyagerddd.domain.room.values.ReservationID;
import com.sofkaU.voyagerddd.domain.room.values.StartDate;

public class ReservationStartDateUpdated extends DomainEvent {

    private final ReservationID reservationID;
    private final StartDate startDate;

    public ReservationStartDateUpdated( ReservationID reservationID, StartDate startDate) {
        super("room.ReservationStartDateUpdated");
        this.reservationID = reservationID;
        this.startDate = startDate;
    }

    public ReservationID getReservationID() {
        return reservationID;
    }

    public StartDate getStartDate() {
        return startDate;
    }
}
