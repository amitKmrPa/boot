package com.spring.boot.springbootmvc.controllers.user.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/addAdmin",method = RequestMethod.POST)
    public ModelAndView addAdmin(@ModelAttribute AdminBeans adminBeans){
        String msg="";
        ModelAndView modelAndView = new ModelAndView();
        try {
         msg = adminservice.addAdmin(adminBeans);
         modelAndView.addObject("message", msg);
         modelAndView.setViewName("messages/success");
         return modelAndView;
        } catch (Exception e) {
            // TODO: handle exception
            modelAndView.addObject("message", msg);
            modelAndView.setViewName("messages/failed");
            return modelAndView;        
        }
    }
}
