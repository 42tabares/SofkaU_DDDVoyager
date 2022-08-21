package com.sofkaU.voyagerddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.voyagerddd.domain.room.Room;
import com.sofkaU.voyagerddd.domain.room.commands.CreateRoom;

public class CreateRoomUseCase extends UseCase<RequestCommand<CreateRoom>, ResponseEvents> {

    public void executeUseCase(RequestCommand<CreateRoom> createRoomRequestCommand) {
        var command = createRoomRequestCommand.getCommand();
        var room = new Room(
                command.getRoomID(),
                command.getRoomNumber(),
                command.getCost()
        );
        emit().onResponse(new ResponseEvents(room.getUncommittedChanges()));
    }
}
