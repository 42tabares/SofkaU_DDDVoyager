package com.sofkaU.voyagerddd.domain.room;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.voyagerddd.domain.general.Cost;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;
import com.sofkaU.voyagerddd.domain.room.events.InvoiceAdded;
import com.sofkaU.voyagerddd.domain.room.events.InvoiceCostUpdated;
import com.sofkaU.voyagerddd.domain.room.events.InvoiceListUpdated;
import com.sofkaU.voyagerddd.domain.room.events.ReservationAdded;
import com.sofkaU.voyagerddd.domain.room.events.ReservationEndDateUpdated;
import com.sofkaU.voyagerddd.domain.room.events.ReservationStartDateUpdated;
import com.sofkaU.voyagerddd.domain.room.events.RoomCostUpdated;
import com.sofkaU.voyagerddd.domain.room.events.RoomCreated;
import com.sofkaU.voyagerddd.domain.room.events.RoomNumberUpdated;
import com.sofkaU.voyagerddd.domain.room.values.EndDate;
import com.sofkaU.voyagerddd.domain.room.values.InvoiceID;
import com.sofkaU.voyagerddd.domain.room.values.InvoiceList;
import com.sofkaU.voyagerddd.domain.room.values.ReservationID;
import com.sofkaU.voyagerddd.domain.room.values.RoomID;
import com.sofkaU.voyagerddd.domain.room.values.RoomNumber;
import com.sofkaU.voyagerddd.domain.room.values.StartDate;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Room extends AggregateEvent<RoomID> {

    protected HotelID hotelID;
    protected RoomNumber roomNumber;
    protected Cost cost;
    protected Invoice invoice;
    protected Set<Reservation> reservations;

    public Room(RoomID entityId, HotelID hotelID, RoomNumber roomNumber, Cost cost) {
        super(entityId);
        this.hotelID = hotelID;
        this.roomNumber = roomNumber;
        this.cost = cost;
    }

    private Room(RoomID roomID){
        super(roomID);
        subscribe(new RoomChange(this));
    }

    public static Room from(RoomID roomID, List<DomainEvent> events){
        var room = new Room(roomID);
        events.forEach(room::applyEvent);
        return room;
    }

    //Command-Event Implementation

    public void addInvoice(InvoiceID entityId, InvoiceList invoiceList,Cost cost){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(cost);
        appendChange(new InvoiceAdded(entityId,invoiceList,cost)).apply();
    }

    public void addReservation(ReservationID entityId, StartDate startDate, EndDate endDate){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(startDate);
        Objects.requireNonNull(endDate);
        appendChange(new ReservationAdded(entityId,startDate,endDate)).apply();
    }

    public void updateInvoiceCost(InvoiceID entityId, Cost cost){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(cost);
        appendChange(new InvoiceCostUpdated(entityId,cost)).apply();
    }

    public void updateInvoiceList(InvoiceID entityId, InvoiceList invoiceList){
        Objects.requireNonNull(entityId);
        appendChange(new InvoiceListUpdated(entityId,invoiceList)).apply();
    }

    public void updateReservationEndDate(ReservationID entityId, EndDate endDate){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(endDate);
        appendChange(new ReservationEndDateUpdated(entityId, endDate)).apply();
    }

    public void updateReservationStartDate(ReservationID entityId, StartDate startDate){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(startDate);
        appendChange(new ReservationStartDateUpdated(entityId, startDate)).apply();
    }

    public void updateRoomCost(RoomID entityId, Cost cost){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(cost);
        appendChange(new RoomCostUpdated(entityId, cost)).apply();
    }

    public void updateRoomNumber(RoomID entityId, RoomNumber roomNumber){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(roomNumber);
        appendChange(new RoomNumberUpdated(entityId, roomNumber)).apply();
    }

    // ID finders

    public Optional<Reservation> getReservationById(ReservationID reservationID){
        return reservations.stream().filter((reservation -> reservation.identity().equals(reservationID))).findFirst();
    }


    //Getters

    public RoomNumber getRoomNumber() {
        return roomNumber;
    }

    public Cost getCost() {
        return cost;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public Set<Reservation> reservations() {
        return reservations;
    }
}
