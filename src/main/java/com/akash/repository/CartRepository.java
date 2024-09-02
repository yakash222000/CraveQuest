package com.akash.repository;

import com.akash.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

    public Cart findByUser_Id(Long userId);

}
