package com.akash.service;

import com.akash.model.Category;
import com.akash.model.Restaurant;
import com.akash.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(String name, Long userId) throws Exception {
        Restaurant restaurant =restaurantService.getRestaurantByUserId(userId);

        Category category = new Category();
        category.setName(name);
        category.setRestaurant(restaurant);

        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findCategoryByRestaurantId(Long restaurantId) throws Exception {
        Restaurant restaurant =restaurantService.getRestaurantByUserId(restaurantId);
        return categoryRepository.findByRestaurant_Id(restaurant.getId());
    }

    @Override
    public Category findCategoryById(Long categoryId) throws Exception {
        Optional<Category> category = categoryRepository.findById(categoryId);

        if(category.isEmpty()){
            throw new Exception("Category not found");
        }
        return category.get();
    }
}
