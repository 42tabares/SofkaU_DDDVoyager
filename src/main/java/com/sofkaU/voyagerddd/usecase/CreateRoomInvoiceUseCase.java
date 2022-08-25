package com.sofkaU.voyagerddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.voyagerddd.domain.room.Room;
import com.sofkaU.voyagerddd.domain.room.commands.AddInvoice;

public class CreateRoomInvoiceUseCase extends UseCase<RequestCommand<AddInvoice>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddInvoice> addInvoiceRequestCommand) {
        var command = addInvoiceRequestCommand.getCommand();
        var room =  Room.from(command.getRoomID(),retrieveEvents(command.getRoomID().value()));
        room.addInvoice(
                command.getInvoiceID(),
                command.getInvoiceList(),
                command.getCost()
                );
        emit().onResponse(new ResponseEvents(room.getUncommittedChanges()));
    }
}
