package com.sofkaU.voyagerddd.domain.room.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.voyagerddd.domain.general.Cost;
import com.sofkaU.voyagerddd.domain.room.values.HotelID;
import com.sofkaU.voyagerddd.domain.room.values.InvoiceList;
import com.sofkaU.voyagerddd.domain.room.values.RoomID;

public class AddInvoice extends Command {
    private final RoomID roomID;
    private final HotelID invoiceID;
    private final InvoiceList invoiceList;
    private final Cost cost;

    public AddInvoice(RoomID roomID, HotelID invoiceID, InvoiceList invoiceList, Cost cost) {
        this.roomID = roomID;
        this.invoiceID = invoiceID;
        this.invoiceList = invoiceList;
        this.cost = cost;
    }

    public RoomID getRoomID() {
        return roomID;
    }

    public HotelID getInvoiceID() {
        return invoiceID;
    }

    public InvoiceList getInvoiceList() {
        return invoiceList;
    }

    public Cost getCost() {
        return cost;
    }
}
