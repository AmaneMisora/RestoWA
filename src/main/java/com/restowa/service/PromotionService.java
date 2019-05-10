/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restowa.bl.concrete.PromotionManager;
import com.restowa.domain.model.Promotion;
import java.util.List;
import javax.annotation.Resource;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
    
    @Resource
    PromotionManager pmanager;
    
    public PromotionService(){
        
    }
    
    /**
     * 
     * @return JSONObject la liste des promotions
     */
    @RequestMapping(value = "/getPromotions", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public JSONObject getPromotions() throws ParseException, JsonProcessingException{
        JSONObject JSONPromotions = new JSONObject();
        JSONArray JSArrayPromotions = new JSONArray();
        JSONObject promotion = new JSONObject(); 
        String StringPromotion;
        List<Promotion> promotionList = pmanager.getAllPromotions();
        
        for(int i=0; i<promotionList.size(); i++){ 
            //verifier si ils sont nul
            promotion.put("id",promotionList.get(i).getId());
            promotion.put("key",promotionList.get(i).getKey());
            promotion.put("title",promotionList.get(i).getTitle());
            promotion.put("shortDesc",promotionList.get(i).getShortDescription());
            promotion.put("longDesc",promotionList.get(i).getLongDescription());
            promotion.put("disabled",promotionList.get(i).getDisabled());
            promotion.put("startDate",promotionList.get(i).getStartDate());
            promotion.put("endDate",promotionList.get(i).getEndDate());
            promotion.put("imageURL",promotionList.get(i).getImageURL());
            
            JSArrayPromotions.set(i, promotion);
        }
        JSONPromotions.put("promotions",JSArrayPromotions);
        
        return JSONPromotions;
    }
    
    
    
}
