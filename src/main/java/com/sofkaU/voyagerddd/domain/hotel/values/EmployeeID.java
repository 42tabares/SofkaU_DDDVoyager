package com.sofkaU.voyagerddd.domain.hotel.values;

import co.com.sofka.domain.generic.Identity;

public class EmployeeID extends Identity {
    public EmployeeID() {}
    private EmployeeID(String id){
        super(id);
    }

    public static EmployeeID of(String id) {
        return new EmployeeID(id);
    }
}
