
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
}
