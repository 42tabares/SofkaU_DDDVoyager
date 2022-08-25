package com.sofkaU.voyagerddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofkaU.voyagerddd.domain.hotel.commands.CreateHotel;
import com.sofkaU.voyagerddd.domain.hotel.events.HotelCreated;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreateHotelUseCaseTest {

    @Test
    void CreateHotelTest(){

        //Arrange
        var hotelID = HotelID.of("Elysia!");
        var hotelName = new HotelName("Ad Astra Per Aspera!");
        CreateHotel command = new CreateHotel(hotelID,hotelName);
        CreateHotelUseCase useCase = new CreateHotelUseCase();

        //Act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Error creating the Hotel"))
                .getDomainEvents();

        HotelCreated event = (HotelCreated) events.get(0);

        //Assert
        assertEquals(command.getHotelName().value(), event.getHotelName().value());
    }

}