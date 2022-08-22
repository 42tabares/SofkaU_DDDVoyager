package com.sofkaU.voyagerddd.domain.room.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.voyagerddd.domain.general.Cost;
import com.sofkaU.voyagerddd.domain.room.values.InvoiceID;
import com.sofkaU.voyagerddd.domain.room.values.InvoiceList;

public class InvoiceAdded extends DomainEvent {

    private final InvoiceID invoiceID;
    private final InvoiceList invoiceList;
    private final Cost cost;

    public InvoiceAdded(InvoiceID invoiceID, InvoiceList invoiceList, Cost cost) {
        super("room.InvoiceAdded");
        this.invoiceID = invoiceID;
        this.invoiceList = invoiceList;
        this.cost = cost;
    }

    public InvoiceID getInvoiceId() {
        return invoiceID;
    }

    public InvoiceList getInvoiceList() {
        return invoiceList;
    }

    public Cost getCost() {
        return cost;
    }
}
