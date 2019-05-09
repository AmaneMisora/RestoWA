/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.controllers;

import com.restowa.bl.concrete.StoreManager;
import com.restowa.domain.model.Store;
import com.restowa.domain.model.TypeEnum;
import com.restowa.domain.model.UserAccount;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author yanis
 */
@Controller
public class ListStoreController {
    
    private static final Logger LOGGER = Logger.getLogger(ListStoreController.class.getName());
    
    @Resource
    StoreManager storeManager;
    
    @GetMapping("/listStore")
    public ModelAndView store(@SessionAttribute(name="userAccount", required=false) UserAccount userAccount) {
        
        LOGGER.log(Level.INFO, "Start ListPromotionController (store)");
        
        // Check if user has rights
        if(userAccount == null) {
            ModelAndView mav = new ModelAndView("accessDenied");
            mav.addObject("errorMessage", "Vous devez vous connecter pour pouvoir avoir accès à cette page !");
            LOGGER.log(Level.SEVERE, "Access right not sufficient");
            LOGGER.log(Level.INFO, "End ListStoreController");
            return mav;
        }
        if(userAccount.getId() == 0) {
            ModelAndView mav = new ModelAndView("accessDenied");
            mav.addObject("errorMessage", "Vous devez vous connecter pour pouvoir avoir accès à cette page !");
            LOGGER.log(Level.SEVERE, "Access right not sufficient");
            LOGGER.log(Level.INFO, "End ListStoreController");
            return mav;
        }
        if(userAccount.getType() == TypeEnum.Client) {
            ModelAndView mav = new ModelAndView("accessDenied");
            mav.addObject("errorMessage", "Vous n'avez pas les droits pour accéder à cette page !");
            LOGGER.log(Level.SEVERE, "Access right not sufficient");
            LOGGER.log(Level.INFO, "End ListStoreController");
            return mav;
        }
        
        ModelAndView model = new ModelAndView("listStore");
        
        List<Store> stores = storeManager.getAllStore();
        List<Store> finalListStore = new ArrayList<Store>();
        
        for(Store store : stores) {
            if(store.getLastModifiedBy().getId() == userAccount.getId())
                finalListStore.add(store);
        }
        
        if(userAccount.getType() == TypeEnum.Administrateur)
            model.addObject("stores", stores);
        else
            model.addObject("stores", finalListStore);
        
        LOGGER.log(Level.INFO, "End ListStoreController");
        return model;
    }
    
    @PostMapping("/listStore")
    public ModelAndView researchStore(@SessionAttribute(name="userAccount", required=false) UserAccount userAccount, @RequestParam String search) {
        
        LOGGER.log(Level.INFO, "Start ListPromotionController (researchStore)");
        
        // Check if user has rights
        if(userAccount == null) {
            ModelAndView mav = new ModelAndView("accessDenied");
            mav.addObject("errorMessage", "Vous devez vous connecter pour pouvoir avoir accès à cette page !");
            LOGGER.log(Level.SEVERE, "Access right not sufficient");
            LOGGER.log(Level.INFO, "End ListStoreController");
            return mav;
        }
        if(userAccount.getId() == 0) {
            ModelAndView mav = new ModelAndView("accessDenied");
            mav.addObject("errorMessage", "Vous devez vous connecter pour pouvoir avoir accès à cette page !");
            LOGGER.log(Level.SEVERE, "Access right not sufficient");
            LOGGER.log(Level.INFO, "End ListStoreController");
            return mav;
        }
        if(userAccount.getType() == TypeEnum.Client) {
            ModelAndView mav = new ModelAndView("accessDenied");
            mav.addObject("errorMessage", "Vous n'avez pas les droits pour accéder à cette page !");
            LOGGER.log(Level.SEVERE, "Access right not sufficient");
            LOGGER.log(Level.INFO, "End ListStoreController");
            return mav;
        }
        
        ModelAndView model = new ModelAndView("listStore");
        
        List<Store> stores = storeManager.getAllStore();
        List<Store> userListStore = new ArrayList<Store>();
        List<Store> finalListStore = new ArrayList<Store>();
        
        for(Store store : stores) {
            if(store.getLastModifiedBy().getId() == userAccount.getId())
                userListStore.add(store);
        }
        
        
        if(userAccount.getType() == TypeEnum.Administrateur)
            userListStore = stores;
        
        String[] keyWords = search.split(" ");
        for(Store store : userListStore) {
            for(String word : keyWords) {
                if(store.contains(word)) {
                    if(!finalListStore.contains(store))
                        finalListStore.add(store);
                }
            }
        }
        
        model.addObject("stores", finalListStore);
        
        LOGGER.log(Level.INFO, "End ListStoreController");
        return model;
    }
}
