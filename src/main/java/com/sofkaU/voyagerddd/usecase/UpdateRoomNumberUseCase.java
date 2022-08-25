package com.sofkaU.voyagerddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.voyagerddd.domain.room.Room;
import com.sofkaU.voyagerddd.domain.room.commands.UpdateRoomCost;
import com.sofkaU.voyagerddd.domain.room.commands.UpdateRoomNumber;

public class UpdateRoomNumberUseCase extends UseCase<RequestCommand<UpdateRoomNumber>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateRoomNumber> updateRoomNumberRequestCommand) {
        var command = updateRoomNumberRequestCommand.getCommand();
        var room =  Room.from(command.getRoomID(),retrieveEvents(command.getHotelID().value()));
        room.updateRoomNumber(command.getRoomID(),command.getRoomNumber());

        emit().onResponse(new ResponseEvents(room.getUncommittedChanges()));
    }
}
