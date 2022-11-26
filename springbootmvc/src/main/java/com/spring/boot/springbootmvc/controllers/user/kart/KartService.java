package com.spring.boot.springbootmvc.controllers.user.kart;

import java.util.List;

import com.spring.boot.springbootmvc.controllers.user.products.ProductEntity;

public interface KartService {

    List<Object> addToKart(String productId,String userId,String sellerId);

    List<Kart> viewUserKart(String userId);

    String removeFromKart(String productId, String sellerId, String userId);
    
}
