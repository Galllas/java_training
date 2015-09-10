package com.fdmgroup.dao;

public interface IStoreable<T> {

	void create(T t);
	T read (int id);
	void update(T t);
	void delete(T t);
	
}
