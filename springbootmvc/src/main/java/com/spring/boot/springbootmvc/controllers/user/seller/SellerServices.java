package com.spring.boot.springbootmvc.controllers.user.seller;

import com.spring.boot.springbootmvc.controllers.user.products.ProductsBeans;

public interface SellerServices {

    String sellerReg(SellerBeans sellerBeans);

    String checkUserIdForSeller(String userId);

    SellerEntity sellerLogin(SellerBeans sellerBeans);

    String addProductBySeller(ProductsBeans productsBeans, String userId);
    
}
