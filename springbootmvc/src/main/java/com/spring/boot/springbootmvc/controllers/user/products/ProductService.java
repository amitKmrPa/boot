package com.spring.boot.springbootmvc.controllers.user.products;

import java.util.List;

import com.spring.boot.springbootmvc.controllers.user.orderedproduct.Order;

public interface ProductService {

    List<ProductEntity> getAllProductDetails();

    List<Object> buyNow(String productId, String userId, String sellerId);
    
}
