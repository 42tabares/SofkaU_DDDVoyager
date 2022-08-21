package com.sofkaU.voyagerddd.domain.restaurant.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class RestaurantName implements ValueObject<String> {

    private final String value;

    public RestaurantName(String value) {
        if(value.isBlank()){
            throw new IllegalArgumentException("Restaurant's name must not be blank!");
        }
        if(value.length() < 5){
            throw new IllegalArgumentException("Restaurant name is too short!");
        }
        if(value.length() > 50){
            throw new IllegalArgumentException("Restaurant name too long!");
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
        RestaurantName that = (RestaurantName) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
