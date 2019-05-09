/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.bl.concrete;

import com.restowa.domain.model.Promotion;
import com.restowa.domain.repository.PromotionRepository;

/**
 *
 * @author Amane
 */
public class PromotionManager {

    private PromotionRepository repo;
    
    public PromotionManager(PromotionRepository repo)
    {
        this.repo  = repo;
    }
    
}
