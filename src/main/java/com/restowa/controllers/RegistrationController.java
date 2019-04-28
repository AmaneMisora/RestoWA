/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.controllers;


import com.restowa.domain.model.Address;
import com.restowa.domain.model.UserAccount;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author yanis
 */
@Controller
public class RegistrationController {
    
    private static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());
    //public UserService userService;
    
    
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userAccount", new UserAccount());
        model.addAttribute("address", new Address());

        return "register";
    }
    
    @PostMapping("/register")
    public String checkAndCreateUserAccount(@Valid UserAccount userAccount, BindingResult userAccountResult, @Valid Address address, BindingResult addressResult, Model model) {

        if (userAccountResult.hasErrors() || addressResult.hasErrors()) {
            return "register";
        }

        // /!\/!\/!\ Retourner vers la page après connexion lorsqu'elle existe /!\/!\/!\
        return "redirect:/";
    }
}