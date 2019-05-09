
package com.restowa.controllers;

import com.restowa.bl.concrete.UserAccountManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController {

    private static final Logger LOGGER = Logger.getLogger(DefaultController.class.getName());
    
    @Resource
    UserAccountManager uamanager;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap map) {
        LOGGER.log(Level.INFO, "Start DefaultController (index)");
        LOGGER.log(Level.INFO, "End DefaultController");
        return "index";
    }
    
    public void initDb()
    {
        UserAccount useraccount;
        Store store;
        Address address;
        OpeningHours openinghour;
        
        address = new Address("Street","City","State",12345,"Country");
        useraccount = new UserAccount("Client1","lastname","email","password","phoneNumber",TypeEnum.Client,address);
        uamanager.saveUserAccount(useraccount);
        useraccount = new UserAccount("Client2","lastname","email","password","phoneNumber",TypeEnum.Client,address);
        uamanager.saveUserAccount(useraccount);
        useraccount = new UserAccount("Amin1","lastname","email","password","phoneNumber",TypeEnum.Administrateur,address);
        uamanager.saveUserAccount(useraccount);
        useraccount = new UserAccount("Owner1","lastname","email","password","phoneNumber",TypeEnum.Owner,address);
        uamanager.saveUserAccount(useraccount);
        useraccount = new UserAccount("Owner2","lastname","email","password","phoneNumber",TypeEnum.Owner,address);
        uamanager.saveUserAccount(useraccount);
        
        /*
        store = new Store();
        store.setAddress(address);
        store.setId(0);
        store.setEmail("email");
        store.setKeyStore("keyStore");
        store.setLastModificationDate(LocalDateTime.MIN);
        store.setLastModifiedBy(useraccount);
        store.setLattitude(0.0);
        store.setLongitude(0.0);
        store.setName("name");
        store.setOpeningHours(openingHours);
*/

    }
}
