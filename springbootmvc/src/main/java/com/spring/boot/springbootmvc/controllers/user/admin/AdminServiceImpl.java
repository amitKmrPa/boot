package com.spring.boot.springbootmvc.controllers.user.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adminServices")
public class AdminServiceImpl implements AdminServices {

    @Autowired
    AdminRepo adminRepo;

    @Override
    public AdminBeans login(AdminBeans adminBeans) {
        // TODO Auto-generated method stub
    String data =null;
        try {
            List<AdminEntity> alluser = adminRepo.getAllUser();
            alluser.forEach(e->{System.out.println(e.toString());});
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }
    
}
