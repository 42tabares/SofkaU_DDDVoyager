package com.sofkaU.voyagerddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkaU.voyagerddd.domain.general.Cost;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;
import com.sofkaU.voyagerddd.domain.room.commands.UpdateRoomCost;
import com.sofkaU.voyagerddd.domain.room.commands.UpdateRoomNumber;
import com.sofkaU.voyagerddd.domain.room.events.RoomCostUpdated;
import com.sofkaU.voyagerddd.domain.room.events.RoomCreated;
import com.sofkaU.voyagerddd.domain.room.events.RoomNumberUpdated;
import com.sofkaU.voyagerddd.domain.room.values.RoomID;
import com.sofkaU.voyagerddd.domain.room.values.RoomNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UpdateRoomNumberUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void ChangeRoomCostTest(){

        //Arrange

        var hotelID = HotelID.of("Elysia!");

        var roomID = RoomID.of("Cydonia!");
        var roomNumber = new RoomNumber(1618);
        var roomCost = new Cost(42);
        RoomCreated roomCreated = new RoomCreated(hotelID,roomNumber,roomCost);


        UpdateRoomNumber command = new UpdateRoomNumber(hotelID,roomID,new RoomNumber(3141));
        UpdateRoomNumberUseCase useCase = new UpdateRoomNumberUseCase();

        Mockito.when(repository.getEventsBy(hotelID.value())).thenReturn(List.of(roomCreated));
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Error changing the hotel number!"))
                .getDomainEvents();

        RoomNumberUpdated event = (RoomNumberUpdated) events.get(0);

        //Assert
        assertEquals(command.getRoomNumber().value(), event.getRoomNumber().value());
    }

}