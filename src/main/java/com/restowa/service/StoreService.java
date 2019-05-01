/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.service;

import javax.ws.rs.core.MediaType;
import org.json.simple.JSONObject;
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
    
    public StoreService(){    
    }
    
    @RequestMapping(value = "/getStoreInfo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public JSONObject getStoreInfo(int storeId){
        
        //Store store = getStoreById(storeId);
        
        JSONObject storeInfo = new JSONObject();
        
        
        return storeInfo;
    }
    
}
