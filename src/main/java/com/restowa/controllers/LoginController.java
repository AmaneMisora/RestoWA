/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.controllers;

import com.restowa.domain.model.UserAccount;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author yanis
 */
@Controller
public class LoginController implements WebMvcConfigurer{
    
    private static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());
    //public UserService userService;
    
    //@RequestMapping(value = "/login", method = RequestMethod.GET)
    @GetMapping("/login")
    public String login(Model model) {
        LOGGER.log(Level.INFO, "Test de logger");
        
        model.addAttribute("userAccount", new UserAccount());

        return "login";
    }
    
    @PostMapping("/login")
    public String checkPersonInfo(@Valid UserAccount userAccount, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "login";
        }

        // /!\/!\/!\ Retourner vers la page après connexion lorsqu'elle existe /!\/!\/!\
        return "redirect:/";
    }
}
