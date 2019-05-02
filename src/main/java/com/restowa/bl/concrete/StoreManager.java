/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.bl.concrete;

import com.restowa.domain.model.Store;
import com.restowa.domain.model.UserAccount;
import com.restowa.domain.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author yanis
 */
@Component
public class StoreManager {
    
    private StoreRepository repo;
    
    @Autowired
    public StoreManager(StoreRepository srepo) {
        this.repo = srepo;
    }
    
    public Store saveStore(Store store) {
        return this.repo.save(store);
    }
}
