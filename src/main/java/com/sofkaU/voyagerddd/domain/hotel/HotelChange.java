package com.sofkaU.voyagerddd.domain.hotel;

import co.com.sofka.domain.generic.EventChange;
import com.sofkaU.voyagerddd.domain.hotel.events.*;
import com.sofkaU.voyagerddd.domain.restaurant.events.RestaurantCreated;
import com.sofkaU.voyagerddd.domain.room.events.RoomCreated;

import java.util.HashSet;

public class HotelChange extends EventChange {

    public HotelChange(Hotel hotel){

        apply((HotelCreated event) -> {
            hotel.hotelName = event.getHotelName();
            hotel.services = new HashSet<>();
            hotel.employees = new HashSet<>();
            hotel.rooms = new HashSet<>();
            hotel.restaurants = new HashSet<>();
        });

        apply((HotelNameUpdated event) -> {
            hotel.hotelName = event.getHotelName();
        });

        apply((RoomAssigned event) -> {
            hotel.rooms.add(event.getRoomID());
        });

        apply((RestaurantAssigned event) ->{
            hotel.restaurants.add(event.getRestaurantID());
        });

        apply((EmployeeAdded event) -> {
            hotel.employees.add(new Employee(
                    event.getEmployeeID(),
                    event.getName(),
                    event.getEmployeeRole()
            ));
        });

        apply((EmployeeNameUpdated event) -> {
            var employee = hotel.getEmployeeById(event.getEmployeeID()).orElseThrow(() -> new IllegalArgumentException("No Employee found with Id"));
            employee.setName(event.getName());
        });

        apply((EmployeeRoleUpdated event) -> {
            var employee = hotel.getEmployeeById(event.getEmployeeID()).orElseThrow(() -> new IllegalArgumentException("No Employee found with Id"));
            employee.setEmployeeRole(event.getEmployeeRole());
        });

        apply((ServiceAdded event) -> {
            hotel.services.add(new Service(
                    event.getServiceID(),
                    event.getServiceName(),
                    event.getCost()
            ));
        });

        apply((ServiceNameUpdated event) -> {
            var service = hotel.getServiceById(event.getServiceID()).orElseThrow(() -> new IllegalArgumentException("No Service found with Id"));
            service.setServiceName(event.getServiceName());
        });

        apply((ServiceCostUpdated event) -> {
            var service = hotel.getServiceById(event.getServiceID()).orElseThrow(() -> new IllegalArgumentException("No Service found with Id"));
            service.setCost(event.getCost());
        });

    }
}
