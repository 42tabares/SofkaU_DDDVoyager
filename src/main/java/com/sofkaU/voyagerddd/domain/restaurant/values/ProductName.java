package com.sofkaU.voyagerddd.domain.restaurant.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ProductName implements ValueObject<String> {

    private final String value;

    public ProductName(String value) {
        if(value.isBlank()){
            throw new IllegalArgumentException("Product name must not be blank!");
        }
        if(value.length() < 10){
            throw new IllegalArgumentException("Product name is too short!");
        }
        if(value.length() > 50){
            throw new IllegalArgumentException("Product name is too long!");
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
        ProductName that = (ProductName) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
