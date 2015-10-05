package com.examples.dao;

import java.util.List;

public interface Storage<T>{

	public void create(T t);
	public T read(int id);
	public List<T> read();
	public void update(T t);
	public void delete(T t);
	
}
