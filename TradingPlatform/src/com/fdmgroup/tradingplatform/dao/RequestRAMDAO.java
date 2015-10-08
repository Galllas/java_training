package com.fdmgroup.tradingplatform.dao;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.fdmgroup.tradingplatform.bin.Person;
import com.fdmgroup.tradingplatform.bin.Request;

public class RequestRAMDAO implements IStoreable<Request> {

	private Set<Request> requestSet;
	
	EntityManagerFactory emf;
	EntityManager em;

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public void create(Request t) {
		
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Request read(int id) {
		
		em = emf.createEntityManager();
		Request request = em.find(Request.class, id);
		em.close();
		return request;
	}

	@Override
	public void update(Request t) {
		
		em = emf.createEntityManager();
		Request request = em.find(Request.class, t.getRequestId());
		em.getTransaction().begin();
		em.remove(request);
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(Request t) {
		
		em = emf.createEntityManager();
		Request request = em.find(Request.class, t.getRequestId());
		em.getTransaction().begin();
		em.remove(request);
		em.getTransaction().commit();	
		em.close();
	}

}
