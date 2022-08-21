package com.sofkaU.voyagerddd.domain.hotel.values;

import co.com.sofka.domain.generic.ValueObject;
import com.sofkaU.voyagerddd.domain.room.values.RoomID;

import java.util.Objects;
import java.util.Set;

public class Rooms implements ValueObject<Set<RoomID>> {
    private final Set<RoomID> value;

    public Rooms(Set<RoomID> value) {
        this.value = value;
    }

    @Override
    public Set<RoomID> value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rooms that = (Rooms) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
