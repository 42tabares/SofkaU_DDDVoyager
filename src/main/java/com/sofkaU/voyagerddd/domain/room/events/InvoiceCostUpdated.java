package com.sofkaU.voyagerddd.domain.room.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.voyagerddd.domain.general.Cost;
import com.sofkaU.voyagerddd.domain.room.values.HotelID;
import com.sofkaU.voyagerddd.domain.room.values.InvoiceID;

public class InvoiceCostUpdated extends DomainEvent {

    private final InvoiceID invoiceID;
    private final Cost cost;

    public InvoiceCostUpdated(InvoiceID invoiceID, Cost cost) {
        super("room.InvoiceCostUpdated");
        this.invoiceID = invoiceID;
        this.cost = cost;
    }

    public InvoiceID getInvoiceID() {
        return invoiceID;
    }

    public Cost getCost() {
        return cost;
    }
}
