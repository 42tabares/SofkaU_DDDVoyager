package com.sofkaU.voyagerddd.domain.room.values;

import co.com.sofka.domain.generic.ValueObject;
import java.util.List;
import java.util.Objects;

public class InvoiceList implements ValueObject<List<String>> {

    private final List<String> value;

    public InvoiceList(List<String> value) {
        this.value = value;
    }

    @Override
    public List<String> value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceList that = (InvoiceList) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
