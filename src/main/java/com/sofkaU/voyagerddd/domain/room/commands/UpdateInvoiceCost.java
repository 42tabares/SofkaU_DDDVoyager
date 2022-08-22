package com.sofkaU.voyagerddd.domain.room.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.voyagerddd.domain.general.Cost;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;
import com.sofkaU.voyagerddd.domain.room.values.RoomID;

public class UpdateInvoiceCost extends Command {

    private final RoomID roomID;
    private final HotelID invoiceID;
    private final Cost cost;

    public UpdateInvoiceCost(RoomID roomID, HotelID invoiceID, Cost cost) {
        this.roomID = roomID;
        this.invoiceID = invoiceID;
        this.cost = cost;
    }

    public RoomID getRoomID() {
        return roomID;
    }

    public HotelID getInvoiceID() {
        return invoiceID;
    }

    public Cost getCost() {
        return cost;
    }
}
