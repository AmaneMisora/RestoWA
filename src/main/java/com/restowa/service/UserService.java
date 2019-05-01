/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.service;


import com.fasterxml.jackson.databind.ObjectMapper;
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
@RequestMapping("/api/user")
public class UserService {
    
   // @Resource
    //UserAccountManager uamanager;
    
    
    public UserService(){    
    }
    
    
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public void register(@RequestBody String obj) { 
        
        //je le creer et je le met dans la bdd ou je le renvoie ou les 2 ?
    }
    

    /* utiliser postam pour tester le login
     * obj est un string de la forme d'un json
     * HttpStatus.OK; renvoie si bon
     * HttpStatus.404 si mauvais etc
     */
    @RequestMapping(value = "/loginVerify", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public JSONObject verifyLogin(@RequestBody String obj) throws ParseException { 
        
        JSONParser parser = new JSONParser(); 
        JSONObject json = (JSONObject) parser.parse(obj);
        String email = (String) json.get("email");
        String password = (String) json.get("password");
        boolean result = true;// = CheckLogin(email,password); //utiliser la classe de lucie pour verifier ;
         
        JSONObject resultLogin = new JSONObject();
        resultLogin.put("login", result);
        
        //JWToken pour gere les token et voir si cest toujours le meme utilisateur qui se connecte
            
        
        return resultLogin;   //retourner un string en fonction du résultat de la classe de lucie 
                        //HttpStatus.BAD_REQUEST;
    }

    /* a besoin d'un json avec l'id de l'utilisateur et un JWToken dans le header
     * verifie si le token est bon et si il est bon va chercher l'utilisateur avec la fonction de lucie getuserbyid
     * puis met toutes les info de l'utilisateur dans un json que l'on renvoie
     */
    //@JWTTokenNeeded
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public JSONObject getUserInfo(@RequestBody int userId){ 
    
 
        //UserAccount user = UserAccountDAO.getUserById(userId);
        
        ObjectMapper mapper = new ObjectMapper();
        
        JSONObject userInfo = new JSONObject();
        //JSONObject userInfo = mapper.writeValueAsString(user);
        //pas sur que le mapper marche quand on enregistre dans json object
        //si ça marche pas enregistrer dans un string puis le transformer en jsonobject avec un parser
        return userInfo;
    }
    
}

