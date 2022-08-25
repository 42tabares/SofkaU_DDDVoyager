package com.sofkaU.voyagerddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkaU.voyagerddd.domain.general.Cost;
import com.sofkaU.voyagerddd.domain.hotel.events.HotelCreated;
import com.sofkaU.voyagerddd.domain.hotel.events.RoomAssigned;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelName;
import com.sofkaU.voyagerddd.domain.room.events.RoomCreated;
import com.sofkaU.voyagerddd.domain.room.values.RoomNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AssignRoomToHotelUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    void RoomAssignmentTest(){

        //Arrange
        var HOTEL_ID = "33333";
        var HOTEL_NAME = new HotelName("Lorem Ipsum");

        HotelCreated hotelCreated = new HotelCreated(HOTEL_NAME);
        hotelCreated.setAggregateRootId(HOTEL_ID);

        RoomCreated event = new RoomCreated(HotelID.of(HOTEL_ID), new RoomNumber(3213), new Cost(1000));
        event.setAggregateRootId("xxxxxxx");

        var useCase = new AssignRoomToHotelUseCase();

        Mockito.when(repository.getEventsBy(HOTEL_ID)).thenReturn(List.of(hotelCreated));
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(HOTEL_ID)
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var result = (RoomAssigned)events.get(0);

        //Assert
        Assertions.assertEquals(result.getRoomID().value(), event.aggregateRootId());
        Mockito.verify(repository).getEventsBy(HOTEL_ID);
    }
}