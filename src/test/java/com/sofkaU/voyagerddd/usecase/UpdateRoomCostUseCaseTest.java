package com.sofkaU.voyagerddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkaU.voyagerddd.domain.general.Cost;
import com.sofkaU.voyagerddd.domain.hotel.commands.UpdateHotelName;
import com.sofkaU.voyagerddd.domain.hotel.events.HotelCreated;
import com.sofkaU.voyagerddd.domain.hotel.events.HotelNameUpdated;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelName;
import com.sofkaU.voyagerddd.domain.room.commands.CreateRoom;
import com.sofkaU.voyagerddd.domain.room.commands.UpdateRoomCost;
import com.sofkaU.voyagerddd.domain.room.events.RoomCostUpdated;
import com.sofkaU.voyagerddd.domain.room.events.RoomCreated;
import com.sofkaU.voyagerddd.domain.room.values.RoomID;
import com.sofkaU.voyagerddd.domain.room.values.RoomNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UpdateRoomCostUseCaseTest {

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


        UpdateRoomCost command = new UpdateRoomCost(hotelID,roomID,new Cost(400));
        UpdateRoomCostUseCase useCase = new UpdateRoomCostUseCase();

        Mockito.when(repository.getEventsBy(hotelID.value())).thenReturn(List.of(roomCreated));
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Error changing the room cost!"))
                .getDomainEvents();

        RoomCostUpdated event = (RoomCostUpdated) events.get(0);

        //Assert
        assertEquals(command.getCost().value(), event.getCost().value());
    }

}