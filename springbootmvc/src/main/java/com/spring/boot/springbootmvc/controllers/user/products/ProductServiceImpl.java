package com.spring.boot.springbootmvc.controllers.user.products;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
            e.printStackTrace();
        }
        return productEntities;
    }
    @Override
    public List<Object> buyNow(String productId, String userId, String sellerId) {
        // TODO Auto-generated method stub
        Order orders=new Order();
        List<Object> listOrder = new ArrayList<>();
        ProductEntity productEntities = new ProductEntity();
        try {
            productEntities = productRepo.getProductForUser(productId,sellerId);
            UUID uuid = UUID.randomUUID();
            String uuidAsString = uuid.toString();    
            System.out.println("Your UUID is: " + uuidAsString);
            orders.setOrderId(uuidAsString);
            orders.setProductId(productEntities.getProductId());
            orders.setSellerId(productEntities.getSellerId());
            orders.setUserId(userId);
            ordersRepo.saveAndFlush(orders);
            listOrder = ordersRepo.buyNow(uuidAsString);
            System.out.println(listOrder);
            return listOrder;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<ProductEntity> getAllProductDetailsBySellerId(String userId) {
        // TODO Auto-generated method stub
        List<ProductEntity> productEntities = new ArrayList<ProductEntity>();
        try {
            productEntities = productRepo.getAllProductDetailsBySellerId(userId);
            return productEntities;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }
    
}
