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

    @Query(value="select u.product_count,v.product_name,v.price,v.product_Id,v.product_type from kart u inner join products_data v on u.user_Id=v.user_Id where u.user_Id=?1",nativeQuery = true)
    List<Object> buyNow(@Param("userId") String userId);

    // List<Kart> addToKart(String userId);

    
}
