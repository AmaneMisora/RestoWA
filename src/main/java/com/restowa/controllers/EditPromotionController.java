/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.controllers;

import com.restowa.domain.model.Promotion;
import com.restowa.domain.model.TypeEnum;
import com.restowa.domain.model.UserAccount;
import java.time.LocalDate;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author yanis
 */
@Controller
public class EditPromotionController {
    /*
    @Resource
    private StoreManager storeManager;
    */
    
    private static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());
    
    @GetMapping("/editPromotion")
    public ModelAndView promotion() {
        ModelAndView model = new ModelAndView("editPromotion");
        Promotion promotion = new Promotion();
        promotion.setId(0);
        promotion.setDisabled(true);
        promotion.setEndDate(LocalDate.now().plusMonths(2));
        promotion.setImageURL("nothing.png");
        promotion.setKey(String.valueOf(promotion.getId()));
        promotion.setLongDescription("longue description");
        promotion.setPosition(8);
        promotion.setShortDescription("Petite description");
        promotion.setStartDate(LocalDate.now());
        promotion.setTitle("promotion");
        model.addObject("promotion", promotion);

        return model;
    }
    
    @PostMapping("/editPromotion")
    public String editStore(@Valid Promotion promotion, BindingResult promotionResult, Model model) {

        
        if (promotionResult.hasErrors()) {
            return "editPromotion";
        }
        
        //storeManager.saveStore(store);
        
        /*
        else if(!uamanager.getUserAccountByEmail(userAccount.getEmail()).isEmpty()) {
            userAccountResult.addError(new FieldError("UserAccount", "email", "Cet email est déjà utilisé"));
            return "register";
        }

        Date date = new Date();
        
        userAccount.setActive(true);
        userAccount.setAddress(address);
        userAccount.setCreationDate(date);
        userAccount.setIsRemoved(false);
        userAccount.setLastModificationDate(date);
        userAccount.setType(TypeEnum.Client);
        uamanager.saveUserAccount(userAccount);
*/
        
        
        // /!\/!\/!\ Retourner vers la page après connexion lorsqu'elle existe /!\/!\/!\
        return "redirect:/";
    }   
}
