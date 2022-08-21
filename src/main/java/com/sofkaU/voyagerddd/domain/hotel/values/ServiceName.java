package com.sofkaU.voyagerddd.domain.hotel.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ServiceName implements ValueObject<String> {
    private final String value;

    public ServiceName(String value) {
        if(value.isBlank()){
            throw new IllegalArgumentException("Service name Description must not be blank!");
        }
        if(value.length() < 5){
            throw new IllegalArgumentException("Service name description too short");
        }
        if(value.length() > 40){
            throw new IllegalArgumentException("Service name description too long");
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
        ServiceName that = (ServiceName) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
