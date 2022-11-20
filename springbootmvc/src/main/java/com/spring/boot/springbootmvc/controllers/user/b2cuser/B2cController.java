package com.spring.boot.springbootmvc.controllers.user.b2cuser;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boot.springbootmvc.controllers.user.orderedproduct.Order;
import com.spring.boot.springbootmvc.controllers.user.products.ProductEntity;
import com.spring.boot.springbootmvc.controllers.user.products.ProductService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class B2cController {
    @Autowired
    B2cServices b2cServices;
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/userRegistration", method = RequestMethod.GET)
    public ModelAndView userRegistration() {
        ModelAndView modelAndView = new ModelAndView();
        try {
            modelAndView.setViewName("B2cUser/UserRegPage");
            return modelAndView;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/userLoginPage", method = RequestMethod.GET)
    public ModelAndView userLoginPage(
            HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        ModelAndView modelAndView = new ModelAndView();
        String userId;
        String userName;
        try {
            userId = (String) session.getAttribute("userId");
            userName = (String) session.getAttribute("userName");
            if (userId != null && userName != null) {
                modelAndView.addObject("userName", userName);
                modelAndView.addObject("userId", userId);
                modelAndView.setViewName("B2cUser/B2cUserLogin");
                return modelAndView;
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        try {
            modelAndView.setViewName("B2cUser/B2cUserLogin");
            return modelAndView;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView requestMethodName(@ModelAttribute("registerAtr") B2cBeans b2cBeans) {
        ModelAndView modelAndView = new ModelAndView();
        String msg = "";
        try {
            msg = b2cServices.saveB2cUserDetails(b2cBeans);
            modelAndView.addObject("message", msg);
            modelAndView.setViewName("messages/success");
            return modelAndView;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            modelAndView.addObject("message", msg);
            modelAndView.setViewName("messages/failed");
            return modelAndView;

        }
    }

    @RequestMapping(value = "/checkUserIdForUser/{userId}", method = RequestMethod.POST)
    public String checkUserIdForUser(@PathVariable String userId) {
        String msg = "";
        try {
            msg = b2cServices.checkUserIdForUser(userId);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return msg;
    }

    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public ModelAndView userLogin(@ModelAttribute("userLoginAtr") B2cBeans b2cBeans,
            HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        ModelAndView modelAndView = new ModelAndView();
        List<ProductEntity> productEntities = new ArrayList<ProductEntity>();

        B2cEntity b2cEntity = null;
        try {
            b2cEntity = b2cServices.userLogin(b2cBeans);
            if (b2cEntity != null && b2cBeans.getUserId().equalsIgnoreCase(b2cEntity.getUserId())) {
                productEntities = productService.getAllProductDetails();
                modelAndView.addObject("adminData", b2cEntity.getUserId());
                modelAndView.addObject("message", "You are in!");
                session.setAttribute("userId", b2cEntity.getUserId());
                session.setAttribute("userName", b2cEntity.getUserName());
                String userId = (String) session.getAttribute("userId");
                String userName = (String) session.getAttribute("userName");
                modelAndView.addObject("userName", userName);
                modelAndView.addObject("userId", userId);
                modelAndView.addObject("products", productEntities);
                modelAndView.addObject("userId", session.getAttribute("userId"));
                modelAndView.setViewName("B2cUser/userhome");
                return modelAndView;
            } else {
                modelAndView.setViewName("B2cUser/B2cUserLogin");
                return modelAndView;
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            modelAndView.setViewName("B2cUser/B2cUserLogin");
            return modelAndView;
        }
    }
    @RequestMapping(value="/buyNow/{productId}/{userId}/{sellerId}", method=RequestMethod.GET)
    public ModelAndView buyNow(@PathVariable String productId,@PathVariable String userId,@PathVariable String sellerId) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("==========================");
        System.out.println(productId+" "+userId+" "+sellerId);
        List<Order> orders =new ArrayList<>();
        try {
            orders = productService.buyNow(productId,userId,sellerId);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return modelAndView;
    }
    
}
