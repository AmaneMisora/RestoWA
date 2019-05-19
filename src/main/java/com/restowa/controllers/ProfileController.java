package com.restowa.controllers;

import com.restowa.bl.concrete.UserAccountManager;
import com.restowa.domain.model.Address;
import com.restowa.domain.model.UserAccount;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller handling the profile page
 * 
 * @author yanis
 */
@Controller
public class ProfileController {
    
    private static final Logger LOGGER = Logger.getLogger(ProfileController.class.getName());
    
    @Resource
    private UserAccountManager userAccountManager;
    
    /**
     * Display editable data of the connected user profile
     * 
     * @param userAccount Connected user
     * @return Profile Page
     */
    @GetMapping("/profile")
    public ModelAndView profile(@SessionAttribute(name="userAccount", required=false) UserAccount userAccount) {
        
        LOGGER.log(Level.INFO, "Start ProfileController (profile)");
        
        // Need to be connected to access this page
        if(userAccount == null) {
            ModelAndView mav = new ModelAndView("accessDenied");
            mav.addObject("errorMessage", "Vous devez vous connecter pour pouvoir avoir accès à cette page !");
            LOGGER.log(Level.SEVERE, "Access right not sufficient");
            LOGGER.log(Level.INFO, "End ProfileController");
            return mav;
        }
        if(userAccount.getId() == 0) {
            ModelAndView mav = new ModelAndView("accessDenied");
            mav.addObject("errorMessage", "Vous devez vous connecter pour pouvoir avoir accès à cette page !");
            LOGGER.log(Level.SEVERE, "Access right not sufficient");
            LOGGER.log(Level.INFO, "End ProfileController");
            return mav;
        }
        
        ModelAndView mav = new ModelAndView("profile");
        UserAccount user = userAccount;
        mav.addObject("user", user);
        mav.addObject("address", user.getAddress());
        LOGGER.log(Level.INFO, "End ProfileController");
        return mav;
    }
    
    /**
     * Edit connected user profil
     * 
     * @param userAccount Connected profile
     * @param user nex user info
     * @param userResult new user form errors
     * @param address new user address
     * @param addressResult new user address form errors
     * @param model
     * @return 
     */
    @PostMapping("/profile")
    public ModelAndView editProfile(@SessionAttribute(name="userAccount", required=false) UserAccount userAccount, @Valid @ModelAttribute("user") UserAccount user, BindingResult userResult, @Valid Address address, BindingResult addressResult, Model model) {

        LOGGER.log(Level.INFO, "Start ProfileController (editProfile)");
        
        // Need to be connected to access this page
        if(userAccount == null) {
            ModelAndView mav = new ModelAndView("accessDenied");
            mav.addObject("errorMessage", "Vous devez vous connecter pour pouvoir avoir accès à cette page !");
            LOGGER.log(Level.SEVERE, "Access right not sufficient");
            LOGGER.log(Level.INFO, "End ProfileController");
            return mav;
        }
        if(userAccount.getId() == 0) {
            ModelAndView mav = new ModelAndView("accessDenied");
            mav.addObject("errorMessage", "Vous devez vous connecter pour pouvoir avoir accès à cette page !");
            LOGGER.log(Level.SEVERE, "Access right not sufficient");
            LOGGER.log(Level.INFO, "End ProfileController");
            return mav;
        }
        
        if (userResult.hasErrors() || addressResult.hasErrors()) {
            LOGGER.log(Level.INFO, "End ProfileController");
            return new ModelAndView("profile");
        }else if(!userAccountManager.getUserAccountByEmail(userAccount.getEmail()).isEmpty() && !userAccount.getEmail().equals(user.getEmail())) {
            userResult.addError(new FieldError("UserAccount", "email", "Cet email est déjà utilisé"));
            LOGGER.log(Level.INFO, "End ProfileController");
            return new ModelAndView("profile");
        }
        
        userAccount.setFirstName(user.getFirstName());
        userAccount.setLastName(user.getLastName());
        userAccount.setEmail(user.getEmail());
        userAccount.setPassword(user.getPassword());
        userAccount.setPhoneNumber(user.getPhoneNumber());
        userAccount.setAddress(address);
        
        userAccountManager.saveUserAccount(userAccount);
        
        LOGGER.log(Level.INFO, "End ProfileController");
        return new ModelAndView("redirect:listPromotion");
    }
    
}
