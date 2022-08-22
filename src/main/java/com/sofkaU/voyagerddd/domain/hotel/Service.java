package com.sofkaU.voyagerddd.domain.hotel;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.voyagerddd.domain.general.Cost;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;
import com.sofkaU.voyagerddd.domain.hotel.values.ServiceID;
import com.sofkaU.voyagerddd.domain.hotel.values.ServiceName;

public class Service extends Entity<ServiceID> {

    private ServiceName serviceName;
    private Cost cost;

    public Service(ServiceID entityId, ServiceName serviceName, Cost cost) {
        super(entityId);
        this.serviceName = serviceName;
        this.cost = cost;
    }

    public ServiceName getServiceName() {
        return serviceName;
    }

    public void setServiceName(ServiceName serviceName) {
        this.serviceName = serviceName;
    }

    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }
}
