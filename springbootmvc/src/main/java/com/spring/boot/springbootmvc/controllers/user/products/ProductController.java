package com.spring.boot.springbootmvc.controllers.user.products;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boot.springbootmvc.controllers.user.b2cuser.B2cServices;
import com.spring.boot.springbootmvc.controllers.user.kart.Kart;
import com.spring.boot.springbootmvc.controllers.user.kart.KartRepo;
import com.spring.boot.springbootmvc.controllers.user.kart.KartService;

@RestController
public class ProductController {
    @Autowired
    KartService kartrService;
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/getAllProductsDetails")
    public ModelAndView getAllProductsDetails(HttpSession httpSession) {
        List<ProductEntity> productEntities = new ArrayList<ProductEntity>();
        List<ProductsBeans> productsBeans = new ArrayList<ProductsBeans>();
        ModelAndView modelAndView = new ModelAndView();
        try {
            productEntities = productService.getAllProductDetails();
            modelAndView.addObject("products", productEntities);
            modelAndView.addObject("userId", httpSession.getAttribute("userId"));
            modelAndView.setViewName("product/producthome");
            return modelAndView;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }
    @RequestMapping(value = "/addToKart/{productId}/{userId}/{sellerId}")
    public ModelAndView addToKart(@PathVariable String productId,@PathVariable String userId,@PathVariable String sellerId,HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView();
        List<Kart> kart = new ArrayList<>();
        try {
            kart = kartrService.addToKart(productId,userId,sellerId);
            modelAndView.addObject("kart", kart);           
            modelAndView.setViewName("kart/userkart");
            return modelAndView;
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }
}
