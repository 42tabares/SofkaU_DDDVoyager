package com.sofkaU.voyagerddd.domain.room;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.voyagerddd.domain.general.Cost;
import com.sofkaU.voyagerddd.domain.room.values.InvoiceID;
import com.sofkaU.voyagerddd.domain.room.values.InvoiceList;

public class Invoice extends Entity<InvoiceID> {

    private InvoiceID invoiceID;
    private InvoiceList invoiceList;
    private Cost cost;

    public Invoice(InvoiceID entityId, InvoiceList invoiceList, Cost cost) {
        super(entityId);
        this.invoiceID = entityId;
        this.invoiceList = invoiceList;
        this.cost = cost;
    }


    public InvoiceList getInvoiceList() {
        return invoiceList;
    }

    public void updateInvoiceList(InvoiceList invoiceList) {
        this.invoiceList = invoiceList;
    }

    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }
}
