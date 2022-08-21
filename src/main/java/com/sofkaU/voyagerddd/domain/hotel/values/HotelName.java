package com.sofkaU.voyagerddd.domain.hotel.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class HotelName implements ValueObject<String> {

    private final String value;

    public HotelName(String value) {
        if(value.isBlank()){
            throw new IllegalArgumentException("Hotel name must not be blank!");
        }
        if(value.length() < 10){
            throw new IllegalArgumentException("Hotel name is too short!");
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
        HotelName that = (HotelName) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
