/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.DAO;

import com.restowa.domain.model.Promotion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Amane
 */
public class PromotionDAO {
    
    public static List<Promotion> getAllPromotions() {
        EntityManager em = MainDAO.getEntityManager();
        Query query = em.createQuery("FROM Promotion");
        return query.getResultList();
    }
    
}
