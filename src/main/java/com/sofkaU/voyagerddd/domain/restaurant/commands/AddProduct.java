package com.sofkaU.voyagerddd.domain.restaurant.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.voyagerddd.domain.general.Cost;
import com.sofkaU.voyagerddd.domain.restaurant.values.ProductID;
import com.sofkaU.voyagerddd.domain.restaurant.values.ProductName;
import com.sofkaU.voyagerddd.domain.restaurant.values.RestaurantID;

public class AddProduct extends Command {

    private final RestaurantID restaurantID;
    private final ProductID productID;
    private final ProductName productName;
    private final Cost cost;

    public AddProduct(RestaurantID restaurantID, ProductID productID, ProductName prductName, Cost cost) {
        this.restaurantID = restaurantID;
        this.productID = productID;
        this.productName = prductName;
        this.cost = cost;
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

    public Cost getCost() {
        return cost;
    }
}
