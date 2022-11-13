package com.spring.boot.springbootmvc.controllers.user.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adminServices")
public class AdminServiceImpl implements AdminServices {

    @Autowired
    AdminRepo adminRepo;

    @Override
    public AdminEntity login(AdminBeans adminBeans) {
        // TODO Auto-generated method stub
        AdminBeans admn=null;
    String data =null;
        try {
            // AdminEntity adminEntity = adminRepo.getAdminDetails(adminBeans.getUserId());
            // System.out.println(adminEntity.toString());
            return adminRepo.getAdminDetails(adminBeans.getUserId());
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;

        }
    }
    
}
