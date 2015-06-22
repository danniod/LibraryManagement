package com.king.entry;

/**
 * 文件: User.java 用户类的父类
 * 
 * @author LenDon
 */
public class User {

	protected int id;
	protected String userName;
	protected String password;
	protected String name;
	protected long tel;
	private int role;
	
	public User() {
		
	}

	public int getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password="
				+ password + ", name=" + name + ", tel=" + tel + ", role="
				+ role + "]";
	}

	public void setRole(int role) {
		this.role = role;
	}

	public User(int id, String userName, String password, String name, long tel) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.tel = tel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getTel() {
		return tel;
	}

	public void setTel(long tel) {
		this.tel = tel;
	}

}
