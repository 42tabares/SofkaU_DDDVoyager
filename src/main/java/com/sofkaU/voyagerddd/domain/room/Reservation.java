package com.sofkaU.voyagerddd.domain.room;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.Entity;
import com.sofkaU.voyagerddd.domain.room.values.EndDate;
import com.sofkaU.voyagerddd.domain.room.values.ReservationID;
import com.sofkaU.voyagerddd.domain.room.values.RoomID;
import com.sofkaU.voyagerddd.domain.room.values.StartDate;

public class Reservation extends Entity<ReservationID> {
    private ReservationID reservationID;
    private StartDate startDate;
    private EndDate endDate;

    public Reservation(ReservationID entityId, StartDate startDate, EndDate endDate) {
        super(entityId);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public StartDate getStartDate() {
        return startDate;
    }

    public void setStartDate(StartDate startDate) {
        this.startDate = startDate;
    }

    public EndDate getEndDate() {
        return endDate;
    }

    public void setEndDate(EndDate endDate) {
        this.endDate = endDate;
    }
}
