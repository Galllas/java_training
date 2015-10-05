package com.examples.test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.examples.dao.DepartmentRAMDAO;
import com.examples.dao.ProductRAMDAO;
import com.examples.store.Department;
import com.examples.store.Product;

import static org.mockito.Mockito.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestJPA {
	
	EntityManagerFactory emf;
	EntityManager emd, emp;
	Department department;
	Product product;
	DepartmentRAMDAO departmentDAO;
	ProductRAMDAO productDAO;
	
	@Test
	public void test() {
		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("storejpa");
		
		DepartmentRAMDAO departmentDAO = new DepartmentRAMDAO();
		ProductRAMDAO productDAO = new ProductRAMDAO();
		departmentDAO.setEmf(emf);
		productDAO.setEmf(emf);
		
		department = new Department(1, "Drink");
		product = new Product(1, "Apple", 20, 10, department);
		
		departmentDAO.create(department);
		productDAO.create(product);
		
		assertEquals(departmentDAO.read(1).getName(), "Drink");
		assertEquals(productDAO.read(1).getDept().getID(), 1);

		departmentDAO.update(new Department(1, "Drink Soft"));
		productDAO.update(new Product(1, "Apple Juice", 10, 10, department));
		
		assertEquals(departmentDAO.read(1).getName(), "Drink Soft");
		assertEquals(productDAO.read(1).getItemName(), "Apple Juice");
	
		productDAO.delete(new Product(1, "Apple Juice", 10, 10, department));
		departmentDAO.delete(new Department(1, "Drink Soft"));

		assertEquals(departmentDAO.read().size(), 0);
		assertEquals(productDAO.read().size(), 0);
	
		emf.close();
				
	}

}
