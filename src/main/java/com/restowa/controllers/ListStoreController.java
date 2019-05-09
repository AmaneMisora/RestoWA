/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.controllers;

import com.restowa.bl.concrete.StoreManager;
import com.restowa.domain.model.Store;
import com.restowa.domain.model.UserAccount;
import java.util.ArrayList;
import java.util.List;
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
@SessionAttributes("userAccount")
public class ListStoreController {
    
    @Resource
    StoreManager storeManager;
    
    private static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());
    
    @GetMapping("/listStore")
    public ModelAndView store(@SessionAttribute("userAccount") UserAccount userAccount) {
        
        // Check if user has rights
        if(userAccount == null)
            return new ModelAndView("error");
        
        ModelAndView model = new ModelAndView("listStore");
        
        List<Store> stores = storeManager.getAllStore();
        List<Store> finalListStore = new ArrayList<Store>();
        
        for(Store store : stores) {
            if(store.getLastModifiedBy().getId() == userAccount.getId())
                finalListStore.add(store);
        }
        
        model.addObject("stores", stores);
        
        return model;
    }
    
    @PostMapping("/listStore")
    public ModelAndView reseacrhStore(@SessionAttribute("userAccount") UserAccount userAccount, @RequestParam String search) {
        ModelAndView model = new ModelAndView("listStore");
        
        System.out.println(search);
        
        List<Store> stores = storeManager.getAllStore();
        List<Store> userListStore = new ArrayList<Store>();
        List<Store> finalListStore = new ArrayList<Store>();
        
        for(Store store : stores) {
            if(store.getLastModifiedBy().getId() == userAccount.getId())
                userListStore.add(store);
        }
        
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
        
        return model;
    }
}
