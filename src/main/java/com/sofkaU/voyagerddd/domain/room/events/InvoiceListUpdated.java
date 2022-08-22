package com.sofkaU.voyagerddd.domain.room.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.voyagerddd.domain.room.values.InvoiceID;
import com.sofkaU.voyagerddd.domain.room.values.InvoiceList;

public class InvoiceListUpdated extends DomainEvent {

    private final InvoiceID invoiceID;
    private final InvoiceList invoiceList;

    public InvoiceListUpdated(InvoiceID invoiceID, InvoiceList invoiceList) {
        super("room.InvoiceListUpdated");
        this.invoiceID = invoiceID;
        this.invoiceList = invoiceList;
    }

    public InvoiceID getInvoiceID() {
        return invoiceID;
    }

    public InvoiceList getInvoiceList() {
        return invoiceList;
    }
}
