
package com.restowa.controllers;

import com.restowa.DAO.UserAccountDAO;
import com.restowa.bl.concrete.UserAccountManager;
import com.restowa.domain.model.Address;
import com.restowa.domain.model.OpeningHours;
import com.restowa.domain.model.Store;
import com.restowa.domain.model.TypeEnum;
import com.restowa.domain.model.UserAccount;
import java.time.LocalDateTime;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController {

//    @Resource
//    UserAccountRepository repo;
    
    @Resource
    UserAccountManager uamanager;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    //@Transactional
    public String index(ModelMap map) {
        UserAccount ua = new UserAccount();
        //uamanager.saveUserAccount(ua);
        //UserAccount ua = repo.findById(1).get();
        /*
        UserAccount ua = uamanager.getUserAccountById(1);
        
        map.put("msg", "Hello Spring 5 Web MVC!");
        map.put("userId", ua.getID());
        map.put("userName", ua.getName());
*/
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
