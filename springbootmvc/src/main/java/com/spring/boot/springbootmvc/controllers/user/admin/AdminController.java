package com.spring.boot.springbootmvc.controllers.user.admin;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AdminController {
    @Autowired
    AdminServices adminservice;
    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView welcomePage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute AdminBeans adminBeans ){
        AdminEntity admn = null;
        try {
            admn=adminservice.login(adminBeans);
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("adminData", admn.getUserId());
            modelAndView.setViewName("admin/home");
            return modelAndView;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }

    }  
}
