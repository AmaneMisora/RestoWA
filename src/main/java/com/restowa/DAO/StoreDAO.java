/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.DAO;

import com.restowa.domain.model.Store;
import com.restowa.domain.model.UserAccount;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author yanis
 */
public class StoreDAO {
    
    public static Store saveStore(Store store) {
        EntityManager em = MainDAO.getEntityManager();
        
        em.getTransaction().begin();
        em.persist(store);
	em.getTransaction().commit();
        
        return store;
    }
    
    public static List<Store> getStoreById(int id) {
        EntityManager em = MainDAO.getEntityManager();
        Query query = em.createQuery("FROM Store WHERE id = idToCheck").setParameter("idToCheck", id);
        return query.getResultList();
    }
    
}
