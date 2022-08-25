package com.sofkaU.voyagerddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkaU.voyagerddd.domain.general.Cost;
import com.sofkaU.voyagerddd.domain.general.Name;
import com.sofkaU.voyagerddd.domain.hotel.commands.AddEmployee;
import com.sofkaU.voyagerddd.domain.hotel.commands.UpdateEmployeeName;
import com.sofkaU.voyagerddd.domain.hotel.events.EmployeeAdded;
import com.sofkaU.voyagerddd.domain.hotel.events.EmployeeNameUpdated;
import com.sofkaU.voyagerddd.domain.hotel.events.HotelCreated;
import com.sofkaU.voyagerddd.domain.hotel.values.EmployeeID;
import com.sofkaU.voyagerddd.domain.hotel.values.EmployeeRole;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelName;
import com.sofkaU.voyagerddd.domain.room.commands.AddInvoice;
import com.sofkaU.voyagerddd.domain.room.events.InvoiceAdded;
import com.sofkaU.voyagerddd.domain.room.events.RoomCreated;
import com.sofkaU.voyagerddd.domain.room.values.InvoiceID;
import com.sofkaU.voyagerddd.domain.room.values.InvoiceList;
import com.sofkaU.voyagerddd.domain.room.values.RoomID;
import com.sofkaU.voyagerddd.domain.room.values.RoomNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UpdateEmployeeNameUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    private final String hotelID = "42";
    private final String employeeID = "1618";


    @Test
    void ChangeNameTest(){

        var HOTEL_ID = HotelID.of(hotelID);

        //Arrange
        HotelCreated aggregateEvent = new HotelCreated(new HotelName("Palace of Marbles"));
        aggregateEvent.setAggregateRootId(HOTEL_ID.value());


        var EMPLOYEE_ID = EmployeeID.of(employeeID);
        var name = new Name("Ralsei Dreemurr");
        var role = new EmployeeRole("Prince of Darkness");
        EmployeeAdded addedEmployee = new EmployeeAdded(EMPLOYEE_ID,name,role);
        System.out.println("I am " + name.value());

        var newName = new Name("Ralsei Deltarune Dreemurr");
        var command = new UpdateEmployeeName(HOTEL_ID,EMPLOYEE_ID,newName);
        var useCase = new UpdateEmployeeNameUseCase();

        Mockito.when(repository.getEventsBy(hotelID)).thenReturn(List.of(aggregateEvent,addedEmployee));
        useCase.addRepository(repository);


        //Act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Error updating employee's name"))
                .getDomainEvents();

        EmployeeNameUpdated event = (EmployeeNameUpdated) events.get(0);

        //Assert
        assertEquals(command.getName().value(), event.getName().value());
        Mockito.verify(repository).getEventsBy(hotelID);

        System.out.println("Oh sorry, I'm actually " + event.getName().value());
    }
}