package com.sofkaU.voyagerddd.domain.general;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Name implements ValueObject<String> {

    private final String value;

    public Name(String value) {
        if(value.isBlank()){
            throw new IllegalArgumentException("A person's name must not be blank!");
        }
        if(value.length() < 5){
            throw new IllegalArgumentException("Person's name is too short, consider adding last name");
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
        Name that = (Name) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
