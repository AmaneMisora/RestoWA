/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.controllers;

import com.restowa.bl.concrete.UserAccountManager;
import com.restowa.domain.model.UserAccount;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author yanis
 */
@Controller
@SessionAttributes("userAccount")
public class LoginController implements WebMvcConfigurer{
    
    private static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());
    //public UserService userService;
    
    @Resource
    UserAccountManager userAccountManager;
    
    @ModelAttribute("userAccount")
    public UserAccount setupUserAccount() {
       UserAccount a = new UserAccount();
      return a;
   }
    
    //@RequestMapping(value = "/login", method = RequestMethod.GET)
    @GetMapping("/login")
    public String login(@ModelAttribute("userAccount") UserAccount userAccount, Model model) {
        LOGGER.log(Level.INFO, "Test de logger");
        
        model.addAttribute("userAccount", userAccount);

        return "login";
    }
    
    @PostMapping("/login")
    public String checkPersonInfo(@Valid @ModelAttribute UserAccount userAccount, BindingResult userAccountResult, Model model) {

        List<UserAccount> listUser = userAccountManager.getUserAccountByEmail(userAccount.getEmail());
        if(!listUser.isEmpty())
            userAccount.setUserAccount(listUser.get(0));
        else
            model.addAttribute("ErrorMessage", "Identifiant ou mot de passe incorrects");

        // /!\/!\/!\ Retourner vers la page après connexion lorsqu'elle existe /!\/!\/!\
        return "redirect:/";
    }
}
