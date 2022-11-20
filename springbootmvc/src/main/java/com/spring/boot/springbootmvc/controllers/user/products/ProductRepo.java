package com.spring.boot.springbootmvc.controllers.user.products;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepo extends JpaRepository<ProductEntity, Long> {
    @Query("select u from ProductEntity u")
    List<ProductEntity> getAllProductDetails();

    @Query("select u from ProductEntity u where productId=:productId")
    ProductEntity findProductById(@Param("productId") String productId);

    @Query("select u from ProductEntity u where productId=:productId and sellerId=:sellerId")
    ProductEntity getProductForUser(@Param("productId") String productId,@Param("sellerId") String sellerId);

    
}
