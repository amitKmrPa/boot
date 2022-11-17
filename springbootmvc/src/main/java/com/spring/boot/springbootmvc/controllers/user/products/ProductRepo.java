package com.spring.boot.springbootmvc.controllers.user.products;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepo extends JpaRepository<ProductEntity, Long> {
    @Query("select u from ProductEntity u")
    List<ProductEntity> getAllProductDetails();

    
}
