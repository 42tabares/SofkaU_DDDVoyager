package com.sofkaU.voyagerddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofkaU.voyagerddd.domain.general.Cost;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelName;
import com.sofkaU.voyagerddd.domain.room.commands.CreateRoom;
import com.sofkaU.voyagerddd.domain.room.events.RoomCreated;
import com.sofkaU.voyagerddd.domain.room.values.RoomID;
import com.sofkaU.voyagerddd.domain.room.values.RoomNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class CreateRoomUseCaseTest {

    private final String HOTEL_ID = "ELYSIA1";
    private final String ROOM_ID = "ELYSIAÑ*1@";

    @Test
    void CreateRoomTest(){

        //Arrange

        var hotelID = HotelID.of("Elysia!");

        var roomID = RoomID.of("Cydonia!");
        var roomNumber = new RoomNumber(1618);
        var roomCost = new Cost(42);

        CreateRoom command = new CreateRoom(roomID,hotelID,roomNumber,roomCost);
        CreateRoomUseCase useCase = new CreateRoomUseCase();

        //Act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Error creating the room"))
                .getDomainEvents();

        RoomCreated event = (RoomCreated) events.get(0);

        //Assert
        assertEquals(command.getRoomNumber().value(), event.getRoomNumber().value());
        assertEquals(command.getCost().value(), event.getCost().value());
    }

}