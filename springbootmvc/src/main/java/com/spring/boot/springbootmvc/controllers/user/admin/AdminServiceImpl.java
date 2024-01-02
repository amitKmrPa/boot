package com.spring.boot.springbootmvc.controllers.user.admin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
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
        AdminEntity admn = new AdminEntity();
        try {
             String password = adminBeans.getUserPass();
             Base64.Decoder decoder = Base64.getMimeDecoder();
             String dStr="";
             if(!adminBeans.getUserId().equalsIgnoreCase("")){
                admn = adminRepo.getAdminDetails(adminBeans.getUserId());
                 dStr = new String(decoder.decode(admn.getUserPass()));  
             }
            if (dStr.equals(password)) {
                return admn;
            } else {
             return null;   
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String addAdmin(AdminBeans adminBeans) {
        // TODO Auto-generated method stub
        AdminEntity adminEntity = new AdminEntity();
        String msg = "";
        try {
            adminEntity.setUserName(adminBeans.getUserName());
            adminEntity.setAge(adminBeans.getAge());
            adminEntity.setAdminType(adminBeans.getAdminType());
            adminEntity.setAdminSecurity(adminBeans.getAdminSecurity());
            adminEntity.setUserId(adminBeans.getUserId());
            String password = adminBeans.getUserPass();
            Base64.Encoder encoder = Base64.getMimeEncoder();  
            String eStr = encoder.encodeToString(password.getBytes());     
            adminEntity.setUserPass(eStr);
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            String strDate = dateFormat.format(date);
            adminEntity.setCreatedAt(strDate);
            adminEntity.setEmailId(adminBeans.getEmailId());
            adminEntity.setPhone(adminBeans.getPhone());
            adminRepo.saveAndFlush(adminEntity);
            msg = "Details saved successfuly !";
            return msg;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            msg = " Sorry! Details do not saved.";
            return msg;
        }
    }

    @Override
    public AdminEntity getUserDetails(String userId) {
        // TODO Auto-generated method stub
        return adminRepo.getUserDetailsById(userId);
    }

    @Override
    public String updateAdmin(AdminBeans adminBeans) {
        AdminEntity adminEntity = new AdminEntity();
        String msg = "";
        try {
            adminEntity  =  adminRepo.findUser(adminBeans.getUserId());
            adminEntity.setUserName(adminBeans.getUserName());
            adminEntity.setAge(adminBeans.getAge());
            if (adminBeans.getAdminType().equalsIgnoreCase("super")) {
                adminEntity.setAdminType(adminBeans.getAdminType());
                adminEntity.setUpdateBy("super");
            }else{
                adminEntity.setUpdateBy("sub admin");

            }
            adminEntity.setAdminSecurity(adminBeans.getAdminSecurity());
            String password = adminBeans.getUserPass();
            Base64.Encoder encoder = Base64.getMimeEncoder();  
            String eStr = encoder.encodeToString(password.getBytes());   // Returns number of bytes written  
            adminEntity.setUserPass(eStr);
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            String strDate = dateFormat.format(date);
            adminEntity.setLastModifiedAt(strDate);
            adminEntity.setEmailId(adminBeans.getEmailId());
            adminEntity.setPhone(adminBeans.getPhone());
            adminRepo.saveAndFlush(adminEntity);
            msg = "Details updated successfuly !";
            return msg;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            msg = " Sorry! Details can't be updated.";
            return msg;
        }
    }

    @Override
    public List<AdminEntity> getAllUser() {
        // TODO Auto-generated method stub
        List<AdminEntity> adminEntity = new ArrayList<AdminEntity>();
        try {
            adminEntity = adminRepo.getAllUser();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return adminEntity;
    }

    @Override
    public AdminEntity getUserDetailsById(String userId) {
        AdminEntity adminEntity = new AdminEntity();
        try {
            adminEntity = adminRepo.geAdminDetailsById(userId);
            return adminEntity;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String updateById(String userId,AdminBeans adminBeans) {
        AdminEntity adminEntity = new AdminEntity();
        String msg = "";
        try {
            adminEntity  =  adminRepo.findUserById(userId);
            adminEntity.setUserName(adminBeans.getUserName());
            adminEntity.setAge(adminBeans.getAge());
            if (adminBeans.getAdminType().equalsIgnoreCase("super")) {
                adminEntity.setAdminType(adminBeans.getAdminType());
                msg = "you are not authorise to update Admin Type.";
                return msg;
            }
            adminEntity.setAdminSecurity(adminBeans.getAdminSecurity());
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            String strDate = dateFormat.format(date);
            adminEntity.setLastModifiedAt(strDate);
            adminEntity.setEmailId(adminBeans.getEmailId());
            adminEntity.setPhone(adminBeans.getPhone());
            adminRepo.saveAndFlush(adminEntity);
            msg = "Details updated successfuly !";
            return msg;
        } catch (Exception e) {
            // TODO: handle exception
            msg = " Sorry! Details can't be updated.";
            return msg;
        }
    }

    @Override
    public String deleteAdminById(String userId) {
        // TODO Auto-generated method stub
        AdminEntity adminEntity = new AdminEntity();
        String message = "";
        try {
            adminEntity = adminRepo.deleteAdminById(userId);
            adminEntity.setIsDeleted(1);
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            String strDate = dateFormat.format(date);
            adminEntity.setDeletedAt(strDate);
            message = "Admin Deleted Successfully !";
            return message;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            message = "Admin Deletetion Failed !";
            return message;        }
    }

    // @Override
    // public AdminEntity getDetailsToChangePass(String userId) {
    //     AdminEntity adminEntity = new AdminEntity();
    //     try {
    //         adminEntity = adminRepo.getAdminDetailsToChangePass(userId);
    //         return adminEntity;
    //     } catch (Exception e) {
    //         // TODO: handle exception
    //         e.printStackTrace();
    //         return null;
    //     }
    //     // TODO Auto-generated method stub
    // }

    @Override
    public String generateNewPassword(AdminBeans adminBeans,String userId) {
        // TODO Auto-generated method stub
        AdminEntity adminEntity = new AdminEntity();
        String msg = "";
        try {
            adminEntity =  adminRepo.findAdminUserById(userId);
            if (adminEntity.getUserId().equalsIgnoreCase(userId)) {
                String password = adminBeans.getUserPass();
                Base64.Encoder encoder = Base64.getMimeEncoder();  
                String eStr = encoder.encodeToString(password.getBytes());    
                adminEntity.setUserPass(eStr);
                adminRepo.saveAndFlush(adminEntity);
                msg = "New password generated.";
            }
            return msg;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            msg = "New Password generation failed.";
            return msg;

        }
    }

    @Override
    public String checkUserId(String userId) {
        // TODO Auto-generated method stub
        String msg = "";
        AdminEntity adminEntity = new AdminEntity();
        try {
            if (adminEntity.getUserId()!=null) {
                
            
                adminEntity = adminRepo.checkUserId(userId);
            if ( adminEntity.getUserId().equalsIgnoreCase(userId)) {
                msg = "This user Id is alredy taken.";
            }
        }
            return msg;

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            msg = "User Id is available.";
            return msg;

        }
    }

    @Override
    public AdminEntity getAdminUserId(String userId) {
        // TODO Auto-generated method stub
        AdminEntity adminEntity = new AdminEntity();
        try {
            adminEntity = adminRepo.getAdminUserId(userId);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return adminEntity;
    }

    

   
}
