package com.king.dao;

import java.awt.Image;
import java.awt.Toolkit;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Book t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Book t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Book findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
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
