package com.spring.boot.springbootmvc.controllers.user.products;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.springbootmvc.controllers.user.orderedproduct.Order;

@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepo productRepo;
    @Override
    public List<ProductEntity> getAllProductDetails() {
        // TODO Auto-generated method stub
        List<ProductEntity> productEntities = new ArrayList<ProductEntity>();
        try {
            productEntities = productRepo.getAllProductDetails();
            System.out.println(productEntities.toString());
        } catch (Exception e) {
            // TODO: handle exception
        }
        return productEntities;
    }
    @Override
    public List<Order> buyNow(String productId, String userId, String sellerId) {
        // TODO Auto-generated method stub
        Order orders=new Order();
        ProductEntity productEntities = new ProductEntity();
        try {
            productEntities = productRepo.getProductForUser(productId,sellerId);
            orders.setOrderId(1);
            orders.setProductId(productEntities.getProductId());
            orders.setSellerId(productEntities.getSellerId());
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }
    
}
