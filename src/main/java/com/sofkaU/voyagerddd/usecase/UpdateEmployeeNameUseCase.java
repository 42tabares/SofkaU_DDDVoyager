package com.sofkaU.voyagerddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.voyagerddd.domain.hotel.Hotel;
import com.sofkaU.voyagerddd.domain.hotel.commands.UpdateEmployeeName;

public class UpdateEmployeeNameUseCase extends UseCase<RequestCommand<UpdateEmployeeName>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateEmployeeName> addEmployeeRequestCommand) {
        var command = addEmployeeRequestCommand.getCommand();
        var hotel =  Hotel.from(command.getHotelID(),retrieveEvents(command.getHotelID().value()));
        hotel.UpdateEmployeeName(command.getEmployeeID(),command.getName());

        emit().onResponse(new ResponseEvents(hotel.getUncommittedChanges()));
    }
}
