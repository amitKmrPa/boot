package com.spring.boot.springbootmvc.controllers.user.b2cuser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("b2cServices")
public class B2cServicesImpl implements B2cServices {

    @Autowired
    B2cRepo b2cRepo;
    @Override
    public String saveB2cUserDetails(B2cBeans b2cBeans) {
        // TODO Auto-generated method stub
        B2cEntity b2cEntity = new B2cEntity();
        String msg = "";
        try {
            b2cEntity.setAge(b2cBeans.getAge());
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            String strDate = dateFormat.format(date);
            b2cEntity.setCreatedAt(strDate);
            b2cEntity.setEmailId(b2cBeans.getEmailId());
            b2cEntity.setGender(b2cBeans.getGender());
            b2cEntity.setPhone(b2cBeans.getPhone());
            b2cEntity.setUserId(b2cBeans.getUserId());
            b2cEntity.setUserName(b2cBeans.getUserName());
            String password = b2cBeans.getUserPass();
            Base64.Encoder encoder = Base64.getMimeEncoder();  
            String eStr = encoder.encodeToString(password.getBytes()); 
            b2cEntity.setUserPass(eStr);
            b2cRepo.saveAndFlush(b2cEntity);
            msg="Registration Successful !";
            return msg;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            msg = "Registration failed !";
            return msg;
        }
    }
    @Override
    public String checkUserIdForUser(String userId) {
        String msg = "";
        B2cEntity b2cEntity = new B2cEntity();
        try {
            b2cEntity = b2cRepo.checkUserId(userId);
            if (b2cEntity.getUserId().equalsIgnoreCase(userId)) {
                msg = "This user Id is alredy taken.";
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
    public B2cEntity userLogin(B2cBeans b2cBeans) {
        B2cEntity b2cEntity = new B2cEntity();
        try {
             String password = b2cBeans.getUserPass();
             Base64.Decoder decoder = Base64.getMimeDecoder();
             b2cEntity = b2cRepo.getAdminDetails(b2cBeans.getUserId());
             String dStr = new String(decoder.decode(b2cEntity.getUserPass()));  
            if (dStr.equals(password)) {
                return b2cEntity;
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
    public List<B2cEntity> getUserList() {
        // TODO Auto-generated method stub
        List<B2cEntity> b2cEntities = new ArrayList<B2cEntity>();
        try {
            b2cEntities = b2cRepo.getUserList();
            return b2cEntities;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }
    
}
