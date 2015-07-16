package com.king.entry;

import java.util.Date;

public class Stu extends Reader {

	private Date birthday;
	private byte sex;
	private String spec;
	private String name;
	private long tel;

	public Stu() {
	}

	public Stu(int id, String userName, String password, String name, byte sex,
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
		return "birthday: " + birthday + "\n性别： " + sex + ", spec=" + spec
				+ "\n姓名：" + name + ", tel=" + tel;
	}

}
