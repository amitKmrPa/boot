package com.spring.boot.springbootmvc.controllers.user.b2cuser;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boot.springbootmvc.controllers.user.products.ProductEntity;
import com.spring.boot.springbootmvc.controllers.user.products.ProductService;

@CrossOrigin(origins = {"http://localhost:3000","http://192.168.2.8:19000"})
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

    @RequestMapping(value = "/registerForRedux", method = RequestMethod.POST)
    public String registerForRedux(@RequestParam("userName") String userName,@RequestParam("userId") String userId,@RequestParam("userPassword") String userPassword,@RequestParam("age") Integer age,@RequestParam("emailId") String emailId,@RequestParam("phone") String phone,@RequestParam("gender") String gender) {
        ModelAndView modelAndView = new ModelAndView();
        B2cBeans b2cBeans = new B2cBeans();
        String msg = "";
        try {
            b2cBeans.setAge(age);
            b2cBeans.setEmailId(emailId);
            b2cBeans.setGender(gender);
            b2cBeans.setPhone(phone);
            b2cBeans.setUserId(userId);
            b2cBeans.setUserName(userName);
            b2cBeans.setUserPass(userPassword);
            msg = b2cServices.saveB2cUserDetails(b2cBeans);
            modelAndView.addObject("message", msg);
            modelAndView.setViewName("messages/success");
            return msg;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            modelAndView.addObject("message", msg);
            modelAndView.setViewName("messages/failed");
            return msg;
        }
    }

    @RequestMapping(value = "/userForgotPassword")
    public ModelAndView userForgotPassword() {
        ModelAndView modelAndView = new ModelAndView();
        try {
            modelAndView.setViewName("B2cUser/userForgotPassword");
            return modelAndView;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            modelAndView.setViewName("messages/failed");
            return modelAndView;
        }
    }

    @RequestMapping("/userForgotPasswordSubmit")
    public ModelAndView userForgotPasswordSubmit(@ModelAttribute("userForgotPass") B2cEntity b2cEntity) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            if (!b2cEntity.getUserId().equalsIgnoreCase("")) {
                modelAndView.addObject("userId", b2cEntity.getUserId());
                modelAndView.setViewName("B2cUser/userChangePassword");
            } else {
                modelAndView.setViewName("redirect:/userForgotPassword");
                return modelAndView;
            }
            return modelAndView;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "/generateNewPasswordForUser/{userId}", method = RequestMethod.POST)
    public ModelAndView generateNewPassword(@PathVariable String userId,
            @ModelAttribute("generatePass") B2cBeans b2cBeans) {
        ModelAndView modelAndView = new ModelAndView();
        String msg = "";
        try {
            if (b2cBeans.getUserPass().equalsIgnoreCase(b2cBeans.getPassword2())) {
                msg = b2cServices.generateNewPassword(b2cBeans, userId);
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

    @RequestMapping(value = "/userLoginForReact", method = RequestMethod.POST)
    public Object userLoginForReact(@RequestParam("userId") String userId,@RequestParam("userPassword") String userPassword) {
        Object userDetails = new Object();
        try {
            userDetails = b2cServices.userLoginForReact(userId, userPassword);
            return userDetails;        
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
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
                modelAndView.addObject("message", "You Are In!");
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
        List<Object> orders =new ArrayList<>();
        try {
            if (!userId.equalsIgnoreCase("null")) {                
                orders = productService.buyNow(productId,userId,sellerId);
                modelAndView.addObject("orders", orders);
                modelAndView.setViewName("buynowpreview/buynow");
            } else {
                modelAndView.setViewName("redirect:/");
            }
            return modelAndView;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "/getAllProductsDetailsForReduxAppToBuy")
    public List<Object> getAllProductsDetailsForReduxAppToBuy(@RequestParam("userId") String userId,@RequestParam("productId") String productId,@RequestParam("sellerId") String sellerId,HttpSession httpSession) {
        List<Object> orders =new ArrayList<>();
        try {
            orders = productService.buyNow(productId,userId,sellerId);
            System.out.println("==");
            return orders;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }
    
}
