package com.sofkaU.voyagerddd.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkaU.voyagerddd.domain.general.Cost;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;
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
class CreateRoomInvoiceUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    private final String GRAMPS_ID = "Onyria!";
    private final String PARENT_ID = "Elysia!";
    private final String CHILD_ID = "Cydonia!";

    @Test
    void CreateInvoiceTest(){

        //Arrange
        RoomCreated aggregateEvent = new RoomCreated(HotelID.of(GRAMPS_ID),new RoomNumber(200),new Cost(42));
        aggregateEvent.setAggregateRootId(PARENT_ID);

        var command = new AddInvoice(
                RoomID.of(PARENT_ID),
                InvoiceID.of(CHILD_ID),
                new InvoiceList( new ArrayList<>() ),
                new Cost(1618));

        var useCase = new CreateRoomInvoiceUseCase();

        Mockito.when(repository.getEventsBy(PARENT_ID)).thenReturn(List.of(aggregateEvent));
        useCase.addRepository(repository);


        //Act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Error adding the Invoice to room"))
                .getDomainEvents();

        InvoiceAdded event = (InvoiceAdded) events.get(0);

        //Assert
        assertEquals(command.getCost().value(), event.getCost().value());
        assertEquals(command.getInvoiceList().value(), event.getInvoiceList().value());
        Mockito.verify(repository).getEventsBy(PARENT_ID);
    }
}