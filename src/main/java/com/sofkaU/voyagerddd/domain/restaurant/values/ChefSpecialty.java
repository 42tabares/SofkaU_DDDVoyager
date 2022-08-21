package com.sofkaU.voyagerddd.domain.restaurant.values;

import co.com.sofka.domain.generic.ValueObject;
import com.sofkaU.voyagerddd.domain.general.Name;

import java.util.Objects;

public class ChefSpecialty implements ValueObject<String> {

    private final String value;

    public ChefSpecialty(String value){
        for (ChefSpecialties chefSpecialty : ChefSpecialties.values()){
            if (chefSpecialty.name().equals(value)) {
                this.value = value;
                break;
            }
        }
        throw new IllegalArgumentException("Chef Specialty does not exist, consider adding it!");
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChefSpecialty that = (ChefSpecialty) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
