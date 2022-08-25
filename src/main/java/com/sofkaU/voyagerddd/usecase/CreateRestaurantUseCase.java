package com.sofkaU.voyagerddd.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.voyagerddd.domain.restaurant.Restaurant;
import com.sofkaU.voyagerddd.domain.restaurant.commands.CreateRestaurant;


public class CreateRestaurantUseCase extends UseCase<RequestCommand<CreateRestaurant>, ResponseEvents>{
    @Override
    public void executeUseCase(RequestCommand<CreateRestaurant> createRestaurantRequestCommand) {
        var command = createRestaurantRequestCommand.getCommand();
        var restaurant = new Restaurant(
                command.getRestaurantID(),
                command.getHotelID(),
                command.getRestaurantName()
        );
        emit().onResponse(new ResponseEvents(restaurant.getUncommittedChanges()));
    }
}
