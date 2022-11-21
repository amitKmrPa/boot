package com.spring.boot.springbootmvc.controllers.user.orderedproduct;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrdersRepo extends JpaRepository<Order , Integer>  {

    @Query("select u from Order u where  userId=:userId")
    List<Order> buyNow(@Param("userId") String userId);
    
}
