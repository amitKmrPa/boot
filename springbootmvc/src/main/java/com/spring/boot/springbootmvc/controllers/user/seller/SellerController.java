package com.spring.boot.springbootmvc.controllers.user.seller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class SellerController {

    @RequestMapping(value="/sellerLogin",method = RequestMethod.POST)
    public ModelAndView sellerLogin(){
        ModelAndView modelAndView = new ModelAndView();
        try {
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        return modelAndView; 
    }


    @RequestMapping(value="/addProducts", method=RequestMethod.POST)
    public ModelAndView addProducts(@RequestParam String param) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        return modelAndView;
    }
    
}
