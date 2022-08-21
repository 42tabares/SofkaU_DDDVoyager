package com.sofkaU.voyagerddd.domain.hotel.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.voyagerddd.domain.hotel.values.EmployeeID;
import com.sofkaU.voyagerddd.domain.hotel.values.EmployeeRole;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;

public class UpdateEmployeeRole extends Command {

    private final HotelID hotelID;
    private final EmployeeID employeeID;
    private final EmployeeRole employeeRole;

    public UpdateEmployeeRole(HotelID hotelID, EmployeeID employeeID, EmployeeRole employeeRole) {
        this.hotelID = hotelID;
        this.employeeID = employeeID;
        this.employeeRole = employeeRole;
    }

    public HotelID getHotelID() {
        return hotelID;
    }

    public EmployeeID getEmployeeID() {
        return employeeID;
    }

    public EmployeeRole getEmployeeRole() {
        return employeeRole;
    }
}
