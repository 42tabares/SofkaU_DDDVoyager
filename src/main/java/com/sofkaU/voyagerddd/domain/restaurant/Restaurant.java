package com.sofkaU.voyagerddd.domain.restaurant;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.voyagerddd.domain.general.Cost;
import com.sofkaU.voyagerddd.domain.general.Name;
import com.sofkaU.voyagerddd.domain.hotel.values.HotelID;
import com.sofkaU.voyagerddd.domain.restaurant.events.ChefAdded;
import com.sofkaU.voyagerddd.domain.restaurant.events.ChefNameUpdated;
import com.sofkaU.voyagerddd.domain.restaurant.events.ChefSpecialtyUpdated;
import com.sofkaU.voyagerddd.domain.restaurant.events.ProductAdded;
import com.sofkaU.voyagerddd.domain.restaurant.events.ProductCostUpdated;
import com.sofkaU.voyagerddd.domain.restaurant.events.ProductNameUpdated;
import com.sofkaU.voyagerddd.domain.restaurant.events.RestaurantCreated;
import com.sofkaU.voyagerddd.domain.restaurant.values.ChefID;
import com.sofkaU.voyagerddd.domain.restaurant.values.ChefSpecialty;
import com.sofkaU.voyagerddd.domain.restaurant.values.ProductID;
import com.sofkaU.voyagerddd.domain.restaurant.values.ProductName;
import com.sofkaU.voyagerddd.domain.restaurant.values.RestaurantID;
import com.sofkaU.voyagerddd.domain.restaurant.values.RestaurantName;
import com.sofkaU.voyagerddd.domain.room.Reservation;
import com.sofkaU.voyagerddd.domain.room.values.ReservationID;


import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Restaurant extends AggregateEvent<RestaurantID> {

    protected HotelID hotelID;
    protected RestaurantName restaurantName;
    protected Set<Chef> chefs;
    protected Set<Product> products;

    public Restaurant(RestaurantID entityId, HotelID hotelID, RestaurantName restaurantName) {
        super(entityId);
        appendChange(new RestaurantCreated(hotelID,restaurantName)).apply();
    }

    private Restaurant(RestaurantID restaurantID){
        super(restaurantID);
        subscribe(new RestaurantChange(this));
    }

    public static Restaurant from(RestaurantID restaurantID, List<DomainEvent> events){
        var restaurant = new Restaurant(restaurantID);
        events.forEach(restaurant::applyEvent);
        return restaurant;
    }

    //Command-Event Implementation
    public void addChef(ChefID entityId, Name name, ChefSpecialty chefSpecialty){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(chefSpecialty);
        appendChange(new ChefAdded(entityId,name,chefSpecialty)).apply();
    }

    public void addProduct(ProductID entityId, ProductName name, Cost cost){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(cost);
        appendChange(new ProductAdded(entityId,name,cost)).apply();
    }

    public void updateChefName(ChefID entityId, Name name){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(name);
        appendChange(new ChefNameUpdated(entityId,name)).apply();
    }

    public void updateChefSpecialty(ChefID entityId,ChefSpecialty chefSpecialty){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(chefSpecialty);
        appendChange(new ChefSpecialtyUpdated(entityId,chefSpecialty)).apply();
    }

    public void updateProductName(ProductID entityId, ProductName name){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(name);
        appendChange(new ProductNameUpdated(entityId,name)).apply();
    }

    public void updateProductCost(ProductID entityId, Cost cost){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(cost);
        appendChange(new ProductCostUpdated(entityId,cost)).apply();
    }

    public Optional<Chef> getChefById(ChefID chefID){
        return chefs.stream().filter((chef -> chef.identity().equals(chefID))).findFirst();
    }
    public Optional<Product> getProductById(ProductID productID){
        return products.stream().filter((reservation -> reservation.identity().equals(productID))).findFirst();
    }

    public RestaurantName getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(RestaurantName restaurantName) {
        this.restaurantName = restaurantName;
    }

    public Set<Chef> chefs() {
        return chefs;
    }

    public Set<Product> products() {
        return products;
    }

}
