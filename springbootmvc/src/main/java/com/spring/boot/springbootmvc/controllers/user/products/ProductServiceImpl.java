package com.spring.boot.springbootmvc.controllers.user.products;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.standard.expression.OrExpression;

import com.spring.boot.springbootmvc.controllers.user.orderedproduct.Order;
import com.spring.boot.springbootmvc.controllers.user.orderedproduct.OrdersRepo;

@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    OrdersRepo ordersRepo;
    @Override
    public List<ProductEntity> getAllProductDetails() {
        // TODO Auto-generated method stub
        List<ProductEntity> productEntities = new ArrayList<ProductEntity>();
        try {
            productEntities = productRepo.getAllProductDetails();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return productEntities;
    }
    @Override
    public List<Order> buyNow(String productId, String userId, String sellerId) {
        // TODO Auto-generated method stub
        Order orders=new Order();
        List<Order> listOrder = new ArrayList<>();
        ProductEntity productEntities = new ProductEntity();
        try {
            productEntities = productRepo.getProductForUser(productId,sellerId);
            orders.setOrderId("1");
            orders.setProductId(productEntities.getProductId());
            orders.setSellerId(productEntities.getSellerId());
            orders.setUserId(userId);
            ordersRepo.saveAndFlush(orders);
            listOrder = ordersRepo.buyNow(userId);
            return listOrder;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }
    
}
