package com.sofkaU.voyagerddd.domain.hotel.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.voyagerddd.domain.general.Name;
import com.sofkaU.voyagerddd.domain.hotel.values.EmployeeID;
import com.sofkaU.voyagerddd.domain.hotel.values.EmployeeRole;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;

public class AddEmployee extends Command {

    private final HotelID hotelID;
    private final EmployeeID employeeID;
    private final Name name;
    private final EmployeeRole employeeRole;

    public AddEmployee(HotelID hotelID, EmployeeID employeeID, Name name, EmployeeRole employeeRole) {
        this.hotelID = hotelID;
        this.employeeID = employeeID;
        this.name = name;
        this.employeeRole = employeeRole;
    }

    public HotelID getHotelID() {
        return hotelID;
    }

    public EmployeeID getEmployeeID() {
        return employeeID;
    }

    public Name getName() {
        return name;
    }

    public EmployeeRole getEmployeeRole() {
        return employeeRole;
    }
}
