package com.spring.boot.springbootmvc.controllers.user.admin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface AdminRepo extends JpaRepository<AdminEntity,Long>{

//@Query(value = "select * from admin_table  where user_Id =?1", nativeQuery = true)
@Query("select u from AdminEntity u where userId=:userId")
AdminEntity getAdminDetails(@Param("userId") String userId);
}
