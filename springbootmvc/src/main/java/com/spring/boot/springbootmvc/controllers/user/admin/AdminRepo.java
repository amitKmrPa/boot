package com.spring.boot.springbootmvc.controllers.user.admin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<AdminEntity, Long> {

    // @Query(value = "select * from admin_table where user_Id =?1", nativeQuery =
    // true)
    @Query("select u from AdminEntity u where userId=:userId")
    AdminEntity getAdminDetails(@Param("userId") String userId);

    @Query("select u from AdminEntity u where userId=:userId")
    AdminEntity getUserDetailsById(@Param("userId") String userId);

    @Query("select u from AdminEntity u where userId=:userId")
    AdminEntity findUser(@Param("userId") String userId);

    @Query("select u from AdminEntity u where isDeleted=0")
    List<AdminEntity> getAllUser();

    @Query("select u from AdminEntity u where userId=:userId")
    AdminEntity geAdminDetailsById(@Param("userId") String userId);

    @Query("select u from AdminEntity u where userId=:userId")
    AdminEntity findUserById(@Param("userId") String userId);

    @Query("select u from AdminEntity u where userId=:userId")
    AdminEntity deleteAdminById(@Param("userId") String userId);

    // @Query("select u from AdminEntity u where userId=:userId")
    // AdminEntity getAdminDetailsToChangePass(@Param("userId") String userId);

    @Query("select u from AdminEntity u where userId=:userId")
    AdminEntity findAdminUserById(@Param("userId") String userId);

    @Query("select u from AdminEntity u where userId=:userId")
    AdminEntity checkUserId(@Param("userId") String userId);


}
