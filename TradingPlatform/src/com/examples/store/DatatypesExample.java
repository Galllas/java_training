package com.examples.store;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatatypesExample {

	public static void main(String[] args){
		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("storejpa");
			
		EntityManager em = emf.createEntityManager();
		
		DataTypes dataTypes = new DataTypes();

		em.getTransaction().begin();
		em.persist(dataTypes);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
	}
}
