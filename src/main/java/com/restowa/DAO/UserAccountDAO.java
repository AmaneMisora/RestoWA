/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.DAO;

import com.restowa.DAO.MainDAO;
import com.restowa.domain.model.Address;
import com.restowa.domain.model.TypeEnum;
import com.restowa.domain.model.UserAccount;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Amane
 */
public class UserAccountDAO {
    
    /**
     * Instancie un Useraccount tout en le rendant persistant dans la base de données
     * @param em
     * @param name
     * @param lastname
     * @param email
     * @param password
     * @param phoneNumber
     * @param type
     * @param Street
     * @param City
     * @param State
     * @param ZipCode
     * @param Country
     * @return L'instance créée de Useraccount
     */
    public static UserAccount creatUserAccount(String firstname, String lastname, String email, String password, String phoneNumber, TypeEnum type, String Street, String City, String State, int ZipCode, String Country)
    {
        EntityManager em = MainDAO.getEntityManager();
        //instentiation
        UserAccount useraccount = new UserAccount();
        //parameres useraccount
        useraccount.setFirstName(firstname);
        useraccount.setLastName(lastname);
        useraccount.setEmail(email);
        useraccount.setPassword(password);
        useraccount.setPhoneNumber(phoneNumber);
        useraccount.setType(type);
        //instanstiation de l'adresse
        Address address = new Address();
        //aprametres Address
        address.setStreet(Street);
        address.setCity(City);
        address.setState(State);
        address.setCountry(Country);
        address.setZipCode(ZipCode);
        //ajout de l'adresse a useraccount
        //useraccount.setAddress(address);
		
	em.getTransaction().begin();
        em.persist(address);
        em.persist(useraccount);
	em.getTransaction().commit();
        
        return useraccount;
    }
    
    /*
    public static UserAccount GetUserByID(EntityManager em, int ID)
    {
        List<UserAccount> userToFind;
        Query query = em.createQuery("from UserAccount where id = userID").setParameter("UserID", ID);
        if(query.)
    }
    
    /**
     * vérifie un login et un password
     * @param em
     * @param email
     * @param password
     * @return true si le compte existe et le password correcpond
     */
    public static boolean checkLogin(String email, String password)
    {
        List<UserAccount> userToCheck;
        EntityManager em = MainDAO.getEntityManager();
        Query query = em.createQuery("from UserAccount where email = userEmail").setParameter("userEmail", email);
	if(query.getResultList().isEmpty())
            return false;
        else
        {
            userToCheck = query.getResultList();
            if(userToCheck.get(0).getPassword().equals(password))
                return true;    
        }
                
	return false;	
    }
    
    public static List<UserAccount> getUserAccountByEmail(String email) {
        EntityManager em = MainDAO.getEntityManager();
        Query query = em.createQuery("FROM UserAccount WHERE email = emailToCheck").setParameter("emailToCheck", email);
        return query.getResultList();
    }
    
    public static UserAccount saveUser(UserAccount ua) {
        EntityManager em = MainDAO.getEntityManager();
        
        em.getTransaction().begin();
        em.persist(ua);
	em.getTransaction().commit();
        
        return ua;
    }
    
    
    /*
     * Met à jour les parametres d'un UserAccount
     * (si un parametre n'est pas modifie, le mettre a null ou mettre son ancienne valeur ou une chaine vide)
     * @param useraccount
     * @param em
     * @param name
     * @param lastname
     * @param email
     * @param password
     * @param phoneNumber
     * @param type
     * @param Street
     * @param City
     * @param State
     * @param ZipCode
     * @param Country
     * @return la nouvelle instance de UserAccount
     */
    /*
    public static UserAccount modifyUserAccount(UserAccount useraccount, EntityManager em, String name, String lastname, String email, String password, String phoneNumber, TypeEnum type, String Street, String City, String State, int ZipCode, String Country)
    {
    }
    */
    
}
