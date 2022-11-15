package com.spring.boot.springbootmvc.controllers.user.admin;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AdminController {
    @Autowired
    AdminServices adminservice;
    Boolean iscorrectCredentials = true;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView welcomePage(@ModelAttribute("userDetails") AdminBeans adminBeans,
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
                modelAndView.setViewName("admin/home");
                return modelAndView;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        try {
            if (!iscorrectCredentials) {
                modelAndView.addObject("cred", iscorrectCredentials);
                modelAndView.addObject("message", "Bad credentials");
                modelAndView.setViewName("index");
                return modelAndView;
            } else {
                iscorrectCredentials = true;
                modelAndView.addObject("cred", iscorrectCredentials);
                modelAndView.setViewName("index");
                return modelAndView;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("userDetails") AdminBeans adminBeans,
            HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        ModelAndView modelAndView = new ModelAndView();
        AdminEntity admn = null;
        try {
            admn = adminservice.login(adminBeans);
            if (admn != null && adminBeans.getUserId().equalsIgnoreCase(admn.getUserId())) {
                iscorrectCredentials = true;
                modelAndView.addObject("adminData", admn.getUserId());
                modelAndView.addObject("cred", iscorrectCredentials);
                modelAndView.addObject("message", "You are in!");
                session.setAttribute("userId", admn.getUserId());
                session.setAttribute("userName", admn.getUserName());
                String userId = (String) session.getAttribute("userId");
                String userName = (String) session.getAttribute("userName");
                modelAndView.addObject("userName", userName);
                modelAndView.addObject("userId", userId);
                modelAndView.setViewName("admin/home");
            }
            return modelAndView;

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            iscorrectCredentials = false;
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }
    }

    @PostMapping("/destroy")
    public ModelAndView destroySession(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        httpSession.removeAttribute("userId");
        httpSession.removeAttribute("userName");
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
    public ModelAndView addAdmin(@ModelAttribute("addAtr") AdminBeans adminBeans, HttpSession httpSession) {
        String msg = "";
        ModelAndView modelAndView = new ModelAndView();
        AdminEntity adminEntity = new AdminEntity();
        try {
            adminEntity = adminservice.getUserDetails((String) httpSession.getAttribute("userId"));
            if (adminEntity.getAdminType().equalsIgnoreCase("super")
                    && adminEntity.getAdminSecurity() == 7077) {
                msg = adminservice.addAdmin(adminBeans);
                if (msg.equals("Details saved successfuly !")) {
                    modelAndView.addObject("message", msg);
                    modelAndView.setViewName("messages/success");
                    return modelAndView;
                } else {
                    modelAndView.addObject("message", msg);
                    modelAndView.setViewName("messages/failed");
                    return modelAndView;
                }
            } else {
                modelAndView.addObject("message", msg);
                modelAndView.setViewName("messages/failed");
                return modelAndView;
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            modelAndView.addObject("message", msg);
            modelAndView.setViewName("messages/failed");
            return modelAndView;
        }
    }

    @RequestMapping(value = "/updateAdmin", method = RequestMethod.POST)
    public ModelAndView updateAdmin(@ModelAttribute("updateAtr") AdminBeans adminBeans, HttpSession httpSession) {
        String msg = "";
        ModelAndView modelAndView = new ModelAndView();
        try {
            msg = adminservice.updateAdmin(adminBeans);
            if (msg.equals("Details saved successfuly !")) {
                modelAndView.addObject("message", msg);
                modelAndView.setViewName("messages/success");
                return modelAndView;
            } else {
                modelAndView.addObject("message", msg);
                modelAndView.setViewName("messages/failed");
                return modelAndView;
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            modelAndView.addObject("message", msg);
            modelAndView.setViewName("messages/failed");
            return modelAndView;
        }
    }

    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    public ModelAndView getAllUser() {
        List<AdminEntity> admList = new ArrayList<AdminEntity>();
        ModelAndView modelAndView = new ModelAndView();

        try {
            admList = adminservice.getAllUser();
            modelAndView.addObject("admList", admList);
            modelAndView.setViewName("admin/adminlist");
            return modelAndView;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;

        }
    }
}
