package com.spring.boot.springbootmvc.controllers.user.b2cuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface B2cRepo extends JpaRepository<B2cEntity, Long> {

    @Query("select u from B2cEntity u where userId=:userId")
    B2cEntity checkUserId(@Param("userId") String userId);

    @Query("select u from B2cEntity u where userId=:userId")
    B2cEntity getAdminDetails(@Param("userId") String userId);

    // String checkUserId(String userId);
    
}
