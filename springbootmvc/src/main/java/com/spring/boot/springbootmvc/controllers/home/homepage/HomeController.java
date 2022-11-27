package com.spring.boot.springbootmvc.controllers.home.homepage;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boot.springbootmvc.controllers.user.products.ProductEntity;
import com.spring.boot.springbootmvc.controllers.user.products.ProductService;


@RestController
public class HomeController {
    @Autowired
    ProductService productService;
    @RequestMapping(value="/", method=RequestMethod.GET)
    public ModelAndView requestMethodName(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        List<ProductEntity> productEntities = new ArrayList<ProductEntity>();
        String userId = (String) httpSession.getAttribute("userId");
        String userName = (String) httpSession.getAttribute("userName");
        String msg = "";
        try {
            productEntities = productService.getAllProductDetails();
            if (userId==null && userName==null) {
                msg = "Login First To Order or to add in kart";
                modelAndView.addObject("message", msg);
                modelAndView.addObject("products", productEntities);
                modelAndView.setViewName("B2cUser/userhome");
            }else{
                msg = "You Are In!";
                modelAndView.addObject("message", msg);
                modelAndView.addObject("products", productEntities);
                modelAndView.addObject("userName", userName);
                modelAndView.addObject("userId", userId);
                modelAndView.setViewName("B2cUser/userhome");
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return modelAndView;
    }
    
}
