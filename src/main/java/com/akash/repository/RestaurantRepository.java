package com.akash.repository;

import com.akash.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Query("SELECT r FROM Restaurant WHERE LOWER(r.name) LIKE LOWER(CONCAT('%',:query,'%') ) OR LOWER(r.cuisineType) " +
            "LIKE LOWER(CONCAT('%',:query,'%'))")
    List<Restaurant> findBySearchQuery(String query);

    public Restaurant findByOwnerId(Long userId);

}
