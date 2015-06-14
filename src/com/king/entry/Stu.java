package com.king.entry;

import java.util.Date;

public class Stu extends Reader {

	private Date birthday;
	private byte sex;
	private String spec;

	public Stu() {
	}

	public Stu(int id, String userName, String password, String name, byte sex,
			String spec, Date birthday, long tel) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.spec = spec;
		this.birthday = birthday;
		this.tel = tel;
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

	public void setSex(byte sex) {
		this.sex = sex;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}
	
	
	
}
