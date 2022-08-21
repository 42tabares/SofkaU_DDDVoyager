package com.sofkaU.voyagerddd.domain.hotel.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.voyagerddd.domain.hotel.values.ServiceID;
import com.sofkaU.voyagerddd.domain.hotel.values.ServiceName;

public class ServiceNameUpdated extends DomainEvent {

    private final ServiceID serviceID;
    private final ServiceName serviceName;

    public ServiceNameUpdated(ServiceID serviceID, ServiceName serviceName) {
        super("hotel.ServiceNameUpdated");
        this.serviceID = serviceID;
        this.serviceName = serviceName;
    }

    public ServiceID getServiceID() {
        return serviceID;
    }

    public ServiceName getServiceName() {
        return serviceName;
    }
}
