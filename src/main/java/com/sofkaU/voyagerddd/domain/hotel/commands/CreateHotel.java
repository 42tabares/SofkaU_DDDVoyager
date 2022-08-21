package com.sofkaU.voyagerddd.domain.hotel.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.voyagerddd.domain.hotel.Employee;
import com.sofkaU.voyagerddd.domain.hotel.Service;
import com.sofkaU.voyagerddd.domain.hotel.values.Restaurants;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelName;
import com.sofkaU.voyagerddd.domain.hotel.values.Rooms;

import java.util.Set;

public class CreateHotel extends Command {

    private final HotelID hotelID;
    private final HotelName hotelName;
    private final Restaurants restaurants;
    private final Rooms rooms;
    private final Set<Employee> employees;
    private final Set<Service> services;

    public CreateHotel(HotelID hotelID, HotelName hotelName, Restaurants restaurants, Rooms rooms, Set<Employee> employees, Set<Service> services) {
        this.hotelID = hotelID;
        this.hotelName = hotelName;
        this.restaurants = restaurants;
        this.rooms = rooms;
        this.employees = employees;
        this.services = services;
    }

    public HotelID getHotelID() {
        return hotelID;
    }

    public HotelName getHotelName() {
        return hotelName;
    }

    public Restaurants getRestaurants() {
        return restaurants;
    }

    public Rooms getRooms() {
        return rooms;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public Set<Service> getServices() {
        return services;
    }
}
