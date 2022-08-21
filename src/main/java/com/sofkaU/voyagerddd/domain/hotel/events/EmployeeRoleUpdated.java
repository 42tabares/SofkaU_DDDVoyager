package com.sofkaU.voyagerddd.domain.hotel.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.voyagerddd.domain.hotel.values.EmployeeID;
import com.sofkaU.voyagerddd.domain.hotel.values.EmployeeRole;

public class EmployeeRoleUpdated extends DomainEvent {

    private final EmployeeID employeeID;
    private final EmployeeRole employeeRole;

    public EmployeeRoleUpdated(EmployeeID employeeID, EmployeeRole employeeRole) {
        super("hotel.EmployeeRoleUpdated");
        this.employeeID = employeeID;
        this.employeeRole = employeeRole;
    }
}
