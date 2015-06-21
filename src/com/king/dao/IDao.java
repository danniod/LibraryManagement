package com.king.dao;

import java.util.List;

public interface IDao<T> {
	
	//增
	public int insert(T t);
	
	//删
	public int delete(T t);
	
	//改
	public int update(T t);
	
	//查
	public T findById(Integer id);
	
	public List<T> findAll();
}
