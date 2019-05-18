/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.restowa.bl.concrete.StoreManager;
import com.restowa.domain.model.Store;
import javax.annotation.Resource;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * les différents services liés aux boutiques
 * @author Paul
 */
@RestController
@RequestMapping("/api/store")
public class StoreService {
    
    @Resource
    StoreManager smanager;
    
    public StoreService(){    
    }
    
    /**
     * Récupere les informations de la boutique demandée
     * @param stringStoreId String, l'id de la boutique recherchée
     * @return un json avec les informations sur cet user ou "result" : "no store with this id"
     * @throws JsonProcessingException
     * @throws ParseException 
     */
    @GetMapping(value = "/getStoreInfo/{stringStoreId}", produces = MediaType.APPLICATION_JSON)
    public JSONObject getStoreInfo(@PathVariable("stringStoreId") String stringStoreId) throws JsonProcessingException, ParseException{
        JSONObject result = new JSONObject();
        int storeId = Integer.parseInt(stringStoreId);
        Store store;
        
        // le try catch lorsqu'il n'y a pas de boutique liée à cet id
        try{
            // si la boutique existe écrit les informations de la boutique dans le json que l'on va return
            store = smanager.getStoreById(storeId); 
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
