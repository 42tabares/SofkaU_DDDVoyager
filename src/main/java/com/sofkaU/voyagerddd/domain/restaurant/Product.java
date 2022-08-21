package com.sofkaU.voyagerddd.domain.restaurant;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.voyagerddd.domain.restaurant.values.ProductID;
import com.sofkaU.voyagerddd.domain.restaurant.values.ProductName;
import com.sofkaU.voyagerddd.domain.general.Cost;
import com.sofkaU.voyagerddd.domain.restaurant.values.RestaurantID;


public class Product extends Entity<ProductID> {

    private RestaurantID restaurantID;
    private ProductName productName;
    private Cost cost;

    public Product(ProductID entityId, RestaurantID restaurantID, ProductName productName, Cost cost) {
        super(entityId);
        this.restaurantID = restaurantID;
        this.productName = productName;
        this.cost = cost;
    }

    public RestaurantID getRestaurantID() {
        return restaurantID;
    }

    public ProductName getProductName() {
        return productName;
    }

    public Cost getCost() {
        return cost;
    }

    public void setRestaurantID(RestaurantID restaurantID) {
        this.restaurantID = restaurantID;
    }

    public void setProductName(ProductName productName) {
        this.productName = productName;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }
}
