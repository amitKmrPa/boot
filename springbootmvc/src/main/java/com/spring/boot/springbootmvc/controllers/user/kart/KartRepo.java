package com.spring.boot.springbootmvc.controllers.user.kart;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface KartRepo extends JpaRepository<Kart , Long>{
    @Query("select u from Kart u where userId=:userId")
    List<Kart> addToKart(@Param("userId") String userId);

    @Query("select u from Kart u where userId=:userId")
    List<Kart> viewUserKart(@Param("userId")String userId);
    
}
