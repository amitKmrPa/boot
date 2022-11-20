package com.spring.boot.springbootmvc.controllers.user.admin;

import java.util.List;

public interface AdminServices {
 public AdminEntity login(AdminBeans adminBeans);
 public String addAdmin(AdminBeans adminBeans);
public AdminEntity getUserDetails(String string);
public String updateAdmin(AdminBeans adminBeans);
public List<AdminEntity> getAllUser();
public AdminEntity getUserDetailsById(String userId);
public String updateById(String userId, AdminBeans adminBeans);
public String deleteAdminById(String userId);
// public AdminEntity getDetailsToChangePass(String userId);
public String generateNewPassword(AdminBeans adminBeans,String userId);
public String checkUserId(String userId);
public AdminEntity getAdminUserId(String userId); 
}
