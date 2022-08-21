package com.sofkaU.voyagerddd.domain.room.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.voyagerddd.domain.room.values.EndDate;
import com.sofkaU.voyagerddd.domain.room.values.ReservationID;

public class ReservationEndDateUpdated extends DomainEvent {

    private final ReservationID reservationID;
    private final EndDate endDate;

    public ReservationEndDateUpdated(ReservationID reservationID, EndDate endDate) {
        super("room.ReservationEndDateUpdated");
        this.reservationID = reservationID;
        this.endDate = endDate;
    }

    public ReservationID getReservationID() {
        return reservationID;
    }

    public EndDate getEndDate() {
        return endDate;
    }
}
