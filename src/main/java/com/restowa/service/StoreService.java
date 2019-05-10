/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restowa.bl.concrete.StoreManager;
import com.restowa.domain.model.Store;
import java.util.List;
import javax.annotation.Resource;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestBody;
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
    public JSONObject getStoreInfo(@RequestBody String stringStoreId) throws JsonProcessingException, ParseException{
        JSONObject result = new JSONObject();
        int storeId = Integer.parseInt(stringStoreId);
        Store store = null;
        try{
            store = smanager.getStoreById(storeId); //verifier si il trouve pas de magasin avec cette (if (store==null))
            result.put("id",store.getId());
            String keyStore = store.getKeyStore() ;
            if(keyStore != null){
                result.put("key",keyStore);
            } 
            result.put("email",store.getEmail());
            result.put("phone number",store.getPhoneNumber());
            Double lattitudeStore = store.getLattitude();
            if(lattitudeStore != null){
                result.put("lattitude",store.getLattitude());
            }
            Double longitudeStore = store.getLongitude();
            if(longitudeStore != null){
                result.put("longitude",store.getLongitude());
            }
            if(store.getAddress() != null){
                JSONObject adresse = new JSONObject();
                adresse.put("city",store.getAddress().getCity());
                adresse.put("country",store.getAddress().getCountry());
                adresse.put("state",store.getAddress().getState());
                adresse.put("zip code",store.getAddress().getZipCode());
                result.put("adresse",adresse);
            }
        } catch (Exception e){
            result.put("result", "no store with this id");
        }
        return result;
    }
    
}
