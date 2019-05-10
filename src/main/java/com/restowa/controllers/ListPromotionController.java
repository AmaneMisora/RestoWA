/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.controllers;

import com.restowa.bl.concrete.PromotionManager;
import com.restowa.domain.model.Promotion;
import com.restowa.domain.model.Store;
import com.restowa.domain.model.TypeEnum;
import com.restowa.domain.model.UserAccount;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author yanis
 */
@Controller
public class ListPromotionController {
    
    private static final Logger LOGGER = Logger.getLogger(ListPromotionController.class.getName());
    
    @Resource
    PromotionManager promotionManager;
    
    @GetMapping("/listPromotion")
    public ModelAndView promotion(@SessionAttribute(name="userAccount", required=false) UserAccount userAccount) {
        
        LOGGER.log(Level.INFO, "Start ListPromotionController (promotion)");
        
        // Check if user has rights
        if(userAccount == null) {
            ModelAndView mav = new ModelAndView("accessDenied");
            mav.addObject("errorMessage", "Vous devez vous connecter pour pouvoir avoir accès à cette page !");
            LOGGER.log(Level.SEVERE, "Access right not sufficient");
            LOGGER.log(Level.INFO, "End ListPromotionController");
            return mav;
        }
        if(userAccount.getId() == 0) {
            ModelAndView mav = new ModelAndView("accessDenied");
            mav.addObject("errorMessage", "Vous devez vous connecter pour pouvoir avoir accès à cette page !");
            LOGGER.log(Level.SEVERE, "Access right not sufficient");
            LOGGER.log(Level.INFO, "End ListPromotionController");
            return mav;
        }
        
        ModelAndView model = new ModelAndView("listPromotion");
        
        List<Promotion> promotions = promotionManager.getAllPromotions();
        List<Promotion> finalListPromotion = new ArrayList<Promotion>();
        
        for(Promotion promotion : promotions) {
            if(promotion.isDisabled()) {
                if(userAccount.getType() == TypeEnum.Administrateur) {
                    if(!finalListPromotion.contains(promotion))
                        finalListPromotion.add(promotion);
                }
            } else {
                if(!finalListPromotion.contains(promotion))
                    finalListPromotion.add(promotion);
            }
        }
        
        finalListPromotion = sortPromotion(finalListPromotion);
        
        
        model.addObject("promotions", finalListPromotion);
        
        LOGGER.log(Level.INFO, "End ListPromotionController");
        return model;
    }
    
    @PostMapping("/listPromotion")
    public ModelAndView researchPromotion(@SessionAttribute(name="userAccount", required=false) UserAccount userAccount, @RequestParam String search) {
        
        LOGGER.log(Level.INFO, "Start ListPromotionController (researchPromotion)");
        
        // Check if user has rights
        if(userAccount == null) {
            ModelAndView mav = new ModelAndView("accessDenied");
            mav.addObject("errorMessage", "Vous devez vous connecter pour pouvoir avoir accès à cette page !");
            LOGGER.log(Level.SEVERE, "Access right not sufficient");
            LOGGER.log(Level.INFO, "End ListPromotionController");
            return mav;
        }
        if(userAccount.getId() == 0) {
            ModelAndView mav = new ModelAndView("accessDenied");
            mav.addObject("errorMessage", "Vous devez vous connecter pour pouvoir avoir accès à cette page !");
            LOGGER.log(Level.SEVERE, "Access right not sufficient");
            LOGGER.log(Level.INFO, "End ListPromotionController");
            return mav;
        }
        
        ModelAndView model = new ModelAndView("listPromotion");
        
        List<Promotion> promotions = promotionManager.getAllPromotions();
        List<Promotion> userListPromotion = new ArrayList<Promotion>();
        List<Promotion> finalListPromotion = new ArrayList<Promotion>();
        
        for(Promotion promotion : promotions) {
            if(promotion.isDisabled()) {
                if(userAccount.getType() == TypeEnum.Administrateur) {
                    if(!userListPromotion.contains(promotion))
                        userListPromotion.add(promotion);
                }
            } else {
                if(!userListPromotion.contains(promotion))
                    userListPromotion.add(promotion);
            }
        }
        
        String[] keyWords = search.split(" ");
        for(Promotion promotion : userListPromotion) {
            for(String word : keyWords) {
                if(promotion.contains(word)) {
                    if(!finalListPromotion.contains(promotion))
                        finalListPromotion.add(promotion);
                }
            }
        }
        
        finalListPromotion = sortPromotion(finalListPromotion);
        
        model.addObject("promotions", finalListPromotion);
        
        LOGGER.log(Level.INFO, "End ListPromotionController");
        return model;
    }
    
    private List<Promotion> sortPromotion(List<Promotion> listPromo) {
        List<Promotion> finalList = new ArrayList<Promotion>();
        int position = -1;
        for(Promotion promo : listPromo) {
            position = -1;
            if(finalList.isEmpty())
                finalList.add(promo);
            else {
                for(Promotion p : finalList) {
                    if(promo.getPosition() <= p.getPosition())
                        position = finalList.indexOf(p);
                }
                if(position == -1)
                    finalList.add(finalList.size(), promo);
                else
                    finalList.add(position, promo);
            }
        }
        
        return finalList;
    }
}
