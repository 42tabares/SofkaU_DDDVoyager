package com.sofkaU.voyagerddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.voyagerddd.domain.hotel.Hotel;
import com.sofkaU.voyagerddd.domain.hotel.commands.UpdateHotelName;
import com.sofkaU.voyagerddd.domain.restaurant.Restaurant;
import com.sofkaU.voyagerddd.domain.room.Room;
import com.sofkaU.voyagerddd.domain.room.commands.UpdateRoomCost;

public class UpdateRoomCostUseCase extends UseCase<RequestCommand<UpdateRoomCost>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateRoomCost> updateRoomCostRequestCommand) {
        var command = updateRoomCostRequestCommand.getCommand();
        var room =  Room.from(command.getRoomID(),retrieveEvents(command.getHotelID().value()));
        room.updateRoomCost(command.getRoomID(),command.getCost());

        emit().onResponse(new ResponseEvents(room.getUncommittedChanges()));
    }
}
