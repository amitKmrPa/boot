package com.spring.boot.springbootmvc.controllers.user.kart;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class KartController {
    @Autowired
    KartService kartService;
    @RequestMapping(value="/viewUserKart",method = RequestMethod.GET)
    public ModelAndView viewUserKart(HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView();
        List<Object> kart = new ArrayList<>();
        String userId = (String)httpSession.getAttribute("userId");
        String userName = (String)httpSession.getAttribute("userName");
        try {
            kart =  kartService.viewUserKart(userId);
            modelAndView.addObject("product", kart);
            modelAndView.setViewName("kart/userkart");
        } catch (Exception e) {
            // TODO: handle exception
        }
        return modelAndView;
    }
    @RequestMapping(value="/removeFromKart/{productId}/{sellerId}")
    public ModelAndView removeFromKart(@PathVariable("productId") String productId,@PathVariable("sellerId") String sellerId, HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView();
        List<Object> listKart = new ArrayList<>();
        String msg = "";
        try {
            listKart = kartService.removeFromKart(productId,sellerId,(String)httpSession.getAttribute("userId"));
            modelAndView.addObject("product", listKart);
            modelAndView.setViewName("kart/userkart");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return modelAndView;
    }
}
