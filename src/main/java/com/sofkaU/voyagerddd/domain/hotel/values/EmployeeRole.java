package com.sofkaU.voyagerddd.domain.hotel.values;

import co.com.sofka.domain.generic.ValueObject;
import com.sofkaU.voyagerddd.domain.restaurant.values.RestaurantName;

import java.util.Objects;

public class EmployeeRole implements ValueObject<String> {
    private final String value;

    public EmployeeRole(String value) {
        if(value.isBlank()){
            throw new IllegalArgumentException("Role Description must not be blank!");
        }
        if(value.length() < 5){
            throw new IllegalArgumentException("Role description too short");
        }
        if(value.length() > 20){
            throw new IllegalArgumentException("Role description too long");
        }
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeRole that = (EmployeeRole) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
