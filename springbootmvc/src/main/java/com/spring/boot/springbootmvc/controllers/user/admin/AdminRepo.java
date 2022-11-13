package com.spring.boot.springbootmvc.controllers.user.admin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface AdminRepo extends JpaRepository<AdminEntity,Long>{
@Query("select u from AdminEntity u")
public List<AdminEntity> getAllUser();
}
