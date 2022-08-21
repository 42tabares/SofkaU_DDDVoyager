package com.sofkaU.voyagerddd.domain.restaurant.events;


import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.voyagerddd.domain.restaurant.values.ProductID;
import com.sofkaU.voyagerddd.domain.restaurant.values.ProductName;

public class ProductNameUpdated extends DomainEvent {

    private final ProductID productID;
    private final ProductName productName;

    public ProductNameUpdated(ProductID productID, ProductName productName) {
        super("restaurant.ProductNameUpdated");
        this.productID = productID;
        this.productName = productName;
    }

    public ProductID getProductID() {
        return productID;
    }

    public ProductName getProductName() {
        return productName;
    }
}
