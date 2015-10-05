package com.examples.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.examples.store.Department;
import com.examples.store.Product;

public class ProductRAMDAO implements Storage<Product> {

	EntityManagerFactory emf;
	EntityManager em;

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public void create(Product t) {

		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Product read(int id) {
		
		em = emf.createEntityManager();
		Product product = em.find(Product.class, id);
		em.close();
		return product;
	}

	@Override
	public void update(Product t) {
		
		em = emf.createEntityManager();
		Product product = em.find(Product.class, t.getItemID());
		em.getTransaction().begin();
		em.remove(product);
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(Product t) {
		
		em = emf.createEntityManager();
		Product product = em.find(Product.class, t.getItemID());
		em.getTransaction().begin();
		em.remove(product);
		em.getTransaction().commit();	
		em.close();
	}

	@Override
	public List<Product> read() {
		
		em = emf.createEntityManager();
		List<Product> products = null;	
		Query query = em.createNativeQuery(
				"SELECT * FROM JPA_PRODUCT", Product.class);
		products = (List<Product>) query.getResultList();
		em.close();
		return products;
	}

}
