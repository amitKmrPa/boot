package com.spring.boot.springbootmvc.controllers.user.kart;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.boot.springbootmvc.controllers.user.products.ProductEntity;
import com.spring.boot.springbootmvc.controllers.user.products.ProductRepo;

@Service("kartService")
public class KartServiceImpl implements KartService {
    @Autowired
    KartRepo kartRepo;
    @Autowired
    ProductRepo productRepo;

    @Override
    public List<Object> addToKart(String productId, String userId, String sellerId) {
        // TODO Auto-generated method stub
        List<Kart> kart = new ArrayList<>();
        Kart kartObj = new Kart();
        Kart kartEntities = new Kart();
        List<Object> listProduct = new ArrayList<>();
        ProductEntity productEntities = new ProductEntity();
        try {
            productEntities = productRepo.findProductById(productId);
            kartEntities = kartRepo.getKartDetailsByProductIdAndUserId(productId, userId);
            int product_count = 1;
            if (kartEntities != null) {
                if (kartEntities.getProductId() != null && kartEntities.getProductId().equalsIgnoreCase(productId)) {
                    product_count = kartEntities.getProductCount();
                    kartEntities.setProductCount(kartEntities.getProductCount()+product_count);
                    Date date = Calendar.getInstance().getTime();
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-dd-mm hh:mm:ss");
                    String strDate = dateFormat.format(date);
                    kartEntities.setLastModifiedAt(strDate);
                    kartEntities = kartRepo.saveAndFlush(kartEntities);
                }
            }else{
                kartObj.setProductCount(product_count);
                kartObj.setProductId(productEntities.getProductId());
                kartObj.setUserId(userId);
                kartObj.setSellerId(sellerId);
                Date date = Calendar.getInstance().getTime();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-dd-mm hh:mm:ss");
                String strDate = dateFormat.format(date);
                kartObj.setCreatedAt(strDate);
                kartEntities = kartRepo.saveAndFlush(kartObj);
            }
            listProduct = kartRepo.addToKart(userId);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return listProduct;
    }

    @Override
    public List<Kart> viewUserKart(String userId) {
        // TODO Auto-generated method stub
        List<Kart> karts = new ArrayList<>();
        try {
            karts = kartRepo.viewUserKart(userId);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return karts;
    }

    @Override
    public String removeFromKart(String productId, String sellerId, String userId) {
        // TODO Auto-generated method stub
        Kart kart = new Kart();
        Kart kartData = new Kart();
        try {
            kart = kartRepo.removeFromKart(productId, sellerId, userId);
            kartData.setIsDeleted(1);
            kartRepo.saveAndFlush(kartData);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }

}
