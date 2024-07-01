package com.akash.service;

import com.akash.model.Category;
import com.akash.model.Food;
import com.akash.model.Restaurant;
import com.akash.request.CreateFoodRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FoodService {

    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant);

    public void deleteFood(Long foodId) throws Exception;

    public List<Food> getRestaurantsFood(Long restaurantId,boolean isVegetarian,boolean isNonVeg,
                                 boolean isSeasonal,String foodCategory);

    public List<Food> searchFood(String keyword) throws Exception;

    public Food findFoodById(Long id) throws Exception;

    public Food updateAvailabilityStatus(Long foodId) throws Exception;
}
