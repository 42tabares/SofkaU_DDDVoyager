package com.sofkaU.voyagerddd.domain.room.values;

import co.com.sofka.domain.generic.Identity;

public class InvoiceID extends Identity {
    public InvoiceID() {}
    private InvoiceID(String id){
        super(id);
    }
    public static InvoiceID of(String id) {
        return new InvoiceID(id);
    }
}
