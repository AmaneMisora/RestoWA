package com.restowa.DAO;

import javax.persistence.*;
import javax.persistence.EntityManagerFactory;

public class MainDAO {

	private static MainDAO currentInstance;
	
	private static EntityManager entityManager;
	
	private MainDAO() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("model");
		entityManager = factory.createEntityManager();
	}
	
	public static MainDAO getInstance() {
		if (currentInstance == null)
			currentInstance = new MainDAO();
		
		return currentInstance;
	}
	
	public static EntityManager getEntityManager() {
		return entityManager;
	}
}