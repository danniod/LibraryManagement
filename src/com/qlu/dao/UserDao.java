package com.qlu.dao;

import java.util.List;

public interface UserDao<T> {

	public int delete(T t);
	
	public int update(T t);
	
	public int save(T t);
	
	public T findById(Integer id);
	
	public List<T> findAll();
}
