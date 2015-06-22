package com.king.entry;

import java.awt.Image;
import java.util.Date;

public class Book {
	protected String ISBN;
	protected String bookName;
	protected String author;
	protected String publisher;
	protected Date pTime;
	protected int editNum;
	protected float price;
	private int cNum;
	private int lNum;
	private int sNum;
	protected Date byeInTime;
	private String summary;
	private Image photo;

	public Book() {

	}

	public Book(String iSBN, String bookName, String author, String publisher,
			Date pTime, int editNum, float price, int cNum, int lNum, int sNum,
			Date byeInTime, String summary, Image photo) {
		super();
		ISBN = iSBN;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.pTime = pTime;
		this.editNum = editNum;
		this.price = price;
		this.cNum = cNum;
		this.lNum = lNum;
		this.sNum = sNum;
		this.byeInTime = byeInTime;
		this.summary = summary;
		this.photo = photo;
	}
	

	@Override
	public String toString() {
		return "图书：《" + bookName + "》  作者：" + author
				+ " 图书出版社：" + publisher +" 可借阅量："+sNum+"本";
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getpTime() {
		return pTime;
	}

	public void setpTime(Date pTime) {
		this.pTime = pTime;
	}

	public int getEditNum() {
		return editNum;
	}

	public void setEditNum(int editNum) {
		this.editNum = editNum;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getcNum() {
		return cNum;
	}

	public void setcNum(int cNum) {
		this.cNum = cNum;
	}

	public int getlNum() {
		return lNum;
	}

	public void setlNum(int lNum) {
		this.lNum = lNum;
	}

	public int getsNum() {
		return sNum;
	}

	public void setsNum(int sNum) {
		this.sNum = sNum;
	}

	public Date getByeInTime() {
		return byeInTime;
	}

	public void setByeInTime(Date byeInTime) {
		this.byeInTime = byeInTime;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Image getPhoto() {
		return photo;
	}

	public void setPhoto(Image photo) {
		this.photo = photo;
	}
}
