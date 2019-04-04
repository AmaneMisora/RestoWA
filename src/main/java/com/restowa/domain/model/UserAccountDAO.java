/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.domain.model;

import javax.persistence.EntityManager;

/**
 *
 * @author Amane
 */
public class UserAccountDAO {
    
    public static UserAccount creatUserAccount(EntityManager em, String name, String lastname, String email, String password, String phoneNumber, TypeEnum type, String Street, String City, String State, int ZipCode, String Country)
    {
        //instentiation
        UserAccount useraccount = new UserAccount();
        //parameres useraccount
        useraccount.setName(name);
        useraccount.setLastname(lastname);
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
        useraccount.setAddress(address);
		
	em.getTransaction().begin();
        em.persist(useraccount);
	em.getTransaction().commit();
        
        return useraccount;
    }
}
