package com.sofkaU.voyagerddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.voyagerddd.domain.hotel.Hotel;

import com.sofkaU.voyagerddd.domain.hotel.commands.UpdateHotelName;

public class UpdateHotelNameUseCase extends UseCase<RequestCommand<UpdateHotelName>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateHotelName> updateHotelNameRequestCommand) {
        var command = updateHotelNameRequestCommand.getCommand();
        var hotel =  Hotel.from(command.getHotelID(),retrieveEvents(command.getHotelID().value()));
        hotel.UpdateHotelName(command.getHotelID(),command.getHotelName());

        emit().onResponse(new ResponseEvents(hotel.getUncommittedChanges()));
    }
}
