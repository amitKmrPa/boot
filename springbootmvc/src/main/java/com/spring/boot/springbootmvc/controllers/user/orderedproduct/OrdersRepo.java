package com.spring.boot.springbootmvc.controllers.user.orderedproduct;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrdersRepo extends JpaRepository<Order , Integer>  {

    @Query(value="select u.quantity,v.product_name,v.price,v.product_Id,v.product_type from product_orders u inner join products_data v on u.product_Id=v.product_Id where u.product_Id=?1",nativeQuery = true)
    List<Object> buyNow(@Param("productId") String productId);
    
}
