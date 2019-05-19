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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * les différents services liés aux promotions
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
     * Renvoie toutes les promotions
     * @return JSONObject la liste des promotions sous la forme d'un jsonarray
     */
    @RequestMapping(value = "/getPromotions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public JSONObject getPromotions() {
        JSONObject JSONPromotions = new JSONObject();
        JSONArray JSArrayPromotions = new JSONArray();
        JSONObject promotion = new JSONObject(); 
        String StringPromotion;
        List<Promotion> promotionList = pmanager.getAllPromotions();
        // vérifie si il y a au moins une promotion
        if (promotionList.isEmpty()){
            // remplie un jsonarray avec chacune des promotions de la bdd
            for(int i=0; i<promotionList.size(); i++){ 
                promotion.put("key",promotionList.get(i).getKeyPromotion());
                promotion.put("title",promotionList.get(i).getTitle());
                promotion.put("shortDesc",promotionList.get(i).getShortDescription());
                promotion.put("longDesc",promotionList.get(i).getLongDescription());
                promotion.put("disabled",promotionList.get(i).isDisabled());
                promotion.put("startDate",promotionList.get(i).getStartDate().toString());
                promotion.put("endDate",promotionList.get(i).getEndDate().toString());
                promotion.put("imageURL",promotionList.get(i).getImageURL());

                JSArrayPromotions.add(promotion);
            }
            JSONPromotions.put("promotions",JSArrayPromotions);
        }else{
            JSONPromotions.put("result", "pas de promotions");
        }
        
        
        return JSONPromotions;
    }
    
    
    
}
