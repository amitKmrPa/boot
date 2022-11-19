package com.spring.boot.springbootmvc.controllers.user.kart;

import java.util.List;

public interface KartService {

    List<Kart> addToKart(String productId,String userId,String sellerId);
    
}
