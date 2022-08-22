package com.sofkaU.voyagerddd.domain.hotel;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.voyagerddd.domain.general.Name;
import com.sofkaU.voyagerddd.domain.hotel.values.EmployeeID;
import com.sofkaU.voyagerddd.domain.hotel.values.EmployeeRole;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;

public class Employee extends Entity<EmployeeID> {

    private Name name;
    private EmployeeRole employeeRole;

    public Employee(EmployeeID entityId, Name name, EmployeeRole employeeRole) {
        super(entityId);
        this.name = name;
        this.employeeRole = employeeRole;
    }

    public Name getName() {
        return name;
    }

    public EmployeeRole getEmployeeRole() {
        return employeeRole;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setEmployeeRole(EmployeeRole employeeRole) {
        this.employeeRole = employeeRole;
    }
}
