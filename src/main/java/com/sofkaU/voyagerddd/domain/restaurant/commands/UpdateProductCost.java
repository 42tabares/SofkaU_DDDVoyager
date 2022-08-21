package com.sofkaU.voyagerddd.domain.restaurant.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.voyagerddd.domain.general.Cost;
import com.sofkaU.voyagerddd.domain.restaurant.values.ProductID;
import com.sofkaU.voyagerddd.domain.restaurant.values.RestaurantID;

public class UpdateProductCost extends Command {

    private final RestaurantID restaurantID;
    private final ProductID productID;
    private final Cost productCost;

    public UpdateProductCost(RestaurantID restaurantID, ProductID productID, Cost productCost) {
        this.restaurantID = restaurantID;
        this.productID = productID;
        this.productCost = productCost;
    }

    public RestaurantID getRestaurantID() {
        return restaurantID;
    }

    public ProductID getProductID() {
        return productID;
    }

    public Cost getProductCost() {
        return productCost;
    }
}
