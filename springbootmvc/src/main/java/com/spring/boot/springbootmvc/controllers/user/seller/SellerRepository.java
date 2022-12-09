package com.spring.boot.springbootmvc.controllers.user.seller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<SellerEntity,Integer> {

    @Query("select u from SellerEntity u where userId=:userId")
    SellerEntity checkUserIdForSeller(@Param("userId") String userId);
    
    @Query("select u from SellerEntity u where userId=:userId")
    SellerEntity sellerLogin(@Param("userId") String userId);
    
}
