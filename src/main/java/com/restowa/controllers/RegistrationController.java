/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.controllers;


import com.restowa.bl.concrete.UserAccountManager;
import com.restowa.domain.model.Address;
import com.restowa.domain.model.TypeEnum;
import com.restowa.domain.model.UserAccount;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Controller handling the registration page
 * 
 * @author yanis
 */
@Controller
public class RegistrationController {
    
    private static final Logger LOGGER = Logger.getLogger(RegistrationController.class.getName());
    
    @Resource
    UserAccountManager uamanager;
    
    /**
     * Redirect to the register page with form handling attribute (Get method)
     * 
     * @param model : Model containing attribute which is going to be send to the register page
     * @return 
     */
    @GetMapping("/register")
    public String register(Model model) {
        
        LOGGER.log(Level.INFO, "Start RegistrationController (register)");
        
        model.addAttribute("userAccount", new UserAccount());
        model.addAttribute("address", new Address());
        
        LOGGER.log(Level.INFO, "End RegistrationController");

        return "register";
    }
    
    /**
     * Check user infos and create a new UserAccount if they are correct
     * Redirect to the login page if successful
     * 
     * @param userAccount : model attribute for the form handling of the user
     * @param userAccountResult : BindingResult containing all errors of the user validators
     * @param address : model attribute for the form handling of the address
     * @param addressResult : BondingResult containing all errors of the address validators
     * @return 
     */
    @PostMapping("/register")
    public String checkAndCreateUserAccount(@Valid UserAccount userAccount, BindingResult userAccountResult, @Valid Address address, BindingResult addressResult) {

        LOGGER.log(Level.INFO, "Start RegistrationController (checkAndCreateUserAccount)");
        
        if (userAccountResult.hasErrors() || addressResult.hasErrors()) {
            LOGGER.log(Level.INFO, "End RegistrationController");
            return "register";
        }else if(!uamanager.getUserAccountByEmail(userAccount.getEmail()).isEmpty()) {
            userAccountResult.addError(new FieldError("UserAccount", "email", "Cet email est déjà utilisé"));
            LOGGER.log(Level.INFO, "End RegistrationController");
            return "register";
        }

        LocalDateTime date = LocalDateTime.now();
        
        userAccount.setActive(true);
        userAccount.setAddress(address);
        userAccount.setCreationDate(date);
        userAccount.setIsRemoved(false);
        userAccount.setLastModificationDate(date);
        userAccount.setType(TypeEnum.Client);
        uamanager.saveUserAccount(userAccount);
        
        
        LOGGER.log(Level.INFO, "End RegistrationController");   
        return "redirect:login";
    }
}