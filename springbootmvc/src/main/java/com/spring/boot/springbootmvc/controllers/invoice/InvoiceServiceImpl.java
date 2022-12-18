package com.spring.boot.springbootmvc.controllers.invoice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.springbootmvc.controllers.user.products.ProductEntity;
import com.spring.boot.springbootmvc.controllers.user.products.ProductRepo;

@Service("invoiceService")
public class InvoiceServiceImpl implements InvoiceService{
    @Autowired
    private InvoiceRepo invoiceRepo;
    @Autowired
    private ProductRepo productRepo;

    @Override
    public Object generateInvoice(String productId, String sellerId, String userId,Integer quntity) {
        // TODO Auto-generated method stub
        Object invoiceObj = new Object();
        ProductEntity productEntity = new ProductEntity();
        InvoiceEntity invoiceEntity = new InvoiceEntity();
        InvoiceEntity invoiceEntity2 = new InvoiceEntity();
        InvoiceEntity invoiceEntity3 = new InvoiceEntity();
        try {
            productEntity = productRepo.getProductDetailsById(productId);
            invoiceEntity.setTotalPrice(productEntity.getPrice() * quntity);
            invoiceEntity.setProductId(productId);
            invoiceEntity.setProductCount(quntity);
            invoiceEntity.setSellerId(sellerId);
            invoiceEntity.setUserId(userId);
            UUID uuid = UUID.randomUUID();
            String uuidAsString = uuid.toString();  
            invoiceEntity.setInvoiceId(uuidAsString);
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-dd-mm hh:mm:ss");
            String strDate = dateFormat.format(date);
            invoiceEntity.setCreatedAt(strDate);
            String invoiceId = "";
            try {        
                invoiceEntity2 = invoiceRepo.getInvoiceIdBy(productId, sellerId, userId);
                 invoiceId = invoiceEntity2.getInvoiceId();
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
           if(invoiceEntity2 != null){

               if(!invoiceEntity2.getUserId().equalsIgnoreCase(userId)
                   && !invoiceEntity2.getSellerId().equalsIgnoreCase(invoiceId)
                   && !invoiceEntity2.getProductId().equalsIgnoreCase(productId)
                   && invoiceEntity2.getProductCount() == quntity
               ){
                   invoiceRepo.saveAndFlush(invoiceEntity);
               }
           }

           try {
            invoiceEntity3 = invoiceRepo.getInvoiceDetails();

           } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
           }
           if(invoiceEntity3 == null){
            invoiceRepo.saveAndFlush(invoiceEntity);
           }
           if (invoiceEntity3 !=null && invoiceEntity2 == null) {
            invoiceRepo.saveAndFlush(invoiceEntity);

           }
            invoiceObj = invoiceRepo.generateInvoice(productId, sellerId, userId);
            return invoiceObj;
        } catch (Exception e) {
            // TODO: handle exception+
            e.printStackTrace();
            return null;
        }
    }
    
}
