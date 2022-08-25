package com.sofkaU.voyagerddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkaU.voyagerddd.domain.general.Cost;
import com.sofkaU.voyagerddd.domain.hotel.events.HotelCreated;
import com.sofkaU.voyagerddd.domain.hotel.events.RestaurantAssigned;
import com.sofkaU.voyagerddd.domain.hotel.events.RoomAssigned;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelName;
import com.sofkaU.voyagerddd.domain.restaurant.events.RestaurantCreated;
import com.sofkaU.voyagerddd.domain.restaurant.values.RestaurantID;
import com.sofkaU.voyagerddd.domain.restaurant.values.RestaurantName;
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
class AssignRestaurantToHotelUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    void RestaurantAssignmentTest(){

        //Arrange
        var hotelID = HotelID.of("Elysia!");
        var hotelName = new HotelName("Ad Astra per Aspera!");
        HotelCreated hotelCreated = new HotelCreated(hotelName);
        hotelCreated.setAggregateRootId(hotelID.value());

        
        var restaurantID = RestaurantID.of("Cydonia!");
        var restaurantName = new RestaurantName("Lux Luceat Omnia!");
        RestaurantCreated event = new RestaurantCreated(hotelID, restaurantName);
        event.setAggregateRootId(restaurantID.value());

        var useCase = new AssignRestaurantToHotelUseCase();

        Mockito.when(repository.getEventsBy(hotelID.value())).thenReturn(List.of(hotelCreated));
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(hotelID.value())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var result = (RestaurantAssigned) events.get(0);

        //Assert
        Assertions.assertEquals(result.getRestaurantID().value(), event.aggregateRootId());
        Mockito.verify(repository).getEventsBy(hotelID.value());
    }
}