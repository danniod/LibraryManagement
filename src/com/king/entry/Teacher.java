package com.king.entry;

import java.util.Date;

public class Teacher extends Reader {

	private String name;
	private byte sex;
	private String spec;
	private long tel;
	private Date birthday;

	public Teacher() {
	}
	
	public Teacher(int id, String userName, String password, String name, byte sex,
			String spec, Date birthday, long tel,int count) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.spec = spec;
		this.birthday = birthday;
		this.tel = tel;
		this.count = count;
	}



	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public byte getSex() {
		return sex;
	}

	public void setGender(byte sex) {
		this.sex = sex;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
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

	public void setSex(byte sex) {
		this.sex = sex;
	}

	public String showMsg() {
		return "Teacher [name=" + name + ", sex=" + sex + ", spec=" + spec
				+ ", tel=" + tel + ", birthday=" + birthday + "]";
	}

}
