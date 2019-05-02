/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restowa.bl.concrete.UserAccountManager;
import com.restowa.domain.model.Address;
import com.restowa.domain.model.TypeEnum;
import com.restowa.domain.model.UserAccount;
import com.restowa.utils.TokenManagement;
import java.util.List;
import javax.annotation.Resource;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Paul
 */
@RestController
@RequestMapping("/api/user")
public class UserService {
    
    @Resource
    UserAccountManager uamanager;
    
    
    public UserService(){    
    }
    
    
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public String register(@RequestBody String obj) throws ParseException { 
        JSONParser parser = new JSONParser(); 
        JSONObject json = (JSONObject) parser.parse(obj);
        Address address = new Address((String)json.get("Street"),(String)json.get("City"),(String)json.get("State"),(int)json.get("ZipCode"),(String)json.get("Country"));
        UserAccount useraccount = new UserAccount((String)json.get("firstname"),(String)json.get("lastname"),(String)json.get("email"),(String)json.get("password"),(String)json.get("phoneNumber"),(TypeEnum)json.get("type"),address);
        uamanager.saveUserAccount(useraccount);

        return "user created";
    }
    

    /* obj est un string de la forme d'un json
     */
    @RequestMapping(value = "/loginVerify", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public JSONObject verifyLogin(@RequestBody String obj) throws ParseException { 
        
        JSONParser parser = new JSONParser(); 
        JSONObject json = (JSONObject) parser.parse(obj);
        List<UserAccount> userList = uamanager.getUserAccountByEmail((String)json.get("email"));
        JSONObject resultLogin = new JSONObject();
        if (userList.isEmpty()){
            resultLogin.put("login", false);
        }else {
            if (userList.get(0).getPassword().equals((String)json.get("password"))){
                resultLogin.put("login", true); 
                String stringToken = TokenManagement.generateToken(userList.get(0).getId());
                //encripter le string
                String stringEncrypToken = stringToken;
                userList.get(0).setToken(stringEncrypToken);
                uamanager.saveUserAccount(userList.get(0));
            } else {
                resultLogin.put("login", false);
            }
        }
    
        return resultLogin;   
    }

    /* a besoin d'un json avec l'email de l'utilisateur et un token dans le header
     * verifie si le token est bon et si il est bon va chercher l'utilisateur avec la fonction getuserbyemail
     * puis met toutes les info de l'utilisateur dans un json que l'on renvoie
     */
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public JSONObject getUserInfo(@RequestBody String email, @RequestHeader HttpHeaders headers) throws JsonProcessingException, ParseException{ 
        JSONObject result = new JSONObject();
        if (!TokenManagement.verifyToken(headers.get("authentificationToken").get(0))) {
            result.put("result", "invalid token");
        } else {
            
            List<UserAccount> userList = uamanager.getUserAccountByEmail(email);
            if (userList.isEmpty()){
                result.put("result", "no user with this email");
            } else{
                ObjectMapper mapper = new ObjectMapper();
                String userInfo = mapper.writeValueAsString(userList.get(0));
                result.put("test", "hf");
                //JSONParser parser = new JSONParser(); 
                //result = (JSONObject) parser.parse(userInfo);
                
            //pas sur que le mapper marche quand on enregistre dans json object
            //si ça marche pas enregistrer dans un string puis le transformer en jsonobject avec un parser
            }  
        }
        
        return result;
    }
    
}

