package com.akash.request;

import java.util.List;

import com.akash.model.Category;
import com.akash.model.IngredientsItem;

import lombok.Data;

@Data
public class CreateFoodRequest {
    private String foodName;
    private String foodDescription;
    private Long foodPrice;
    private List<String> foodImage;
    private Category category;
    private Long restaurantId;
    private boolean isVegetarian;
    private boolean isSeasonal;
    private List<IngredientsItem> ingredients;
}
