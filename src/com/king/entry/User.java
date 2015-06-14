package com.king.entry;
/**
 * 文件: User.java
 * 用户类的父类
 * @author LenDon
 */
public class User {

	protected String userName;
	protected int id;
	protected String name;
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
