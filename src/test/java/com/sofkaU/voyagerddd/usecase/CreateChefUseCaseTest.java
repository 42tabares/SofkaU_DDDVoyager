package com.sofkaU.voyagerddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkaU.voyagerddd.domain.general.Name;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;
import com.sofkaU.voyagerddd.domain.restaurant.commands.AddChef;
import com.sofkaU.voyagerddd.domain.restaurant.events.ChefAdded;
import com.sofkaU.voyagerddd.domain.restaurant.events.RestaurantCreated;
import com.sofkaU.voyagerddd.domain.restaurant.values.ChefID;
import com.sofkaU.voyagerddd.domain.restaurant.values.ChefSpecialty;
import com.sofkaU.voyagerddd.domain.restaurant.values.RestaurantID;
import com.sofkaU.voyagerddd.domain.restaurant.values.RestaurantName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreateChefUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void CreateChefTest(){

        //Arrange
        var hotelID = HotelID.of("Elysia!");
        var restaurantID = RestaurantID.of("Cydonia!");
        var restaurantName = new RestaurantName("Lux Luceat Omnia!");

        RestaurantCreated restaurantCreated = new RestaurantCreated(hotelID,restaurantName);

        var chefID = ChefID.of("3141");
        var chefName = new Name("Solaris Leo");
        var chefSpecialty = new ChefSpecialty("BAKER");
        AddChef command = new AddChef(restaurantID,chefID,chefName,chefSpecialty);

        CreateChefUseCase useCase = new CreateChefUseCase();

        Mockito.when(repository.getEventsBy(restaurantID.value())).thenReturn(List.of(restaurantCreated));
        useCase.addRepository(repository);


        //Act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Error adding the Invoice to room"))
                .getDomainEvents();

        ChefAdded event = (ChefAdded) events.get(0);

        //Assert
        assertEquals(command.getChefName().value(), event.getChefName().value());
        assertEquals(command.getChefSpecialty().value(), event.getChefSpecialty().value());
        Mockito.verify(repository).getEventsBy(restaurantID.value());
    }
}