/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.restowa.bl.concrete.UserAccountManager;
import com.restowa.domain.model.Address;
import com.restowa.domain.model.TypeEnum;
import com.restowa.domain.model.UserAccount;
import com.restowa.utils.JWTTokenManager;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ws.rs.core.MediaType;
import org.jose4j.lang.JoseException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * les différents services liés aux utilisateurs
 * @author Paul
 */
@RestController
@RequestMapping("/api/user")
public class UserService {
    
    @Resource
    UserAccountManager uamanager;
    
    public UserService(){    
    }
    
    /**
     * créer un compte a partir d'un json et le rajoute dans la bdd
     * @param userInfo les différentes informations nécessaire afin de créer un compte sous la forme d'un json
     * @return le string "user created" si la creation de l'utilisateur a bien été faite
     * @throws ParseException 
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public String register(@RequestBody String userInfo) throws ParseException { 
        
        // parse le string userInfo en json
        JSONParser parser = new JSONParser(); 
        JSONObject json = (JSONObject) parser.parse(userInfo);
        
        // créer l'adresse puis le user à partir de ces infos
        Address address = new Address();
        address.setStreet((String)json.get("Street"));
        address.setCity((String)json.get("City"));
        address.setState((String)json.get("State"));
        address.setZipCode(Integer.parseInt((String)json.get("ZipCode")));
        address.setCountry((String)json.get("Country"));
        UserAccount useraccount = new UserAccount();
        useraccount.setFirstName((String)json.get("firstname"));
        useraccount.setLastName((String)json.get("lastname"));
        useraccount.setEmail((String)json.get("email"));
        useraccount.setPassword((String)json.get("password"));
        useraccount.setPhoneNumber((String)json.get("phoneNumber"));
        useraccount.setType(TypeEnum.valueOf((String)json.get("type")));
        useraccount.setAddress(address);
        
        // save les changement dans la bdd
        uamanager.saveUserAccount(useraccount);
        return "user created";
    }
    

    /**
     * permet la connection grâce au information de l'utilisateur et renvoie le token de cet utilisateur
     * @param form  String contenant l'email et le passord de l'utilisateur sous la forme d'un json
     * @return un jsonobject qui indique si la connection est réussite et renvoie le token de l'user sinon renvoie un json avec "login" : false
     * @throws ParseException 
     */
    @RequestMapping(value = "/loginVerify", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public JSONObject verifyLogin(@RequestBody String form) throws ParseException { 
        
        // parse le string form en json
        JSONParser parser = new JSONParser(); 
        JSONObject json = (JSONObject) parser.parse(form);
        
        // trouve l'utilisateur concerné par la connection
        List<UserAccount> userList = uamanager.getUserAccountByEmail((String)json.get("email"));
        JSONObject resultLogin = new JSONObject();
        
        // vérifie si il existe
        if (userList.isEmpty()){
            resultLogin.put("login", false);
        }else {
            
            // vérifie son mot de passe 
            if (userList.get(0).getPassword().equals((String)json.get("password"))){
                resultLogin.put("login", true); 
                String stringToken = "";
                
                //créer son token et le save dans la bdd sur le compte concerné
                try {
                    stringToken = JWTTokenManager.getInstance().generateToken(userList.get(0).getId());
                } catch (JoseException ex) {
                    Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
                }
                resultLogin.put("token", stringToken);                 
                userList.get(0).setToken(stringToken);
                uamanager.saveUserAccount(userList.get(0));
            } else {
                resultLogin.put("login", false);
            }
        }
    
        return resultLogin;   
    }

 
    /**
     * Récupere les informations du client demandé
     * mais vérifie avant si le token dans le header est valide et est bien le token de l'utilisateur concerné
     * @param stringUserId String, l'id de l'utilisateur recherché
     * @param headers contient le token encrypté nécessaire pour avoir les informations sur cet utilisateur
     * @return un json avec les informations sur cet user ou "result" : "no user with this id" ou un json détaillant pourquoi le token n'est pas bon
     * @throws JsonProcessingException
     * @throws ParseException 
     */
    @GetMapping(value = "/getUserInfo/{stringUserId}", produces = MediaType.APPLICATION_JSON)
    public JSONObject getUserInfo(@PathVariable("stringUserId") String stringUserId, @RequestHeader HttpHeaders headers) throws JsonProcessingException, ParseException{ 
        int id = Integer.parseInt(stringUserId);
        JSONObject result = new JSONObject();
        UserAccount user;
        // le try catch lorsqu'il n'y a pas d'utilisateur lié à cet id
        try{
            // récupere les 2 token (celui du header et celui de la bdd) et les vérifient
            user = uamanager.getUserAccountById(id);
            String headerToken = headers.get("authentificationToken").get(0); 
            String userToken = user.getToken();
            String resultVerifyToken = JWTTokenManager.getInstance().verifyToken(headerToken , userToken);
            if (resultVerifyToken.startsWith("Token validation succeeded! ")){ 
                // si la vérification est bonne écrit les informations de l'utilisateur dans le json que l'on va return
                result.put("id",user.getId());
                result.put("firstName",user.getFirstName());
                result.put("lastName",user.getLastName());
                result.put("email",user.getEmail());
                result.put("phone number",user.getPhoneNumber());
                result.put("creation date",user.getCreationDate().toString());
                result.put("type",user.getType());
                JSONObject adresse = new JSONObject();
                adresse.put("city",user.getAddress().getCity());
                adresse.put("country",user.getAddress().getCountry());
                adresse.put("state",user.getAddress().getState());
                adresse.put("zip code",user.getAddress().getZipCode());
                result.put("adresse",adresse);  
            } else {         
                // ecrit un json détaillant pourquoi le token n'est pas bon
                result.put("result", resultVerifyToken);
            } 
        } catch (Exception e){
            result.put("result", "no user with this id");
        }
 
        return result;
    }
    
}

