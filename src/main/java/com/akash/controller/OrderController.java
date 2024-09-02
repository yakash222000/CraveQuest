package com.akash.controller;

import com.akash.model.CartItem;
import com.akash.model.Order;
import com.akash.model.User;
import com.akash.request.AddCartItemRequest;
import com.akash.request.OrderRequest;
import com.akash.service.OrderService;
import com.akash.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @PostMapping("/order")
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest req,
                                                @RequestHeader("Authorization") String jwt)
                                                throws Exception{

        User user = userService.findUserByJwtToken(jwt);

        Order order = orderService.createOrder(req,user);

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping("/order/user")
    public ResponseEntity<List<Order>> getOrderHistory(
                                                       @RequestHeader("Authorization") String jwt)
            throws Exception{

        User user = userService.findUserByJwtToken(jwt);

        List<Order> order = orderService.getUserOrder(user.getId());

        return new ResponseEntity<>(order, HttpStatus.OK);
    }



}
