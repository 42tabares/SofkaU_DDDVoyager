package com.sofkaU.voyagerddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkaU.voyagerddd.domain.hotel.Hotel;
import com.sofkaU.voyagerddd.domain.restaurant.events.RestaurantCreated;
import com.sofkaU.voyagerddd.domain.restaurant.values.RestaurantID;
import com.sofkaU.voyagerddd.domain.room.events.RoomCreated;
import com.sofkaU.voyagerddd.domain.room.values.RoomID;

public class AssignRestaurantToHotelUseCase extends UseCase<TriggeredEvent<RestaurantCreated>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<RestaurantCreated> restaurantCreatedTriggeredEvent) {
        var event = restaurantCreatedTriggeredEvent.getDomainEvent();
        var hotel = Hotel.from(event.getHotelID(), retrieveEvents(event.getHotelID().value()));
        hotel.appendRestaurantID(RestaurantID.of(event.aggregateRootId()));

        emit().onResponse(new ResponseEvents(hotel.getUncommittedChanges()));
    }

}
