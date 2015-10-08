package com.fdmgroup.tradingplatform.dao;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.fdmgroup.tradingplatform.bin.Request;
import com.fdmgroup.tradingplatform.bin.Trade;

public class TradeRAMDAO implements IStoreable<Trade> {

	private Set<Trade> tradeSet;
	
	EntityManagerFactory emf;
	EntityManager em;

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public void create(Trade t) {

		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Trade read(int id) {
		
		em = emf.createEntityManager();
		Trade trade = em.find(Trade.class, id);
		em.close();
		return trade;
	}

	@Override
	public void update(Trade t) {
		
		em = emf.createEntityManager();
		Trade trade = em.find(Trade.class, t.getTradeId());
		em.getTransaction().begin();
		em.remove(trade);
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(Trade t) {
		
		em = emf.createEntityManager();
		Trade trade = em.find(Trade.class, t.getTradeId());
		em.getTransaction().begin();
		em.remove(trade);
		em.getTransaction().commit();	
		em.close();
	}

}
