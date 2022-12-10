package com.spring.boot.springbootmvc.controllers.user.admin;

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

import com.spring.boot.springbootmvc.controllers.user.b2cuser.B2cEntity;
import com.spring.boot.springbootmvc.controllers.user.b2cuser.B2cServices;
import com.spring.boot.springbootmvc.controllers.user.products.ProductEntity;
import com.spring.boot.springbootmvc.controllers.user.products.ProductService;

@RestController
public class AdminController {
    @Autowired
    AdminServices adminservice;
    private static final Integer role = 7077;
    @Autowired
    ProductService productService;
    @Autowired
    B2cServices b2cServices;
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView welcomePage(@ModelAttribute("userDetails") AdminBeans adminBeans,
            HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        ModelAndView modelAndView = new ModelAndView();
        AdminEntity adminEntity = new AdminEntity();
        String userId;
        String userName;
        try {
            userId = (String) session.getAttribute("userId");
            userName = (String) session.getAttribute("userName");
            if (userId != null) {
            if (userId != null && userName != null && userId.equalsIgnoreCase(adminEntity.getUserId())) {
                modelAndView.addObject("userName", userName);
                modelAndView.addObject("userId", userId);
                modelAndView.setViewName("admin/home");
                return modelAndView;
            }
        }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        try {
            modelAndView.setViewName("index");
            return modelAndView;
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
        AdminEntity adminEntity = new AdminEntity();
        String userId;
        String userName;
        try {
            userId = (String) session.getAttribute("userId");
            userName = (String) session.getAttribute("userName");
            adminEntity = adminservice.getAdminUserId(userId);
            if (userId != null && userName != null && userId.equalsIgnoreCase(adminEntity.getUserId())) {
                modelAndView.addObject("userName", userName);
                modelAndView.addObject("userId", userId);
                modelAndView.setViewName("admin/home");
                return modelAndView;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            modelAndView.setViewName("redirect:/index");
            return modelAndView;
        }

        try {
            try {
                admn = adminservice.login(adminBeans);
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
                modelAndView.addObject("credMsg", "Incorrect userId or password");
                modelAndView.setViewName("index");
                return modelAndView;
            }
            if (admn != null && adminBeans.getUserId().equalsIgnoreCase(admn.getUserId())) {
                modelAndView.addObject("adminData", admn.getUserId());
                modelAndView.addObject("message", "You Are In!");
                session.setAttribute("userId", admn.getUserId());
                session.setAttribute("userName", admn.getUserName());
                userId = (String) session.getAttribute("userId");
                userName = (String) session.getAttribute("userName");
                modelAndView.addObject("userName", userName);
                modelAndView.addObject("userId", userId);
                modelAndView.setViewName("admin/home");
                return modelAndView;

            } else {
                modelAndView.addObject("credMsg", "Incorrect userId or password");
                modelAndView.setViewName("index");
                return modelAndView;

            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();

            return null;
        }
    }

    @RequestMapping("/destroy")
    public ModelAndView destroySession(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        httpSession.removeAttribute("userId");
        httpSession.removeAttribute("userName");
        modelAndView.setViewName("redirect:/");
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
                    && adminEntity.getAdminSecurity() == role) {
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

    @RequestMapping(value = "/updateAdmin/{userId}", method = RequestMethod.POST)
    public ModelAndView updateAdmin(@PathVariable String userId, @ModelAttribute("updateAtr") AdminBeans adminBeans,
            HttpSession httpSession) {
        String msg = "";
        ModelAndView modelAndView = new ModelAndView();
        try {

            msg = adminservice.updateById(userId, adminBeans);
            if (msg.equals("Details updated successfuly !")) {
                modelAndView.addObject("message", msg);
                modelAndView.setViewName("messages/success");
            }
            if (msg.equalsIgnoreCase("Sorry! Details can't be updated.")) {
                modelAndView.addObject("message", msg);
                modelAndView.setViewName("messages/failed");
            }
            if (msg.equalsIgnoreCase("You are not authorise to update Admin Type.")) {
                modelAndView.addObject("message", msg);
                modelAndView.setViewName("messages/failed");
            }
            return modelAndView;

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            modelAndView.addObject("message", msg);
            modelAndView.setViewName("messages/failed");
            return modelAndView;
        }
    }

    @RequestMapping(value = "/editAdmin/{userId}", method = RequestMethod.GET)
    public ModelAndView editAdmin(@PathVariable String userId, @ModelAttribute("updateAtr") AdminBeans adminBeans,
            HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        AdminEntity adminEntity = new AdminEntity();
        try {
            adminEntity = adminservice.getUserDetailsById(userId);
            modelAndView.addObject("userData", adminEntity);
            modelAndView.addObject("userIds", userId);
            modelAndView.setViewName("admin/updateAdmin");
            return modelAndView;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return modelAndView;
        }
    }

    @RequestMapping(value = "/deleteAdmin/{userId}", method = RequestMethod.GET)
    public ModelAndView deleteAdmin(@PathVariable String userId, HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        String message = "";
        try {
            message = adminservice.deleteAdminById(userId);
            if (message.equalsIgnoreCase("Admin Deleted Successfully !")) {
                modelAndView.addObject("message", message);
                modelAndView.setViewName("messages/success");
                return modelAndView;
            } else {
                modelAndView.addObject("message", message);
                modelAndView.setViewName("messages/failed");
                return modelAndView;
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return modelAndView;
        }
    }

    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    public ModelAndView getAllUser(HttpSession httpSession) {
        String userId = (String)httpSession.getAttribute("userId");
        String userName = (String)httpSession.getAttribute("userName");
        List<AdminEntity> admList = new ArrayList<AdminEntity>();
        ModelAndView modelAndView = new ModelAndView();
        try {
            if (userId != null && userName != null && role == 7077 ) {
                
                admList = adminservice.getAllUser();
                modelAndView.addObject("admList", admList);
                modelAndView.setViewName("admin/adminlist");
                return modelAndView;
            } else {
                return null;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;

        }
    }

    @RequestMapping("/forgotPassword")
    public ModelAndView getForgotPasswordPage() {
        ModelAndView modelAndView = new ModelAndView();
        try {
            modelAndView.setViewName("admin/adminForgotPassword");
            return modelAndView;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("/forgotPassByUserId")
    public ModelAndView forgotPassByUserId(@ModelAttribute("forgotPass") AdminBeans adminBeans) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            if (!adminBeans.getUserId().equalsIgnoreCase("")) {
                modelAndView.addObject("userId", adminBeans.getUserId());
                modelAndView.setViewName("admin/changePassword");
            } else {
                modelAndView.setViewName("redirect:/forgotPassword");
                return modelAndView;
            }

            return modelAndView;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping(value = "/generateNewPassword/{userId}", method = RequestMethod.POST)
    public ModelAndView generateNewPassword(@PathVariable String userId,
            @ModelAttribute("generatePass") AdminBeans adminBeans) {
        ModelAndView modelAndView = new ModelAndView();
        String msg = "";
        try {
            if (adminBeans.getUserPass().equalsIgnoreCase(adminBeans.getPassword2())) {
                msg = adminservice.generateNewPassword(adminBeans, userId);
                modelAndView.addObject("message", msg);
                modelAndView.setViewName("messages/success");
            }
            return modelAndView;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return modelAndView;
        }

    }

    @RequestMapping(value = "/cheUserId/{userId}", method = RequestMethod.POST)
    public String checkUserId(@PathVariable String userId) {
        String msg = "";
        try {
            msg = adminservice.checkUserId(userId);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return msg;
    }

    @RequestMapping("/getProductList")
    public ModelAndView getProductList() {
        ModelAndView modelAndView = new ModelAndView();
        List<ProductEntity> productEntity = new ArrayList<>();
        try {
            productEntity =   productService.getProductList();
            modelAndView.addObject("products", productEntity);
            modelAndView.setViewName("admin/productList");
            return modelAndView;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/getUserList")
    public ModelAndView getUserList() {
        ModelAndView modelAndView = new ModelAndView();
        List<B2cEntity> b2cEntities = new ArrayList<>();
        try {
            b2cEntities =   b2cServices.getUserList();
            modelAndView.addObject("b2cEntities", b2cEntities);
            modelAndView.setViewName("admin/UserList");
            return modelAndView;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }
}
