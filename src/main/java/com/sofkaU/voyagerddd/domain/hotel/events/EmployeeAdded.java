package com.sofkaU.voyagerddd.domain.hotel.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.voyagerddd.domain.general.Name;
import com.sofkaU.voyagerddd.domain.hotel.values.EmployeeID;
import com.sofkaU.voyagerddd.domain.hotel.values.EmployeeRole;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;

public class EmployeeAdded extends DomainEvent {

    private final EmployeeID employeeID;
    private final Name name;
    private final EmployeeRole employeeRole;

    public EmployeeAdded(EmployeeID employeeID, Name name, EmployeeRole employeeRole) {
        super("hotel.EmployeeAdded");
        this.employeeID = employeeID;
        this.name = name;
        this.employeeRole = employeeRole;
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
