package com.spring.boot.springbootmvc.controllers.user.b2cuser;

import java.util.List;

public interface B2cServices {

    String saveB2cUserDetails(B2cBeans b2cBeans);

    String checkUserIdForUser(String userId);

    B2cEntity userLogin(B2cBeans b2cBeans);

    List<B2cEntity> getUserList();
    
}
