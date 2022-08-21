package com.sofkaU.voyagerddd.domain.hotel.values;

import co.com.sofka.domain.generic.ValueObject;
import com.sofkaU.voyagerddd.domain.restaurant.values.RestaurantID;

import java.util.Objects;
import java.util.Set;

public class Restaurants implements ValueObject<Set<RestaurantID>> {
    private final Set<RestaurantID> value;

    public Restaurants(Set<RestaurantID> value) {
        this.value = value;
    }

    @Override
    public Set<RestaurantID> value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurants that = (Restaurants) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
