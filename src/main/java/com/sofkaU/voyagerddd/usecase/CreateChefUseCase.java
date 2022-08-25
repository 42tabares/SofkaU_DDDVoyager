package com.sofkaU.voyagerddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.voyagerddd.domain.restaurant.Restaurant;
import com.sofkaU.voyagerddd.domain.restaurant.commands.AddChef;
import com.sofkaU.voyagerddd.domain.room.Room;
import com.sofkaU.voyagerddd.domain.room.commands.AddInvoice;

public class CreateChefUseCase extends UseCase<RequestCommand<AddChef>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddChef> addChefRequestCommand) {
        var command = addChefRequestCommand.getCommand();
        var restaurant =  Restaurant.from(command.getRestaurantID(),retrieveEvents(command.getRestaurantID().value()));
        restaurant.addChef(
                command.getChefID(),
                command.getChefName(),
                command.getChefSpecialty()
        );
        emit().onResponse(new ResponseEvents(restaurant.getUncommittedChanges()));
    }
}
