package com.spring.boot.springbootmvc.controllers.user.seller;

import java.sql.Blob;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.springbootmvc.controllers.user.products.ProductEntity;
import com.spring.boot.springbootmvc.controllers.user.products.ProductRepo;
import com.spring.boot.springbootmvc.controllers.user.products.ProductService;
import com.spring.boot.springbootmvc.controllers.user.products.ProductsBeans;

@Service("sellerServices")
public class SellerServiceImpl implements SellerServices {
    @Autowired
    SellerRepository sellerRepository;
    @Autowired
    ProductRepo productRepo;

    @Override
    public String sellerReg(SellerBeans sellerBeans) {
        // TODO Auto-generated method stub
        String msg = "";
        SellerEntity sellerEntity = new SellerEntity();
        try {
            sellerEntity.setUserId(sellerBeans.getUserId());
            sellerEntity.setAge(sellerBeans.getAge());
            sellerEntity.setEmailId(sellerBeans.getEmailId());
            sellerEntity.setGender(sellerBeans.getGender());
            sellerEntity.setPhone(sellerBeans.getPhone());
            sellerEntity.setUserName(sellerBeans.getUserName());
            sellerEntity.setSellerSecurity(sellerBeans.getSellerSecurity());
            sellerEntity.setSellerType(sellerBeans.getSellerType());
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            String strDate = dateFormat.format(date);
            sellerEntity.setCreatedAt(strDate);
            String password = sellerBeans.getUserPass();
            Base64.Encoder encoder = Base64.getMimeEncoder();
            String eStr = encoder.encodeToString(password.getBytes());
            sellerEntity.setUserPass(eStr);
            sellerRepository.saveAndFlush(sellerEntity);
            msg = "Registration Successful !";
            return msg;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String checkUserIdForSeller(String userId) {
        // TODO Auto-generated method stub
        String msg = "";
        SellerEntity sellerEntity = new SellerEntity();
        try {
            try {
                sellerEntity = sellerRepository.checkUserIdForSeller(userId);
                if (sellerEntity.getUserId().equalsIgnoreCase(userId)) {
                    msg = "This user Id is alredy taken.";
                }
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
                return null;
            }

            return msg;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;

        }
    }

    @Override
    public SellerEntity sellerLogin(SellerBeans sellerBeans) {
        // TODO Auto-generated method stub
        SellerEntity sellerEntity = new SellerEntity();
        String msg = "";
        try {
            String password = sellerBeans.getUserPass();
            Base64.Decoder decoder = Base64.getMimeDecoder();
            sellerEntity = sellerRepository.sellerLogin(sellerBeans.getUserId());
            String dStr = new String(decoder.decode(sellerEntity.getUserPass()));
            if (dStr.equals(password)) {
                return sellerEntity;
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
    public String addProductBySeller(ProductsBeans productsBeans, String userId) {
        // TODO Auto-generated method stub
        String msg = "";
        ProductEntity productEntity = new ProductEntity();
        try {
            productEntity.setPrice(productsBeans.getPrice());
            productEntity.setQuantity(productsBeans.getQuantity());
            productEntity.setAvailableData(productsBeans.getQuantity());
            productEntity.setProductName(productsBeans.getProductName());
            productEntity.setProductId(productsBeans.getProductId());
            productEntity.setProductType(productsBeans.getProductType());
            productEntity.setSellerId(userId);
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            String strDate = dateFormat.format(date);
            productEntity.setCreatedAt(strDate);
            productEntity.setIsDeleted(0);
            productEntity.setProductImgId(productsBeans.getProductImgId());
            productRepo.saveAndFlush(productEntity);
            msg = "data saved successfully";
            return msg;
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }

}
