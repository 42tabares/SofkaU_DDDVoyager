package com.sofkaU.voyagerddd.domain.room.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;
import com.sofkaU.voyagerddd.domain.room.values.InvoiceList;
import com.sofkaU.voyagerddd.domain.room.values.RoomID;

public class UpdateInvoiceList extends Command {

    private final RoomID roomID;
    private final HotelID invoiceID;
    private final InvoiceList invoiceList;

    public UpdateInvoiceList(RoomID roomID, HotelID invoiceID, InvoiceList invoiceList) {
        this.roomID = roomID;
        this.invoiceID = invoiceID;
        this.invoiceList = invoiceList;
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
}
