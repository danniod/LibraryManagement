package com.king.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.king.entry.Book;
import com.king.util.jdbcUtil;

public class BookDaoImpl implements IDao<Book> {

	@Override
	public int insert(Book t) {

		Connection conn = jdbcUtil.getConnection();
		String sql = "insert into book values(?,?,?,?,?,?,?,?,?,?,?,?,null)";
		PreparedStatement ps = null;
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, t.getISBN());
			ps.setString(2, t.getBookName());
			ps.setString(3, t.getAuthor());
			ps.setString(4, t.getPublisher());
			ps.setDate(5, new java.sql.Date(t.getpTime().getTime()));
			ps.setInt(6, t.getEditNum());
			ps.setFloat(7, t.getPrice());
			ps.setInt(8, t.getcNum());
			ps.setInt(9, t.getlNum());
			ps.setInt(10, t.getsNum());
			ps.setDate(11, new java.sql.Date(t.getByeInTime().getTime()));
			ps.setString(12, t.getSummary());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.freeAll(conn, ps);
		}
		return result;
	}

	@Override
	public int delete(Book t) {
		return 0;
	}

	@Override
	public int update(Book t) {
		return 0;
	}

	@Override
	public Book findById(Integer id) {
		Connection conn = jdbcUtil.getConnection();
		String sql = "select * from book  where bookid"+ id;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Book book = new Book();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				book.setISBN(rs.getString(1));
				book.setBookName(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPublisher(rs.getString(4));
				book.setpTime(rs.getDate(5));
				book.setEditNum(rs.getInt(6));
				book.setPrice(rs.getFloat(7));
				book.setcNum(rs.getInt(8));
				book.setlNum(rs.getInt(9));
				book.setsNum(rs.getInt(10));
				book.setByeInTime(rs.getDate(11));
				book.setSummary(rs.getString(12));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public List<Book> findAll(String search) {
		Connection conn = jdbcUtil.getConnection();
		String sql = "select * from book  where bookName like \"%"+ search+"%\"";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Book> books = new ArrayList<Book>();

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				String ISBN = rs.getString(1);
				String bookName = rs.getString(2);
				String author = rs.getString(3);
				String publisher = rs.getString(4);
				Date pTime = rs.getDate(5);
				int editNum = rs.getInt(6);
				float price = rs.getFloat(7);
				int cNum = rs.getInt(8);
				int lNum = rs.getInt(9);
				int sNum = rs.getInt(10);
				Date byeInTime = rs.getDate(11);
				String summary = rs.getString(12);

				Book b = new Book(ISBN, bookName, author, publisher, pTime,
						editNum, price, cNum, lNum, sNum, byeInTime, summary,
						null);
				books.add(b);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

}
