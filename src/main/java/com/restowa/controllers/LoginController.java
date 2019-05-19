package com.restowa.controllers;

import com.restowa.bl.concrete.PromotionManager;
import com.restowa.bl.concrete.UserAccountManager;
import com.restowa.domain.model.UserAccount;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Controller handling the login page
 * 
 * @author yanis
 */
@Controller
@SessionAttributes("userAccount")
public class LoginController implements WebMvcConfigurer{
    
    private static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());
    
    @Resource
    UserAccountManager userAccountManager;
    
    @Resource
    PromotionManager promotionManager;
    
    /**
     * set user session
     * @return 
     */
    @ModelAttribute("userAccount")
    public UserAccount setupUserAccount() {
       UserAccount a = new UserAccount();
      return a;
    }
    
    /**
     * show login page
     * @param model
     * @return 
     */
    @GetMapping("/login")
    public String login(Model model) {
        
        LOGGER.log(Level.INFO, "Start LoginController (login)");
        LOGGER.log(Level.INFO, "End LoginController");

        return "login";
    }
    
    /**
     * Validate and create user session
     * 
     * @param userAccount user to connect
     * @param model
     * @param email user email
     * @param password user password
     * @return 
     */
    @PostMapping("/login")
    public ModelAndView checkPersonInfo(@ModelAttribute UserAccount userAccount, Model model, String email, String password) {
        
        LOGGER.log(Level.INFO, "Start LoginController (checkPersonInfo)");
        
        ModelAndView mav = new ModelAndView();
        
        // Check correctness of data
        if(email.equals("") || password.equals("")) {
            mav.setViewName("login");
            mav.addObject("errorMessage", "Cet email ou ce nom d'utilisateur sont incorrects");
            LOGGER.log(Level.INFO, "End LoginController");
            return mav;
        }
        
        List<UserAccount> ua = userAccountManager.getUserAccountByEmail(email);
        
        if(ua.isEmpty()) {
            mav.setViewName("login");
            mav.addObject("errorMessage", "Cet email ou ce nom d'utilisateur sont incorrects");
            LOGGER.log(Level.INFO, "End LoginController");
            return mav;
        }
        
        if(!ua.get(0).getPassword().equals(password)) {
            mav.setViewName("login");
            mav.addObject("errorMessage", "Cet email ou ce nom d'utilisateur sont incorrects");
            LOGGER.log(Level.INFO, "End LoginController");
            return mav;
        }
        
        userAccount.setUserAccount(ua.get(0));
        
        mav.setViewName("redirect:listPromotion");
        
        LOGGER.log(Level.INFO, "End LoginController");
        return mav;
    }
    
    /**
     * logout the user
     * 
     * @param status
     * @return 
     */
    @GetMapping("/logout")
    public ModelAndView logout(SessionStatus status) {
        
        LOGGER.log(Level.INFO, "Start LoginController (logout)");
        
        status.setComplete();
        
        LOGGER.log(Level.INFO, "End LoginController");
        
        return new ModelAndView("redirect:/");
    }
}
