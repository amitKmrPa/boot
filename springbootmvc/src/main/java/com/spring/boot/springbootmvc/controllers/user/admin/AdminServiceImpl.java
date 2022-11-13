package com.spring.boot.springbootmvc.controllers.user.admin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
            return adminRepo.getAdminDetails(adminBeans.getUserId());
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String addAdmin(AdminBeans adminBeans) {
        // TODO Auto-generated method stub
        AdminEntity adminEntity=new AdminEntity();
        String msg = "";
        try {
            adminEntity.setUserName(adminBeans.getUserName());
            adminEntity.setAge(adminBeans.getAge());
            adminEntity.setAdminType(adminBeans.getAdminType());
            adminEntity.setAdminSecurity(adminBeans.getAdminSecurity());
            adminEntity.setUserId(adminBeans.getUserId());
            adminEntity.setUserPass(adminBeans.getUserPass());
            Date date = Calendar.getInstance().getTime();  
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
            String strDate = dateFormat.format(date);  
            adminBeans.setCreatedAt(strDate);
            adminRepo.saveAndFlush(adminEntity);
            msg = "Details saved successfuly !";
            return msg;
        } catch (Exception e) {
            // TODO: handle exception
            msg = " Sorry! Details do not saved.";
            return msg;
        }        
    }    
}
