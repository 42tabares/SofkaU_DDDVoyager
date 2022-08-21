package com.sofkaU.voyagerddd.domain.hotel.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.voyagerddd.domain.general.Cost;
import com.sofkaU.voyagerddd.domain.hotel.values.ServiceID;
import com.sofkaU.voyagerddd.domain.hotel.values.ServiceName;

public class ServiceAdded extends DomainEvent {

    private final ServiceID serviceID;
    private final ServiceName serviceName;
    private final Cost cost;

    public ServiceAdded(ServiceID serviceID, ServiceName serviceName, Cost cost) {
        super("hotel.ServiceAdded");
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.cost = cost;
    }

    public ServiceID getServiceID() {
        return serviceID;
    }

    public ServiceName getServiceName() {
        return serviceName;
    }

    public Cost getCost() {
        return cost;
    }
}
