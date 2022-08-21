package com.sofkaU.voyagerddd.domain.restaurant.events;


import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.voyagerddd.domain.general.Cost;
import com.sofkaU.voyagerddd.domain.restaurant.values.ProductID;

public class ProductCostUpdated extends DomainEvent {

    private final ProductID productID;
    private final Cost productCost;

    public ProductCostUpdated(ProductID productID, Cost productCost) {
        super("restaurant.ProductCostUpdated");
        this.productID = productID;
        this.productCost = productCost;
    }

    public ProductID getProductID() {
        return productID;
    }

    public Cost getProductCost() {
        return productCost;
    }
}
