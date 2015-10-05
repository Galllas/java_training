package com.examples.store;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="JPA_DEPT")
public class Department {
	
	@Id
	@Column(name = "ID")
	int id;
	
	@Column(name = "NAME")
	String name;
	
	public Department(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Department() {
		
	}
	
	public Department(String name) {
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString(){
		return "Department "+id+": "+name;		
	}
	
	
	
	
	
	
	
	
	
	
	
}
