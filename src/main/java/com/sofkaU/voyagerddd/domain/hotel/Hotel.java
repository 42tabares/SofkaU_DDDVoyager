package com.sofkaU.voyagerddd.domain.hotel;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.voyagerddd.domain.general.Cost;
import com.sofkaU.voyagerddd.domain.general.Name;
import com.sofkaU.voyagerddd.domain.hotel.events.*;
import com.sofkaU.voyagerddd.domain.hotel.values.EmployeeID;
import com.sofkaU.voyagerddd.domain.hotel.values.EmployeeRole;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelName;
import com.sofkaU.voyagerddd.domain.hotel.values.ServiceID;
import com.sofkaU.voyagerddd.domain.hotel.values.ServiceName;
import com.sofkaU.voyagerddd.domain.restaurant.Chef;
import com.sofkaU.voyagerddd.domain.restaurant.Product;
import com.sofkaU.voyagerddd.domain.restaurant.events.ChefAdded;
import com.sofkaU.voyagerddd.domain.restaurant.values.ChefID;
import com.sofkaU.voyagerddd.domain.restaurant.values.ProductID;
import com.sofkaU.voyagerddd.domain.restaurant.values.RestaurantID;
import com.sofkaU.voyagerddd.domain.room.values.RoomID;

import javax.management.relation.Role;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Hotel extends AggregateEvent<HotelID> {

    protected HotelName hotelName;
    protected Set<Service> services;
    protected Set<Employee> employees;
    protected Set<RoomID> rooms;
    protected Set<RestaurantID> restaurants;

    public Hotel(HotelID entityId, HotelName hotelName) {
        super(entityId);
        subscribe(new HotelChange(this));
        appendChange(new HotelCreated(hotelName)).apply();
    }

    private Hotel(HotelID hotelID){
        super(hotelID);
        subscribe(new HotelChange(this));
    }

    public static Hotel from(HotelID hotelID, List<DomainEvent> events){
        var hotel = new Hotel(hotelID);
        events.forEach(hotel::applyEvent);
        return hotel;
    }

    public void appendRoomID(RoomID roomID){
        Objects.requireNonNull(roomID);
        appendChange(new RoomAssigned(roomID)).apply();
    }

    public void addEmployee(EmployeeID entityID, Name name, EmployeeRole role){
        Objects.requireNonNull(entityID);
        Objects.requireNonNull(name);
        Objects.requireNonNull(role);
        appendChange(new EmployeeAdded(entityID,name,role)).apply();
    }
    public void addService(ServiceID entityID, ServiceName name, Cost cost){
        Objects.requireNonNull(entityID);
        Objects.requireNonNull(name);
        Objects.requireNonNull(cost);
        appendChange(new ServiceAdded(entityID,name,cost)).apply();
    }
    public void UpdateEmployeeName(EmployeeID entityID, Name name){
        Objects.requireNonNull(entityID);
        Objects.requireNonNull(name);
        appendChange(new EmployeeNameUpdated(entityID,name)).apply();
    }

    public void UpdateEmployeeRole(EmployeeID entityID, EmployeeRole role){
        Objects.requireNonNull(entityID);
        Objects.requireNonNull(role);
        appendChange(new EmployeeRoleUpdated(entityID,role)).apply();
    }

    public void UpdateServiceCost(ServiceID entityID, Cost cost){
        Objects.requireNonNull(entityID);
        Objects.requireNonNull(cost);
        appendChange(new ServiceCostUpdated(entityID,cost)).apply();
    }

    public void UpdateServiceName(ServiceID entityID, ServiceName name){
        Objects.requireNonNull(entityID);
        Objects.requireNonNull(name);
        appendChange(new ServiceNameUpdated(entityID,name)).apply();
    }

    public void UpdateHotelName(HotelID entityID, HotelName name){
        Objects.requireNonNull(entityID);
        appendChange(new HotelNameUpdated(entityID,name)).apply();
    }

    public Optional<Employee> getEmployeeById(EmployeeID employeeID){
        return employees.stream().filter((employee -> employee.identity().equals(employeeID))).findFirst();
    }
    public Optional<Service> getServiceById(ServiceID serviceID){
        return services.stream().filter((service -> service.identity().equals(serviceID))).findFirst();
    }

    public Set<Service> services() {
        return services;
    }

    public Set<Employee> employees() {
        return employees;
    }
}
