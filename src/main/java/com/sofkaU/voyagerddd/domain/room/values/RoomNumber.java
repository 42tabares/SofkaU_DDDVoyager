package com.sofkaU.voyagerddd.domain.room.values;

import co.com.sofka.domain.generic.ValueObject;
import com.sofkaU.voyagerddd.domain.general.Cost;

import java.util.Objects;

public class RoomNumber implements ValueObject<Integer> {

    private final Integer value;

    public RoomNumber(Integer value) {
        if(value < 100){
            throw new IllegalArgumentException("Room number must not be inferior to 100!");
        }
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
        RoomNumber that = (RoomNumber) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
