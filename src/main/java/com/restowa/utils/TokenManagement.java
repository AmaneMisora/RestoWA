/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.utils;

import com.restowa.bl.concrete.UserAccountManager;
import java.time.LocalDateTime;
import java.util.UUID;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Paul
 */
public class TokenManagement {
    
    
    static public String generateToken(int userID){
        JSONObject token = new JSONObject();
        token.put("userID",userID);
        UUID uuid = UUID.randomUUID();
        String UUIDString = uuid.toString();
        token.put("uuid",UUIDString);
        LocalDateTime date = LocalDateTime.now().plusYears(1);
        token.put("dateExp",date);
        
        String bddToken = token.toString();
        // l'envoyer dans la bdd en l'encryptant
        return bddToken;
    }
    
    static public boolean verifyToken(String token, UserAccountManager uamanager) throws ParseException{
        //decrypte le token en argument
        JSONParser parser = new JSONParser(); 
        JSONObject JSONToken = (JSONObject) parser.parse(token);
        int idUser = (int)JSONToken.get("userID");
        String uuid = (String)JSONToken.get("uuid");
        LocalDateTime date = (LocalDateTime) JSONToken.get("dateExp");
        if(date.isBefore(LocalDateTime.now())){
            if(uamanager.getUserAccountById(idUser).getToken().equals(token)){
                return true;
            }else{
                return false;
            }
        } else{
            return false;
        }
        //Vérifie si le userID avec le uuid existent dans la BDD et la date n’est pas expirée
    }
}
