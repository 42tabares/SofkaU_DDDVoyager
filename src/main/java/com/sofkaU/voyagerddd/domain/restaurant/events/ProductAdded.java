package com.sofkaU.voyagerddd.domain.restaurant.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.voyagerddd.domain.general.Cost;
import com.sofkaU.voyagerddd.domain.restaurant.values.ProductID;
import com.sofkaU.voyagerddd.domain.restaurant.values.ProductName;

public class ProductAdded extends DomainEvent {
    private final ProductID productID;
    private final ProductName productName;
    private final Cost cost;

    public ProductAdded(ProductID productID, ProductName productName, Cost cost) {
        super("restaurant.ProductAdded");
        this.productID = productID;
        this.productName = productName;
        this.cost = cost;
    }

    public ProductID getProductID() {
        return productID;
    }

    public ProductName getProductName() {
        return productName;
    }

    public Cost getCost() {
        return cost;
    }
}
