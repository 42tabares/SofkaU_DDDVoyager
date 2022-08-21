package com.sofkaU.voyagerddd.domain.hotel.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.voyagerddd.domain.general.Name;
import com.sofkaU.voyagerddd.domain.hotel.values.EmployeeID;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;

public class UpdateEmployeeName extends Command {

    private final HotelID hotelID;
    private final EmployeeID employeeID;
    private final Name name;

    public UpdateEmployeeName(HotelID hotelID, EmployeeID employeeID, Name name) {
        this.hotelID = hotelID;
        this.employeeID = employeeID;
        this.name = name;
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
}
