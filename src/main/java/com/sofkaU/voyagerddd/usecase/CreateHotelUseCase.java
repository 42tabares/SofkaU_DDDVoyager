package com.sofkaU.voyagerddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.voyagerddd.domain.hotel.Hotel;
import com.sofkaU.voyagerddd.domain.hotel.commands.CreateHotel;


public class CreateHotelUseCase extends UseCase<RequestCommand<CreateHotel>, ResponseEvents>{
    @Override
    public void executeUseCase(RequestCommand<CreateHotel> createHotelRequestCommand) {
        var command = createHotelRequestCommand.getCommand();
        var hotel = new Hotel(
                command.getHotelID(),
                command.getHotelName()
        );
        emit().onResponse(new ResponseEvents(hotel.getUncommittedChanges()));
    }
}
