package com.akash.controller;

import com.akash.model.Food;
import com.akash.model.Restaurant;
import com.akash.model.User;
import com.akash.request.CreateFoodRequest;
import com.akash.service.FoodService;
import com.akash.service.RestaurantService;
import com.akash.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/search")
    public ResponseEntity<List<Food>> searchFood(@RequestParam String name,
                                           @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        List<Food> food = foodService.searchFood(name);

        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Food>> getRestaurantFood(@RequestParam boolean vegetarian,
                                    @RequestParam boolean seasonal,
                                    @RequestParam boolean nonveg,
                                    @PathVariable Long restaurantId,
                                    @RequestParam(required = false) String food_caategory,
                                    @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        List<Food> food = foodService.getRestaurantsFood(restaurantId,vegetarian,nonveg,seasonal,food_caategory);

        return new ResponseEntity<>(food, HttpStatus.OK);
    }

}
