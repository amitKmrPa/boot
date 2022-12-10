package com.spring.boot.springbootmvc.controllers.invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

import javax.servlet.http.HttpSession;

@RestController
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;
    @RequestMapping("/generateInvoice/{productId}/{sellerId}/{quantity}")
        public ModelAndView generateInvoice(@PathVariable("productId") String productId, @PathVariable("sellerId") String sellerId,@PathVariable("quantity") Integer quntity,HttpSession httpSession) {
            String userId = (String)  httpSession.getAttribute("userId");
            ModelAndView modelAndView = new ModelAndView();
            Object invoiceObj = new Object();
            try {
                invoiceObj = invoiceService.generateInvoice(productId,sellerId,userId,quntity);
                modelAndView.addObject("invoice", invoiceObj);
                modelAndView.setViewName("invoices/invoicesPage");
                return modelAndView;
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
                return null;
            }
        }
    
}
