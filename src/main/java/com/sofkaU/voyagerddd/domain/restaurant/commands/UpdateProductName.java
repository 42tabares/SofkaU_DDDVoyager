package com.sofkaU.voyagerddd.domain.restaurant.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.voyagerddd.domain.restaurant.values.ProductID;
import com.sofkaU.voyagerddd.domain.restaurant.values.ProductName;
import com.sofkaU.voyagerddd.domain.restaurant.values.RestaurantID;

public class UpdateProductName extends Command {
    private final RestaurantID restaurantID;
    private final ProductID productID;
    private final ProductName productName;

    public UpdateProductName(RestaurantID restaurantID, ProductID productID, ProductName productName) {
        this.restaurantID = restaurantID;
        this.productID = productID;
        this.productName = productName;
    }

    public RestaurantID getRestaurantID() {
        return restaurantID;
    }

    public ProductID getProductID() {
        return productID;
    }

    public ProductName getProductName() {
        return productName;
    }
}
