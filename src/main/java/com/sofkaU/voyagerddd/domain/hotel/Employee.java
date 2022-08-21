package com.sofkaU.voyagerddd.domain.hotel;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.voyagerddd.domain.general.Name;
import com.sofkaU.voyagerddd.domain.hotel.values.EmployeeID;
import com.sofkaU.voyagerddd.domain.hotel.values.EmployeeRole;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;

public class Employee extends Entity<EmployeeID> {

    private HotelID hotelID;
    private Name name;
    private EmployeeRole employeeRole;

    public Employee(EmployeeID entityId, HotelID hotelID, Name name, EmployeeRole employeeRole) {
        super(entityId);
        this.hotelID = hotelID;
        this.name = name;
        this.employeeRole = employeeRole;
    }

    public HotelID getHotelID() {
        return hotelID;
    }

    public Name getName() {
        return name;
    }

    public EmployeeRole getEmployeeRole() {
        return employeeRole;
    }

    public void setHotelID(HotelID hotelID) {
        this.hotelID = hotelID;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setEmployeeRole(EmployeeRole employeeRole) {
        this.employeeRole = employeeRole;
    }
}
