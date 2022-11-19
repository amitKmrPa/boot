package com.spring.boot.springbootmvc.controllers.user.kart;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
    public List<Kart> addToKart(String productId,String userId,String sellerId) {
        // TODO Auto-generated method stub
        List<Kart> kart = new ArrayList<>();
        Kart kartVal = new Kart();
        Kart kartEntities = new Kart();

        ProductEntity productEntities = new ProductEntity();

        try {
            productEntities = productRepo.findProductById(productId);
            kartEntities.setProductId(productEntities.getProductId());
            kartEntities.setUserId(userId);
            kartEntities.setSellerId(sellerId);
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-dd-mm hh:mm:ss");
            String strDate = dateFormat.format(date);
            kartEntities.setCreatedAt(strDate);
            kartVal = kartRepo.saveAndFlush(kartEntities);
            // TimeUnit.SECONDS.sleep(1);
            kart=kartRepo.addToKart(productId);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return kart;
    }
    
}
