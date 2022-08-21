package com.sofkaU.voyagerddd.domain.general;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Cost implements ValueObject<Integer> {

    private final Integer value;

    public Cost(Integer value) {
        this.value = value;
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cost that = (Cost) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
