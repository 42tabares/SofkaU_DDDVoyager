package com.sofkaU.voyagerddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkaU.voyagerddd.domain.hotel.Hotel;
import com.sofkaU.voyagerddd.domain.room.events.RoomCreated;
import com.sofkaU.voyagerddd.domain.room.values.RoomID;

public class AssignRoomToHotelUseCase extends UseCase<TriggeredEvent<RoomCreated>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<RoomCreated> roomCreatedTriggeredEvent) {
        var event = roomCreatedTriggeredEvent.getDomainEvent();
        var hotel = Hotel.from(event.getHotelID(), retrieveEvents(event.getHotelID().value()));
        hotel.appendRoomID(RoomID.of(event.aggregateRootId()));

        emit().onResponse(new ResponseEvents(hotel.getUncommittedChanges()));
    }
}
