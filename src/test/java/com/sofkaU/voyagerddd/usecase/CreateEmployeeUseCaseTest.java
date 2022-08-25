package com.sofkaU.voyagerddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkaU.voyagerddd.domain.general.Name;
import com.sofkaU.voyagerddd.domain.hotel.commands.AddEmployee;
import com.sofkaU.voyagerddd.domain.hotel.events.EmployeeAdded;
import com.sofkaU.voyagerddd.domain.hotel.events.HotelCreated;
import com.sofkaU.voyagerddd.domain.hotel.values.EmployeeID;
import com.sofkaU.voyagerddd.domain.hotel.values.EmployeeRole;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CreateEmployeeUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    private final String hotelID = "42";
    private final String employeeID = "1618";


    @Test
    void CreateEmployeeTest(){

        //Arrange
        HotelCreated aggregateEvent = new HotelCreated(new HotelName("Palace of Marbles"));
        aggregateEvent.setAggregateRootId(hotelID);

        var command = new AddEmployee(
                HotelID.of(hotelID),
                EmployeeID.of(employeeID),
                new Name("Ralsei Dreemurr"),
                new EmployeeRole("Prince of Darkness")
                );

        var useCase = new CreateEmployeeUseCase();

        Mockito.when(repository.getEventsBy(hotelID)).thenReturn(List.of(aggregateEvent));
        useCase.addRepository(repository);


        //Act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Error creating the employee"))
                .getDomainEvents();


        EmployeeAdded event = (EmployeeAdded) events.get(0);

        //Assert
        assertEquals(command.getEmployeeRole().value(), event.getEmployeeRole().value());
        assertEquals(command.getName().value(), event.getName().value());
        Mockito.verify(repository).getEventsBy(hotelID);
    }
}