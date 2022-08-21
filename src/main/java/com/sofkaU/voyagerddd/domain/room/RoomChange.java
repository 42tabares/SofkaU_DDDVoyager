package com.sofkaU.voyagerddd.domain.room;

import co.com.sofka.domain.generic.EventChange;
import com.sofkaU.voyagerddd.domain.room.events.InvoiceAdded;
import com.sofkaU.voyagerddd.domain.room.events.InvoiceCostUpdated;
import com.sofkaU.voyagerddd.domain.room.events.InvoiceListUpdated;
import com.sofkaU.voyagerddd.domain.room.events.ReservationAdded;
import com.sofkaU.voyagerddd.domain.room.events.ReservationEndDateUpdated;
import com.sofkaU.voyagerddd.domain.room.events.ReservationStartDateUpdated;
import com.sofkaU.voyagerddd.domain.room.events.RoomCostUpdated;
import com.sofkaU.voyagerddd.domain.room.events.RoomCreated;
import com.sofkaU.voyagerddd.domain.room.events.RoomNumberUpdated;


import java.util.HashSet;

import static com.sofkaU.voyagerddd.domain.general.Utils.validateDateStrings;

public class RoomChange extends EventChange {

    public RoomChange(Room room){

        apply((RoomCreated event) -> {
           room.roomNumber = event.getRoomNumber();
           room.cost = event.getCost();
           room.invoice = null;
           room.reservations = new HashSet<>();
        });

        apply((InvoiceAdded event) ->{
            room.invoice = new Invoice(
                    event.getInvoiceId(),
                    event.getInvoiceList(),
                    event.getCost()
            );
        });

        apply((ReservationAdded event) ->{

            var start = event.getStartDate().value();
            var end = event.getEndDate().value();

            if(!validateDateStrings(start,end)){
                throw new IllegalArgumentException("Date interval is not valid");
            }

            room.reservations.add(new Reservation(
                    event.getReservationID(),
                    event.getStartDate(),
                    event.getEndDate()
                ));
        });

        apply((InvoiceCostUpdated event) ->{
            var invoice = room.getInvoice();
            if (invoice == null){
                throw new IllegalArgumentException("Invoice does not exist");
            }
            invoice.setCost(event.getCost());
        });

        apply((InvoiceListUpdated event) ->{
            var invoice = room.getInvoice();
            invoice.updateInvoiceList(event.getInvoiceList());
        });

        apply((ReservationEndDateUpdated event) ->{
            var reservation = room.getReservationById(event.getReservationID()).orElseThrow(() -> new IllegalArgumentException("No reservation found with Id"));
            var start = reservation.getStartDate().value();
            var end = event.getEndDate().value();

            if(!validateDateStrings(start,end)){
                throw new IllegalArgumentException("New end date is not valid.");
            }

            reservation.setEndDate(event.getEndDate());
        });

        apply((ReservationStartDateUpdated event) ->{
            var reservation = room.getReservationById(event.getReservationID()).orElseThrow(() -> new IllegalArgumentException("No reservation found with Id"));
            var start = event.getStartDate().value();
            var end = reservation.getEndDate().value();

            if(!validateDateStrings(start,end)){
                throw new IllegalArgumentException("New start date is not valid.");
            }

            reservation.setStartDate(event.getStartDate());
        });

        apply((RoomCostUpdated event) ->{
            room.cost = event.getCost();
        });

        apply((RoomNumberUpdated event) ->{
            if (event.getRoomNumber().value() < 100){
                throw new IllegalArgumentException("invalid Room Number");
            }
            room.roomNumber = event.getRoomNumber();
        });


    }
}
