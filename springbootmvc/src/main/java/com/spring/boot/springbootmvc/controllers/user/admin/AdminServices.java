package com.spring.boot.springbootmvc.controllers.user.admin;

import java.util.List;

public interface AdminServices {
 public AdminEntity login(AdminBeans adminBeans);
 public String addAdmin(AdminBeans adminBeans);
public AdminEntity getUserDetails(String string);
public String updateAdmin(AdminBeans adminBeans);
public List<AdminEntity> getAllUser(); 
}
