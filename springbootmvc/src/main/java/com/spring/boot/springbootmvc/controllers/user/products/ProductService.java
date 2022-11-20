package com.spring.boot.springbootmvc.controllers.user.products;

import java.util.List;

import com.spring.boot.springbootmvc.controllers.user.orderedproduct.Order;

public interface ProductService {

    List<ProductEntity> getAllProductDetails();

    List<Order> buyNow(String productId, String userId, String sellerId);
    
}
