package com.sofkaU.voyagerddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.voyagerddd.domain.hotel.Hotel;
import com.sofkaU.voyagerddd.domain.hotel.commands.AddEmployee;


public class CreateEmployeeUseCase extends UseCase<RequestCommand<AddEmployee>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddEmployee> addEmployeeRequestCommand) {
        var command = addEmployeeRequestCommand.getCommand();
        var hotel =  Hotel.from(command.getHotelID(),retrieveEvents(command.getHotelID().value()));
        hotel.addEmployee(
                command.getEmployeeID(),
                command.getName(),
                command.getEmployeeRole()
        );
        emit().onResponse(new ResponseEvents(hotel.getUncommittedChanges()));
    }
}
