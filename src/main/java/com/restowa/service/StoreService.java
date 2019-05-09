/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restowa.bl.concrete.StoreManager;
import com.restowa.domain.model.Store;
import java.util.List;
import javax.annotation.Resource;
import javax.ws.rs.core.MediaType;
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
@RequestMapping("/api/store")
public class StoreService {
    
    @Resource
    StoreManager smanager;
    
    public StoreService(){    
    }
    
    @RequestMapping(value = "/getStoreInfo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public JSONObject getStoreInfo(int storeId){
        
        JSONObject JSONStoreInfo = new JSONObject();
      /*  Store store = smanager.getStoreById(storeId); //verifier si il trouve pas de magasin avec cette (if (store==null))
        
        ObjectMapper mapper = new ObjectMapper(); // ça marche pas jattend store de yanis 
        String storeInfo = mapper.writeValueAsString(store);
        JSONParser parser = new JSONParser(); 
        JSONStoreInfo = (JSONObject) parser.parse(storeInfo);*/
        return JSONStoreInfo;
    }
    
}
