package com.spring.boot.springbootmvc.controllers.user.admin;

import org.springframework.stereotype.Service;

public interface AdminServices {
 public AdminEntity login(AdminBeans adminBeans);

public String addAdmin(AdminBeans adminBeans); 
}
