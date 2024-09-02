package com.akash.repository;

import com.akash.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface FoodRepository extends JpaRepository<Food, Long> {

     List<Food> findByRestaurant_Id(Long restaurantId);

    @Query("SELECT f FROM Food f where f.name LIKE %:keyword% or f.category.name like %:keyword%")
    List<Food> searchFood(@Param("keyword") String keyword);
}
