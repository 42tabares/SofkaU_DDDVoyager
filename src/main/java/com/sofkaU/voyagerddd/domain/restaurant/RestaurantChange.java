package com.sofkaU.voyagerddd.domain.restaurant;

import co.com.sofka.domain.generic.EventChange;
import com.sofkaU.voyagerddd.domain.restaurant.events.ChefAdded;
import com.sofkaU.voyagerddd.domain.restaurant.events.ChefNameUpdated;
import com.sofkaU.voyagerddd.domain.restaurant.events.ChefSpecialtyUpdated;
import com.sofkaU.voyagerddd.domain.restaurant.events.ProductAdded;
import com.sofkaU.voyagerddd.domain.restaurant.events.ProductCostUpdated;
import com.sofkaU.voyagerddd.domain.restaurant.events.ProductNameUpdated;
import com.sofkaU.voyagerddd.domain.restaurant.events.RestaurantCreated;

import java.util.HashSet;

public class RestaurantChange extends EventChange {

    public RestaurantChange(Restaurant restaurant){

        apply((RestaurantCreated event) -> {
            restaurant.restaurantName = event.getRestaurantName();
            restaurant.chefs = new HashSet<>();
            restaurant.products = new HashSet<>();
        });

        apply((ProductAdded event) -> {
            restaurant.products.add(new Product(
                    event.getProductID(),
                    event.getProductName(),
                    event.getCost()
                    ));
        });

        apply((ChefAdded event) -> {
            restaurant.chefs.add(new Chef(
                    event.getChefID(),
                    event.getChefName(),
                    event.getChefSpecialty()
            ));
        });

        apply((ChefNameUpdated event) -> {
            var chef = restaurant.getChefById(event.getChefID()).orElseThrow(() -> new IllegalArgumentException("No chef found with Id"));
            chef.setChefName(event.getChefName());
        });

        apply((ChefSpecialtyUpdated event) -> {
            var chef = restaurant.getChefById(event.getChefID()).orElseThrow(() -> new IllegalArgumentException("No chef found with Id"));
            chef.setChefSpecialty(event.getChefSpecialty());
        });

        apply((ProductCostUpdated event) -> {
            var product = restaurant.getProductById(event.getProductID()).orElseThrow(() -> new IllegalArgumentException("No product found with Id"));
            product.setCost(event.getProductCost());
        });

        apply((ProductNameUpdated event) -> {
            var product = restaurant.getProductById(event.getProductID()).orElseThrow(() -> new IllegalArgumentException("No product found with Id"));
            product.setProductName(event.getProductName());
        });

    }
}
