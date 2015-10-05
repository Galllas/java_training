package com.examples.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.examples.store.Department;
import com.examples.store.Product;

public class DepartmentRAMDAO implements Storage<Department> {
	
	EntityManagerFactory emf;
	EntityManager em;

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void create(Department t) {
		
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}
	
	@Override
	public Department read(int id) {

		em = emf.createEntityManager();
		Department department = em.find(Department.class, id);
		em.close();
		return department;
	}
	
	@Override
	public void update(Department t) {
		
		em = emf.createEntityManager();
		Department department = em.find(Department.class, t.getID());
		em.getTransaction().begin();
		department.setName(t.getName());
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(Department t) {
		
		em = emf.createEntityManager();
		Department department = em.find(Department.class, t.getID());
		em.getTransaction().begin();
		em.remove(department);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Department> read() {
		
		em = emf.createEntityManager();
		List<Department> departments = null;	
		Query query = em.createNativeQuery(
				"SELECT * FROM JPA_DEPT", Department.class);
		departments = (List<Department>) query.getResultList();
		em.close();
		return departments;
	}

}
