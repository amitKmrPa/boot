package com.spring.boot.springbootmvc.controllers.user.b2cuser;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class B2cController {
    @Autowired
    B2cServices b2cServices;

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
            userId = (String) session.getAttribute("user_Id");
            userName = (String) session.getAttribute("user_Name");
            if (userId != null && userName != null) {
                modelAndView.addObject("userName", userName);
                modelAndView.addObject("userId", userId);
                modelAndView.setViewName("B2cUser/userhome");
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
        B2cEntity b2cEntity = null;
        try {
            b2cEntity = b2cServices.userLogin(b2cBeans);
            if (b2cEntity != null && b2cBeans.getUserId().equalsIgnoreCase(b2cEntity.getUserId())) {
                modelAndView.addObject("adminData", b2cEntity.getUserId());
                modelAndView.addObject("message", "You are in!");
                session.setAttribute("user_Id", b2cEntity.getUserId());
                session.setAttribute("user_Name", b2cEntity.getUserName());
                String userId = (String) session.getAttribute("user_Id");
                String userName = (String) session.getAttribute("user_Name");
                modelAndView.addObject("user_Name", userName);
                modelAndView.addObject("user_Id", userId);
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

}
