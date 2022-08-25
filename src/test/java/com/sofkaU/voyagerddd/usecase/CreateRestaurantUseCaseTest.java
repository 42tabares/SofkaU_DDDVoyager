package com.sofkaU.voyagerddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofkaU.voyagerddd.domain.general.Cost;
import com.sofkaU.voyagerddd.domain.hotel.commands.CreateHotel;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelName;
import com.sofkaU.voyagerddd.domain.restaurant.Restaurant;
import com.sofkaU.voyagerddd.domain.restaurant.commands.CreateRestaurant;
import com.sofkaU.voyagerddd.domain.restaurant.events.RestaurantCreated;
import com.sofkaU.voyagerddd.domain.restaurant.values.RestaurantID;
import com.sofkaU.voyagerddd.domain.restaurant.values.RestaurantName;
import com.sofkaU.voyagerddd.domain.room.commands.CreateRoom;
import com.sofkaU.voyagerddd.domain.room.events.RoomCreated;
import com.sofkaU.voyagerddd.domain.room.values.RoomID;
import com.sofkaU.voyagerddd.domain.room.values.RoomNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreateRestaurantUseCaseTest {

    @Test
    void CreateRestaurantTest(){

        //Arrange
        var hotelID = HotelID.of("Elysia!");

        var restaurantID = RestaurantID.of("Cydonia!");
        var restaurantName = new RestaurantName("Lux Luceat Omnia!");

        CreateRestaurant command = new CreateRestaurant(restaurantID,hotelID,restaurantName);
        CreateRestaurantUseCase useCase = new CreateRestaurantUseCase();

        //Act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Error creating the restaurant"))
                .getDomainEvents();

        RestaurantCreated event = (RestaurantCreated) events.get(0);

        //Assert
        assertEquals(command.getRestaurantName().value(), event.getRestaurantName().value());
    }

}