/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.controllers;

import com.restowa.bl.concrete.StoreManager;
import com.restowa.domain.model.Address;
import com.restowa.domain.model.OpeningHours;
import com.restowa.domain.model.Store;
import com.restowa.domain.model.TypeEnum;
import com.restowa.domain.model.UserAccount;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author yanis
 */

@Controller
public class EditStoreController {
    
    @Resource
    private StoreManager storeManager;
    
    private static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());
    
    @GetMapping("/editStore")
    public ModelAndView store(@SessionAttribute(name="userAccount", required=false) UserAccount userAccount, Integer storeId, String action) {
        
        // Need to be connected to access this page
        if(userAccount == null) {
            ModelAndView mav = new ModelAndView("accessDenied");
            mav.addObject("errorMessage", "Vous devez vous connecter pour pouvoir avoir accès à cette page !");
            return mav;
        }
        
        // New store
        if(storeId == null && action == null) {
            
            // Only administrator and owner can create a store
            if(userAccount.getType() == TypeEnum.Client) {
                ModelAndView mav = new ModelAndView("accessDenied");
                mav.addObject("errorMessage", "Vous n'avez pas les droits pour créer un magasin !");
                return mav;
            }
            
            // Initialization of the new store
            ModelAndView model = new ModelAndView("editStore");
            model.addObject("store", new Store());
            model.addObject("openingHours", new OpeningHours());
            model.addObject("address", new Address());

            return model;
        } else if(storeId != null && action.equals("update")) {
            
            // Modify an existing store
            if(storeId >= 0) {
                
                Store store = storeManager.getStoreById(storeId);
                
                // Check if the user has the rights to modifiy the store
                if(userAccount.getType() == TypeEnum.Administrateur || userAccount.getId() == store.getLastModifiedBy().getId()) {
                    ModelAndView model = new ModelAndView("editStore");
                    model.addObject("store", store);
                    model.addObject("openingHours", store.getOpeningHours());
                    model.addObject("address", store.getAddress());
                    
                    return model;
                }else {
                    ModelAndView mav = new ModelAndView("accessDenied");
                    mav.addObject("errorMessage", "Vous ne pouvez pas modifier un magasin qui ne vous appartient pas !");
                    return mav;
                }
            } else {
                ModelAndView mav = new ModelAndView("accessDenied");
                mav.addObject("errorMessage", "Vous essayer de modifier un magasin qui n'éxiste pas ou qui ne vous appartient pas !");
                return mav;
            }
        }
        ModelAndView mav = new ModelAndView("accessDenied");
        mav.addObject("errorMessage", "Un problème est survenu dans l'url !");
        return mav;
    }
    
    @PostMapping("/editStore")
    public ModelAndView editStore(@SessionAttribute("userAccount") UserAccount userAccount, @Valid Store store, BindingResult storeResult, @Valid OpeningHours openingHours, BindingResult openingHoursResult, @Valid Address address, BindingResult addressResult, Model model, Integer storeId, String action) {

        // Need to be connected to access this page
        if(userAccount == null) {
            ModelAndView mav = new ModelAndView("accessDenied");
            mav.addObject("errorMessage", "Vous devez vous connecter pour pouvoir avoir accès à cette page !");
            return mav;
        }
        
        // Client cannot create or modify a store
        if(userAccount.getType() == TypeEnum.Client) {
                ModelAndView mav = new ModelAndView("accessDenied");
                mav.addObject("errorMessage", "Vous n'avez pas les droits pour créer ou modifier un magasin !");
                return mav;
            }
        
        // Create new or modify old store
        if(storeId == null && action == null) {
        
        
            // If the form contains error
            if (storeResult.hasErrors() || addressResult.hasErrors() || openingHoursResult.hasErrors()) {
                System.out.println("test : " + storeResult.hasErrors());
                System.out.println("test : " + addressResult.hasErrors());
                System.out.println("test : " + openingHoursResult.hasErrors());
                ModelAndView mav = new ModelAndView("editStore");
                mav.addObject("store", store);
                mav.addObject("address", address);
                mav.addObject("openingHours", openingHours);
                return mav;
            }

            store.setAddress(address);
            
            //I need to checks these value
            checkOpeningHours(openingHours);
            store.setOpeningHours(openingHours);
            
            //Check if a new keyStore has to be generated
            boolean key = false;
            if(store.getId() == 0) {
                key = true;
                store.setKeyStore("temp");
            } else {
                // An owner can modify only his stores
                if(userAccount.getType() != TypeEnum.Administrateur && store.getLastModifiedBy().getId() != userAccount.getId()) {
                    ModelAndView mav = new ModelAndView("accessDenied");
                    mav.addObject("errorMessage", "Vous n'avez pas les droits pour modifier un magasin ce magasin !");
                    return mav;
                }
            }
            
            store.setLastModificationDate(LocalDateTime.now());
            store.setLastModifiedBy(userAccount);

            store = storeManager.saveStore(store);
            store.setKeyStore("STORE-"+store.getId());
            store = storeManager.saveStore(store);

            return returnListStore(userAccount);
        } else if(storeId != null && action.equals("delete")) {
            
            // Modify an existing store
            if(storeId >= 0) {
                
                // Check if the user has the rights to modifiy the store
                if(userAccount.getType() == TypeEnum.Administrateur || userAccount.getId() == store.getLastModifiedBy().getId()) {
                    
                    storeManager.deleteStore(storeManager.getStoreById(storeId));
                    
                    /* /!\ Return to listView /!\ */
                    return returnListStore(userAccount);
                }else {
                    ModelAndView mav = new ModelAndView("accessDenied");
                    mav.addObject("errorMessage", "Vous ne pouvez pas supprimer un magasin qui ne vous appartient pas !");
                    return mav;
                }
            } else {
                ModelAndView mav = new ModelAndView("accessDenied");
                mav.addObject("errorMessage", "Vous essayer de modifier un magasin qui n'éxiste pas ou qui ne vous appartient pas !");
                return mav;
            }
        }
        ModelAndView mav = new ModelAndView("accessDenied");
        mav.addObject("errorMessage", "Un problème est survenu dans l'url !");
        return mav;
    }
    
    private OpeningHours checkOpeningHours(OpeningHours oh) {
        
        // All day
        if(oh.isMondayAllDay()) {
            oh.setMondayOpeningHour(LocalTime.of(0, 0));
            oh.setMondayClosingHour(LocalTime.of(23, 59));
        }
        if(oh.isTuesdayAllDay()) {
            oh.setTuesdayOpeningHour(LocalTime.of(0, 0));
            oh.setTuesdayClosingHour(LocalTime.of(23, 59));
        }
        if(oh.isWednesdayAllDay()) {
            oh.setWednesdayOpeningHour(LocalTime.of(0, 0));
            oh.setWednesdayClosingHour(LocalTime.of(23, 59));
        }
        if(oh.isThursdayAllDay()) {
            oh.setThursdayOpeningHour(LocalTime.of(0, 0));
            oh.setThursdayClosingHour(LocalTime.of(23, 59));
        }
        if(oh.isFridayAllDay()) {
            oh.setFridayOpeningHour(LocalTime.of(0, 0));
            oh.setFridayClosingHour(LocalTime.of(23, 59));
        }
        if(oh.isSaturdayAllDay()) {
            oh.setSaturdayOpeningHour(LocalTime.of(0, 0));
            oh.setSaturdayClosingHour(LocalTime.of(23, 59));
        }
        if(oh.isSundayAllDay()) {
            oh.setSundayOpeningHour(LocalTime.of(0, 0));
            oh.setSundayClosingHour(LocalTime.of(23, 59));
        }
        
        // Closed
        if(oh.isMondayClosed()) {
            oh.setMondayOpeningHour(LocalTime.of(0, 0));
            oh.setMondayClosingHour(LocalTime.of(0, 0));
        }
        if(oh.isTuesdayClosed()) {
            oh.setTuesdayOpeningHour(LocalTime.of(0, 0));
            oh.setTuesdayClosingHour(LocalTime.of(0, 0));
        }
        if(oh.isWednesdayClosed()) {
            oh.setWednesdayOpeningHour(LocalTime.of(0, 0));
            oh.setWednesdayClosingHour(LocalTime.of(0, 0));
        }
        if(oh.isThursdayClosed()) {
            oh.setThursdayOpeningHour(LocalTime.of(0, 0));
            oh.setThursdayClosingHour(LocalTime.of(0, 0));
        }
        if(oh.isFridayClosed()) {
            oh.setFridayOpeningHour(LocalTime.of(0, 0));
            oh.setFridayClosingHour(LocalTime.of(0, 0));
        }
        if(oh.isSaturdayClosed()) {
            oh.setSaturdayOpeningHour(LocalTime.of(0, 0));
            oh.setSaturdayClosingHour(LocalTime.of(0, 0));
        }
        if(oh.isSundayClosed()) {
            oh.setSundayOpeningHour(LocalTime.of(0, 0));
            oh.setSundayClosingHour(LocalTime.of(0, 0));
        }
        
        return oh;
    }
    
    public ModelAndView returnListStore(UserAccount userAccount) {
        // Check if user has rights
        if(userAccount == null) {
            ModelAndView mav = new ModelAndView("accessDenied");
            mav.addObject("errorMessage", "Vous devez vous connecter pour pouvoir avoir accès à cette page !");
            return mav;
        }

        ModelAndView mav = new ModelAndView("listStore");

        List<Store> stores = storeManager.getAllStore();
        List<Store> finalListStore = new ArrayList<Store>();

        for(Store s : stores) {
            if(s.getLastModifiedBy().getId() == userAccount.getId())
                finalListStore.add(s);
        }

        mav.addObject("stores", stores);
        return mav;
    }
    
}
