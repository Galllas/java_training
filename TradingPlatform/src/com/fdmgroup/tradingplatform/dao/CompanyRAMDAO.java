package com.fdmgroup.tradingplatform.dao;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.fdmgroup.tradingplatform.bin.Company;

public class CompanyRAMDAO implements IStoreable<Company> {

	private Set<Company> companySet;
	
	EntityManagerFactory emf;
	EntityManager em;

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public void create(Company t) {
		
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Company read(int id) {
		
		em = emf.createEntityManager();
		Company company = em.find(Company.class, id);
		em.close();
		return company;
	}

	@Override
	public void update(Company t) {
		
		em = emf.createEntityManager();
		Company company = em.find(Company.class, t.getCompanyId());
		em.getTransaction().begin();
		em.remove(company);
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(Company t) {
		
		em = emf.createEntityManager();
		Company company = em.find(Company.class, t.getCompanyId());
		em.getTransaction().begin();
		em.remove(company);
		em.getTransaction().commit();	
		em.close();
	}

}
