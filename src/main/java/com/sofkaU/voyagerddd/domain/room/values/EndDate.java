package com.sofkaU.voyagerddd.domain.room.values;

import co.com.sofka.domain.generic.ValueObject;
import com.sofkaU.voyagerddd.domain.general.Name;

import java.util.Objects;

public class EndDate implements ValueObject<String> {
    private final String value;

    public EndDate(String value) {
        if(value.isBlank()){
            throw new IllegalArgumentException("End Date Must Not be on Blank!");
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
        EndDate that = (EndDate) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
