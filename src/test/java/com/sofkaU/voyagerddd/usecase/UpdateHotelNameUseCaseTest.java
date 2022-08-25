package com.sofkaU.voyagerddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.voyagerddd.domain.hotel.commands.CreateHotel;
import com.sofkaU.voyagerddd.domain.hotel.commands.UpdateHotelName;
import com.sofkaU.voyagerddd.domain.hotel.events.HotelCreated;
import com.sofkaU.voyagerddd.domain.hotel.events.HotelNameUpdated;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UpdateHotelNameUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void ChangeHotelNameTest(){

        //Arrange
        var hotelID = HotelID.of("Elysia!");

        var hotelName = new HotelName("Ad Astra per Aspera!");
        HotelCreated hotelCreated = new HotelCreated(hotelName);
        hotelCreated.setAggregateRootId(hotelID.value());

        UpdateHotelName command = new UpdateHotelName(hotelID,new HotelName("Palace of Marbles"));
        UpdateHotelNameUseCase useCase = new UpdateHotelNameUseCase();

        Mockito.when(repository.getEventsBy(hotelID.value())).thenReturn(List.of(hotelCreated));
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Error changing the hotel name!"))
                .getDomainEvents();

        HotelNameUpdated event = (HotelNameUpdated) events.get(0);

        //Assert
        assertEquals(command.getHotelName().value(), event.getHotelName().value());
    }

}