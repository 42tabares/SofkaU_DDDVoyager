package com.sofkaU.voyagerddd.domain.hotel.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.voyagerddd.domain.general.Cost;
import com.sofkaU.voyagerddd.domain.hotel.values.ServiceID;

public class ServiceCostUpdated extends DomainEvent {

    private final ServiceID serviceID;
    private final Cost cost;

    public ServiceCostUpdated(ServiceID serviceID, Cost cost) {
        super("hotel.ServiceCostUpdated");
        this.serviceID = serviceID;
        this.cost = cost;
    }

    public ServiceID getServiceID() {
        return serviceID;
    }

    public Cost getCost() {
        return cost;
    }
}
