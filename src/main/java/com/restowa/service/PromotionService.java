/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.annotation.Resource;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Paul
 */
@RestController
@RequestMapping("/api/promotion")
public class PromotionService {
    
    //@Resource
    //PromotionManager pmanager;
    
    public PromotionService(){
        
    }
    
    /**
     * 
     * @return JSONObject la liste des promotions
     */
    @RequestMapping(value = "/getPromotions", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public JSONObject getPromotions(){
        JSONObject JSONPromotions = new JSONObject();
        JSONArray JSArrayPromotions = new JSONArray();
        JSONObject promotion = new JSONObject(); /*
        String StringPromotion;
        List<Promotion> promotionList = pmanager.getAll();
        
        for(int i=0; i<promotionsList.size(); i++){ 
            //mapper pour tranformer la promotion i en string puis parser pour la tranformer en jsonobject puis l'ajouter a l'array
            ObjectMapper mapper = new ObjectMapper(); // peut etre déclarer les mapper en dehors de la boucle
            StringPromotion = mapper.writeValueAsString(promotionList.get(i));
            JSONParser parser = new JSONParser(); 
            promotion = (JSONObject) parser.parse(StringPromotion);
            
            JSArrayPromotions.set(i, promotion);
        }
        JSONPromotions.setJSONArray("promotions",JSArrayPromotions);
        */
        return JSONPromotions;
    }
    
    
    
}
