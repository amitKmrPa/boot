package com.spring.boot.springbootmvc.controllers.home.homepage;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.spring.boot.springbootmvc.controllers.user.admin.AdminController;
import com.spring.boot.springbootmvc.controllers.user.products.ProductEntity;
import com.spring.boot.springbootmvc.controllers.user.products.ProductService;
import com.spring.boot.springbootmvc.controllers.user.products.ProductsBeans;

@RestController
public class HomeController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView requestMethodName(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        List<ProductEntity> productEntities = new ArrayList<ProductEntity>();
        String userId = (String) httpSession.getAttribute("userId");
        String userName = (String) httpSession.getAttribute("userName");
        String msg = "";
        try {
            productEntities = productService.getAllProductDetails();
            msg = "Home Page";
            if (userId == null && userName == null) {
                modelAndView.addObject("message", msg);
                modelAndView.addObject("err", "Please Login First");
                modelAndView.addObject("products", productEntities);
                modelAndView.setViewName("B2cUser/userhome");
            } else {
                msg = "You Are In!";
                modelAndView.addObject("message", msg);
                modelAndView.addObject("products", productEntities);
                modelAndView.addObject("userName", userName);
                modelAndView.addObject("userId", userId);
                modelAndView.setViewName("B2cUser/userhome");
            }
            return modelAndView;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

}
