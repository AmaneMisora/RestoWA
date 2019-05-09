/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.bl.concrete;

import com.restowa.domain.model.Store;
import com.restowa.domain.repository.StoreRepository;
import java.util.List;
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
        return this.repo.saveAndFlush(store);
    }
    
    public Store getStoreById(int id) {
        return this.repo.findById(id).get();
    }
    
    public List<Store> getAllStore() {
        return this.repo.findAll();
    }
    
    public void deleteStore(Store store) {
        this.repo.delete(store);
    }
}
