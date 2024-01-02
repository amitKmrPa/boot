package com.spring.boot.springbootmvc.controllers.user.seller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boot.springbootmvc.controllers.user.products.ProductEntity;
import com.spring.boot.springbootmvc.controllers.user.products.ProductService;
import com.spring.boot.springbootmvc.controllers.user.products.ProductsBeans;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class SellerController {
    @Autowired
    SellerServices sellerServices;
    @Autowired
    ProductService productService;
    public String imageData = "";
    public String productId = "";
    @RequestMapping(value="/sellerRegPage",method = RequestMethod.GET)
    public ModelAndView sellerRegPage( ){
        ModelAndView modelAndView = new ModelAndView();
        try {
            modelAndView.setViewName("seller/SellerRegistration");
        } catch (Exception e) {
            // TODO: handle exception
        }
        return modelAndView; 
    }
    @RequestMapping(value="/sellerLoginPage",method = RequestMethod.GET)
    public ModelAndView sellerLoginPage( ){
        ModelAndView modelAndView = new ModelAndView();
        try {
            modelAndView.setViewName("seller/SellerLogin");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return modelAndView; 
    }
    @RequestMapping(value="/sellerLogin",method = RequestMethod.POST)
    public ModelAndView sellerLogin(@ModelAttribute("sellerLoginAtr") SellerBeans sellerBeans,HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        ModelAndView modelAndView = new ModelAndView();
        SellerEntity sellerEntity = new SellerEntity();
        List<ProductEntity> productEntities = new ArrayList<ProductEntity>();

        try {
            sellerEntity = sellerServices.sellerLogin(sellerBeans);
            if (sellerEntity != null && sellerBeans.getUserId().equalsIgnoreCase(sellerEntity.getUserId())) {
                productEntities = productService.getAllProductDetailsBySellerId(sellerEntity.getUserId());
                modelAndView.addObject("sellerData", sellerEntity.getUserId());
                modelAndView.addObject("message", "Your active product(s) is/are");
                session.setAttribute("userId", sellerEntity.getUserId());
                session.setAttribute("userName", sellerEntity.getUserName());
                String userId = (String) session.getAttribute("userId");
                String userName = (String) session.getAttribute("userName");
                modelAndView.addObject("userName", userName);
                modelAndView.addObject("userId", userId);
                modelAndView.addObject("products", productEntities);
                modelAndView.addObject("userId", session.getAttribute("userId"));
                modelAndView.setViewName("seller/SellerHomePage"); 
                return modelAndView;
            } else {

                modelAndView.setViewName("seller/SellerLogin"); 
                return modelAndView; 
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return modelAndView; 
        }
    }

    @RequestMapping(value="/sellerReg",method = RequestMethod.POST)
    public ModelAndView sellerReg(@ModelAttribute("sellerRegAtr") SellerBeans sellerBeans){
        ModelAndView modelAndView = new ModelAndView();
        String msg = "";
        try {
            msg = sellerServices.sellerReg(sellerBeans);
            modelAndView.addObject("message", msg);
            if (msg.equalsIgnoreCase("Registration Successful !")) {
                
                modelAndView.setViewName("messages/success");
            } else {
                modelAndView.setViewName("messages/failed");
                
            }
            return modelAndView; 

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return modelAndView; 

        }
    }

    @RequestMapping(value = "/checkUserIdForSeller/{userId}", method = RequestMethod.POST)
    public String checkUserIdForSeller(@PathVariable String userId) {
        String msg = "";
        try {
            msg = sellerServices.checkUserIdForSeller(userId);
            return msg;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null; 
        }
    }

    @RequestMapping(value="/addProductPage", method=RequestMethod.GET)
    public ModelAndView addProductPage() {
        ModelAndView modelAndView = new ModelAndView();
        try {
            modelAndView.setViewName("seller/SellerAddProducts");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return modelAndView;
    }

    @RequestMapping(value = "/addProductBySeller", method = RequestMethod.POST)
    public String addProductBySeller(HttpSession session,@ModelAttribute("addProductAtr")ProductsBeans productsBeans) {
        String userId = (String) session.getAttribute("userId");
        String msg = "";
        try {
            productsBeans.setProductId(productId);
            productsBeans.setProductImgId(imageData);
            msg = sellerServices.addProductBySeller(productsBeans,userId);
            return msg;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null; 
        }
    }

    @PostMapping("/upload") 
    public ResponseEntity<?> handleFileUpload( @RequestParam("file") MultipartFile file ) {  
    //   String fileName = file.getOriginalFilename();
      UUID uuid = UUID.randomUUID();
      String uuidAsString = uuid.toString();  
      try {
        file.transferTo( new File("C:\\Users\\AJIT KUMAR PASWAN\\Desktop\\amit\\boot\\springbootmvc\\src\\main\\resources\\static\\product\\uploadedFile\\" + uuidAsString ));
        productId = uuidAsString;
        imageData=uuidAsString;
      } catch (Exception e) {
        imageData="Server Error";
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    } 
    return ResponseEntity.ok(imageData);
    }
    
}
