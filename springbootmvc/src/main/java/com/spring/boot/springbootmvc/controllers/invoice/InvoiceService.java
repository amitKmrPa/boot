package com.spring.boot.springbootmvc.controllers.invoice;

import java.util.List;

public interface InvoiceService {

    Object generateInvoice(String productId, String sellerId, String userId,Integer quntity);
    
}
