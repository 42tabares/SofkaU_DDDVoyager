package com.sofkaU.voyagerddd.domain.hotel.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.voyagerddd.domain.general.Name;
import com.sofkaU.voyagerddd.domain.hotel.values.EmployeeID;

public class EmployeeNameUpdated extends DomainEvent {

    private final EmployeeID employeeID;
    private final Name name;

    public EmployeeNameUpdated(EmployeeID employeeID, Name name) {
        super("hotel.EmployeeNameUpdated");
        this.employeeID = employeeID;
        this.name = name;
    }

    public EmployeeID getEmployeeID() {
        return employeeID;
    }

    public Name getName() {
        return name;
    }
}
