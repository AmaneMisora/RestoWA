/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.domain.repository;

import com.restowa.domain.model.Store;
import com.restowa.domain.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author yanis
 */
public interface StoreRepository extends JpaRepository<Store, Integer>{
    
}
